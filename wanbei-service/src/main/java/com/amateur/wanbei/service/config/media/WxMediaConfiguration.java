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

package com.amateur.wanbei.service.config.media;

import com.amateur.wanbei.service.module.media.WxMediaManager;
import com.amateur.wanbei.service.module.media.WxMediaStore;
import com.amateur.wanbei.service.service.WxApiService;
import com.amateur.wanbei.service.service.invoker.executor.WxApiTemplate;
import com.amateur.wanbei.service.support.MapDbWxMediaStore;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.lang.invoke.MethodHandles;

/**
 * FastBootWeixin WxMediaConfiguration
 *
 * @author Guangshan
 * @date 2017/09/21 23:31
 * @since 0.1.2
 */
@Configuration
public class WxMediaConfiguration {

    private static final Log logger = LogFactory.getLog(MethodHandles.lookup().lookupClass());

//	private final WxApiService wxApiInvokeSpi;
//
//	private final WxApiTemplate wxApiInvoker;
//
//	public WxMediaConfiguration(WxApiService wxApiInvokeSpi, WxApiTemplate wxApiInvoker) {
//		this.wxApiInvokeSpi = wxApiInvokeSpi;
//		this.wxApiTemplate = wxApiTemplate;
//	}

    @Bean
    @ConditionalOnMissingBean
    public WxMediaStore wxMediaStore() {
        return new MapDbWxMediaStore();
    }

    @Bean
    public WxMediaManager wxMediaManager(@Lazy WxApiService wxApiService, @Lazy WxApiTemplate wxApiTemplate) {
        return new WxMediaManager(wxApiService, wxApiTemplate, wxMediaStore());
    }

}
