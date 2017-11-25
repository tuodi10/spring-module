package com.test.zero.dal.user;

import com.test.zero.config.DataSource;
import com.test.zero.model.entity.user.UserInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.test.zero.common.utils.CommonConstant.DataSourceRead;
@Repository
public interface UserInfoDaoIF{

     @DataSource(DataSourceRead)
     List<UserInfoEntity> findUserInfo();
     @DataSource(DataSourceRead)
     UserInfoEntity getUserInfoById(int id);
     int addUserInfo (UserInfoEntity userInfoEntity);
     //List<Map<String,Object>>testMap();
   

}
