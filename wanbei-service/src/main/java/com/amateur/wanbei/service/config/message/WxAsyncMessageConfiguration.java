/*
 * Copyright (c) 2016-2017, Guangshan (guangshan1992@qq.com) and the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amateur.wanbei.service.config.message;

import com.amateur.wanbei.service.module.message.processor.WxMiniProgramMessageProcessor;
import com.amateur.wanbei.service.config.WxProperties;
import com.amateur.wanbei.service.module.media.WxMediaManager;
import com.amateur.wanbei.service.module.message.WxMessageProcessor;
import com.amateur.wanbei.service.module.message.WxMessageTemplate;
import com.amateur.wanbei.service.module.message.WxTemplateMessageProcessor;
import com.amateur.wanbei.service.module.message.WxUserMessageProcessor;
import com.amateur.wanbei.service.module.message.processor.*;
import com.amateur.wanbei.service.module.message.processor.group.WxGroupNewsMessageProcessor;
import com.amateur.wanbei.service.module.message.processor.user.WxUserNewsMessageProcessor;
import com.amateur.wanbei.service.module.message.support.WxAsyncMessageReturnValueHandler;
import com.amateur.wanbei.service.module.message.support.WxAsyncMessageTemplate;
import com.amateur.wanbei.service.module.message.support.WxSyncMessageReturnValueHandler;
import com.amateur.wanbei.service.service.WxApiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

/**
 * FastBootWeixin WxAsyncMessageConfiguration
 *
 * @author Guangshan
 * @date 2017/09/21 23:32
 * @since 0.1.2
 */
@Configuration
public class WxAsyncMessageConfiguration {

    private final WxProperties wxProperties;

    private final WxMediaManager wxMediaManager;

    private final WxApiService wxApiService;

    public WxAsyncMessageConfiguration(
            WxProperties wxProperties, WxMediaManager wxMediaManager, @Lazy WxApiService wxApiService) {
        this.wxProperties = wxProperties;
        this.wxMediaManager = wxMediaManager;
        this.wxApiService = wxApiService;
    }

    @Bean
    @Lazy
    public WxSyncMessageReturnValueHandler wxSyncMessageReturnValueHandler() {
        return new WxSyncMessageReturnValueHandler(wxMessageTemplate());
    }

    @Bean
    @Lazy
    public WxAsyncMessageReturnValueHandler wxAsyncMessageReturnValueHandler() {
        return new WxAsyncMessageReturnValueHandler(wxAsyncMessageTemplate());
    }

    @Bean
    public WxMessageTemplate wxMessageTemplate() {
        return new WxMessageTemplate(wxApiService, wxMessageProcessor());
    }

    @Bean
    public WxAsyncMessageTemplate wxAsyncMessageTemplate() {
        return new WxAsyncMessageTemplate(wxProperties, wxMessageTemplate());
    }

    @Bean
    public WxMessageProcessor wxMessageProcessor() {
        WxMessageProcessorChain wxMessageProcessorChain = new WxMessageProcessorChain();
        wxMessageProcessorChain.addProcessors(getDefaultProcessor(wxMediaManager));
        return wxMessageProcessorChain;
    }

    private List<WxMessageProcessor> getDefaultProcessor(WxMediaManager wxMediaManager) {
        List<WxMessageProcessor> list = new ArrayList<>();

        list.add(new WxUserMessageProcessor());
        list.add(new WxTemplateMessageProcessor());

        list.add(new WxImageMessageProcessor(wxMediaManager));
        list.add(new WxVoiceMessageProcessor(wxMediaManager));
        list.add(new WxMusicMessageProcessor(wxMediaManager));
        list.add(new WxVideoMessageProcessor(wxMediaManager));
        list.add(new WxMiniProgramMessageProcessor(wxMediaManager));

        list.add(new WxUserNewsMessageProcessor());
        list.add(new WxGroupNewsMessageProcessor());

        return list;
    }

}
