package com.test.zero.service.common.user;

import com.test.zero.model.entity.user.UserInfoEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/11/25.
 */
public interface UserInfoService {

    List<UserInfoEntity> findUserInfo();
    UserInfoEntity getUserInfoById(int id);
    int addUserInfo (UserInfoEntity userInfoEntity);
}
