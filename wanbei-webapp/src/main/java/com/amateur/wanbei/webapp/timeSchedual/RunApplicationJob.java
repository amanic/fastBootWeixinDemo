package com.amateur.wanbei.webapp.timeSchedual;

import com.amateur.wanbei.dao.mapper.WbUserLoanMapper;
import com.amateur.wanbei.service.module.message.WxMessage;
import com.amateur.wanbei.service.module.message.WxMessageBody;
import com.amateur.wanbei.service.module.message.WxMessageTemplate;
import com.amateur.wanbei.service.module.message.WxUserMessage;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**定时任务模板
 * Created by chenhaitao on 2018/6/6.
 */
@Component
@Slf4j
public class RunApplicationJob {
    
    @Autowired
    private WbUserLoanMapper wbUserLoanMapper;
    @Autowired
    WxMessageTemplate wxMessageTemplate;

    //每半个小时执行一次
    @Scheduled(cron = "0 0/30 * * * ?")
    public void doMySchedual(){
        List<Map> maps = wbUserLoanMapper.jobSql();
        if (CollectionUtils.isEmpty(maps)){
            log.info("没有可执行的数据");
        }else{
            for (Map map:maps){
                WxMessageBody.News.Item  item = new WxMessageBody.News.Item();
                item.setTitle("还款到期通知");
                item.setDescription("尊敬的"+map.get("borrower_name")+",您有一笔 "+map.get("loan_amount")+"将在"+map.get("repay_time")+"到期");
                WxUserMessage wxUserMessage = WxMessage.News.builder().addItem(item).build();
                wxMessageTemplate.sendMessage(map.get("open_id").toString(), wxUserMessage);
            }
        }
    }
}
