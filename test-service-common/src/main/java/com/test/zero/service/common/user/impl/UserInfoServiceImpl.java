package com.test.zero.service.common.user.impl;

import com.test.zero.dal.user.UserInfoDaoIF;
import com.test.zero.model.entity.user.UserInfoEntity;
import com.test.zero.service.common.user.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zero on 2017/11/25.
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDaoIF userInfoDao;
    @Override
    public List<UserInfoEntity> findUserInfo() {
        log.info("s鸿上尚史黄金首饰");
        return userInfoDao.findUserInfo();
    }

    @Override
    public UserInfoEntity getUserInfoById(int id) {
        return userInfoDao.getUserInfoById(id);
    }

    @Override
    public int addUserInfo(UserInfoEntity userInfoEntity) {
        return userInfoDao.addUserInfo(userInfoEntity);
    }
}
