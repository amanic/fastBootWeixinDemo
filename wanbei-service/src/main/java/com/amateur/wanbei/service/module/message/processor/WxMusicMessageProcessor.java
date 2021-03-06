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

package com.amateur.wanbei.service.module.message.processor;

import com.amateur.wanbei.service.module.media.WxMediaManager;
import com.amateur.wanbei.service.module.message.WxMessageBody;
import com.amateur.wanbei.service.module.message.parameter.WxMessageParameter;

/**
 * FastBootWeixin WxGroupMusicMessageProcessor
 *
 * @author Guangshan
 * @date 2017/8/20 22:53
 * @since 0.1.2
 */
public class WxMusicMessageProcessor extends AbstractWxMediaMessageProcessor<WxMessageBody.Music> {

    public WxMusicMessageProcessor(WxMediaManager wxMediaManager) {
        super(wxMediaManager);
    }

    @Override
    protected WxMessageBody.Music processBody(WxMessageParameter wxMessageParameter, WxMessageBody.Music body) {
        super.processBody(wxMessageParameter, body);
        return body;
    }

}
