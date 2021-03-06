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

package com.amateur.wanbei.service.annotation;

import com.amateur.wanbei.service.config.WxProperties;
import com.amateur.wanbei.service.config.credential.WxCredentialConfiguration;
import com.amateur.wanbei.service.config.invoker.WxInvokerConfiguration;
import com.amateur.wanbei.service.config.media.WxMediaConfiguration;
import com.amateur.wanbei.service.config.message.WxAsyncMessageConfiguration;
import com.amateur.wanbei.service.config.server.WxBuildinMvcConfiguration;
import com.amateur.wanbei.service.config.server.WxWebConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.*;

/**
 * FastBootWeixin EnableWxMvc
 * PropertySource注解不能放在ConfigurationProperties注解上，否则这个注解只对当前类有效，不会写入环境中
 *
 * @author Guangshan
 * @date 2017/09/21 23:27
 * @since 0.1.2
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@PropertySource("classpath:/wx.properties")
@EnableConfigurationProperties(WxProperties.class)
@Import({WxInvokerConfiguration.class,
        WxAsyncMessageConfiguration.class,
        WxBuildinMvcConfiguration.class,
        WxCredentialConfiguration.class,
        WxMediaConfiguration.class,
        WxWebConfiguration.class})
public @interface EnableWxMvc {

    /**
     * 是否自动创建菜单
     *
     * @return the result
     */
    boolean menuAutoCreate() default true;

}
