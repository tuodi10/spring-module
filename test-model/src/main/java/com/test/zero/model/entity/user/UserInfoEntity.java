package com.test.zero.model.entity.user;

import com.test.zero.model.entity.base.Entity;
import lombok.Data;


@Data
public class UserInfoEntity extends Entity {
	private String name;
	private String sex;

}
