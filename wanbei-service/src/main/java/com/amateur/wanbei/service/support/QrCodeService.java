package com.amateur.wanbei.service.support;

import java.util.List;

import com.amateur.wanbei.dao.entity.WbUserLoan;
import com.amateur.wanbei.service.bean.HeadUserLoanVO;
import com.amateur.wanbei.service.bean.WbUserLoanVO;
import com.amateur.wanbei.service.common.ResultApi;

/**
 * Created by chenhaitao on 2018/6/8.
 */
public interface QrCodeService {

    /**
     * 生成二维码，扫描二维码直接跳转链接
     * @param url 需要跳转的链接
     * @param logoPath LOGO地址
     * @param destPath 文件存储目标地址
     * @param needCompress 是否需要压缩，建议压缩
     * @param fileName 文件名（二维码图片名称）
     * @return 返回文件地址
     */
    String  generateQRCode(String url, String logoPath, String destPath, Boolean needCompress, String fileName);

    /**
     * 生成并发送二维码
     * @param wbUserLoanVO
     * @return
     */
    ResultApi sendQrCode(WbUserLoanVO wbUserLoanVO);

    /**
     * 读取相应的合同
     * @param i
     * @return
     */
    ResultApi<WbUserLoanVO> readQrCode(Integer i);

    /**
     * 确认合同
     * @param i
     * @return
     */
    ResultApi confirm(Integer i);

    /**
     * 查询用户合同列表
     * @param headUserLoanVO
     * @return
     */
    ResultApi<List<WbUserLoanVO>> getUserLoanList(HeadUserLoanVO headUserLoanVO);
}
