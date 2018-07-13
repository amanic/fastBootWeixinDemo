package com.amateur.wanbei.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amateur.wanbei.dao.entity.WbUserLoan;
import com.amateur.wanbei.dao.entity.WbUserProfile;
import com.amateur.wanbei.dao.mapper.WbUserLoanMapper;
import com.amateur.wanbei.service.bean.HeadUserLoanVO;
import com.amateur.wanbei.service.bean.WbUserLoanVO;
import com.amateur.wanbei.service.common.ResultApi;
import com.amateur.wanbei.service.module.message.WxMessage;
import com.amateur.wanbei.service.module.message.WxMessageTemplate;
import com.amateur.wanbei.service.module.message.WxUserMessage;
import com.amateur.wanbei.service.support.QrCodeService;
import com.amateur.wanbei.service.util.WxWebUtils;
import com.amateur.wanbei.util.BeanToMapUtil;
import com.amateur.wanbei.util.DateUtil;
import com.amateur.wanbei.util.QRCodeUtil;
import com.amateur.wanbei.util.UserInfoUtil;

import lombok.extern.slf4j.Slf4j;


/**
 * Created by chenhaitao on 2018/6/8.
 */
@Slf4j
@Service
public class QrCodeServiceImpl implements QrCodeService {


    @Autowired
    WbUserLoanMapper wbUserLoanMapper;

    @Autowired
    WxMessageTemplate wxMessageTemplate;

    @Autowired
    UserInfoUtil userInfoUtil;

    @Override
    public String generateQRCode(String url, String logoPath, String destPath, Boolean needCompress, String fileName) {
        try {
            QRCodeUtil.encode(url, logoPath, destPath, true,fileName);
            return destPath+"/"+fileName+".jpg";
        } catch (Exception e) {
            log.error("生成二维码失败。");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResultApi sendQrCode(WbUserLoanVO wbUserLoanVO) {
        String openId = WxWebUtils.getWxWebUserFromSession().getOpenId();
//          给前端提供一个获取用户信息的借口
        WbUserProfile wbUserProfile = userInfoUtil.getCurrentUser(openId);
        WbUserLoan wbUserLoan = new WbUserLoan();
        if(null==wbUserProfile){
            return ResultApi.fail("获取用户出错。");
        }
        wbUserLoan.setUid(wbUserProfile.getId());
        wbUserLoan.setLoanAmount(wbUserLoanVO.getLoanAmount());
        wbUserLoan.setLoanStartTime(DateUtil.convert2Date(wbUserLoanVO.getLoanStartTime(),"yyyy-MM-dd"));
        wbUserLoan.setLoanEndTime(DateUtil.convert2Date(wbUserLoanVO.getLoanEndTime(),"yyyy-MM-dd"));
        wbUserLoan.setName(wbUserLoanVO.getName());
        wbUserLoan.setLoanName(wbUserLoanVO.getLoanName());
        wbUserLoanMapper.insertSelective(wbUserLoan);
        int i = wbUserLoan.getId();
        String file = "";
        if(i==0){
            log.error("插入合同失败。");
            return ResultApi.fail("新增合同失败");
        }
        try {
            QRCodeUtil.encode("http://haron.natapp1.cc/index.html/#/dealView?id="+i, null, "/Users/chenhaitao/Desktop/temp", true,openId+"-"+i);
            file = "/Users/chenhaitao/Desktop/temp/"+openId+"-"+i+".jpg";
        } catch (Exception e) {
            log.error("生成出借二维码出错：wbUserLoan={},openId={}",wbUserLoan.toString(),openId,e);
            return ResultApi.fail("生成合同失败");
        }
        WxUserMessage wxUserMessage = WxMessage.imageBuilder().mediaPath(file).build();
        wxMessageTemplate.sendMessage(openId, wxUserMessage);
        return ResultApi.success();
    }

    @Override
    public ResultApi<WbUserLoanVO> readQrCode(Integer i) {
        WbUserLoan wbUserLoan = wbUserLoanMapper.selectByPrimaryKey(i);
        if (null==wbUserLoan){
            log.error("根据id：{}获取不到相应的合同。",i);
            return ResultApi.fail("订单获取出错。");
        }else {
            WbUserLoanVO wbUserLoanVO = new WbUserLoanVO();
            wbUserLoanVO.setLoanEndTime(DateUtil.convert2String(wbUserLoan.getLoanEndTime(),"yyyy-MM-dd HH:mm:ss"));
            wbUserLoanVO.setLoanStartTime(DateUtil.convert2String(wbUserLoan.getLoanStartTime(),"yyyy-MM-dd HH:mm:ss"));
            wbUserLoanVO.setName(wbUserLoan.getName());
            wbUserLoanVO.setLoanName(wbUserLoan.getLoanName());
            wbUserLoanVO.setLoanAmount(wbUserLoan.getLoanAmount());
            wbUserLoanVO.setId(wbUserLoan.getId());
            return ResultApi.success(wbUserLoanVO);
        }
    }

    @Override
    public ResultApi confirm(Integer i) {
        String openId = WxWebUtils.getWxWebUserFromSession().getOpenId();
        WbUserLoan wbUserLoan = wbUserLoanMapper.selectByPrimaryKey(i);
        if(null==wbUserLoan||wbUserLoan.getLoanType()==1){
            log.error("确认协议出错：wbUserLoan={}",wbUserLoan.toString());
            return ResultApi.fail("确认协议不存在或已被确认。");
        }
        WbUserProfile wbUserProfile = userInfoUtil.getCurrentUser(openId);
        if(null==wbUserProfile){
            return ResultApi.fail("获取用户出错。");
        }
        wbUserLoan.setId(i);
        wbUserLoan.setLoanUid(wbUserProfile.getId());
        wbUserLoan.setLoanType(1);
        wbUserLoanMapper.updateByPrimaryKeySelective(wbUserLoan);
        return ResultApi.success();
    }

	@Override
	public ResultApi<List<WbUserLoanVO>> getUserLoanList(HeadUserLoanVO headUserLoanVO) {
		String openId = WxWebUtils.getWxWebUserFromSession().getOpenId();
		//      给前端提供一个获取用户信息的借口
	    WbUserProfile wbUserProfile = userInfoUtil.getCurrentUser(openId);
	    if(null==wbUserProfile){
	        ResultApi api = ResultApi.fail("请先填写个人信息。");
	        api.setCode(1);
	        return api;
	    }
	    Map<String ,Object> map = new HashMap<String ,Object>();
	    map.put("delete", 0);//查询正常状态
        if(null!=headUserLoanVO.getName()&&!headUserLoanVO.getName().equals("")&&headUserLoanVO.getType()==1){
            map.put("name", headUserLoanVO.getName());
        }
        if(null!=headUserLoanVO.getLoanName()&&!headUserLoanVO.getLoanName().equals("")&&headUserLoanVO.getType()==0){
            map.put("loanName", headUserLoanVO.getLoanName());
        }
	    if(headUserLoanVO.getType() == 0) {
	    		map.put("uid", wbUserProfile.getId());
	    }else {
	    		map.put("loanUid", wbUserProfile.getId());
	    }
	    map.put("pageDB", (headUserLoanVO.getPage()-1)*headUserLoanVO.getSize());
	    map.put("size", headUserLoanVO.getSize());
	    map.put("order", headUserLoanVO.getOrder());
	    map.put("sort", "loan_end_time");
	    map.put("loanType", headUserLoanVO.getLoanType());
		List<WbUserLoan> list = wbUserLoanMapper.getUserLoanList(map);
		List<WbUserLoanVO> newList = new ArrayList<WbUserLoanVO>();
		if(list !=null&&list.size() > 0) {
			for (WbUserLoan wbUserLoan2 : list) {
				WbUserLoanVO vo = new WbUserLoanVO();
				BeanUtils.copyProperties(wbUserLoan2,vo);
				vo.setCreateTime(DateUtil.convert2String(wbUserLoan2.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));
				newList.add(vo);
			}
		}
		Integer total = wbUserLoanMapper.countUserLoanList(map);
		return ResultApi.success("成功！", newList, total);
	}
    
}
