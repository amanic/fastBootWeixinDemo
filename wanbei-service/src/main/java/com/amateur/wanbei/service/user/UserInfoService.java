package com.amateur.wanbei.service.user;

import com.amateur.wanbei.service.bean.UserInfoVO;
import com.amateur.wanbei.service.common.ResultApi;

public interface UserInfoService {

    ResultApi<UserInfoVO> getUserInfo();

    void saveInfo(UserInfoVO userInfoVO);

    void editInfo(UserInfoVO userInfoVO);
}
