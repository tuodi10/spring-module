package com.test.zero.model.entity.base;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 基类
 * @author lwp
 *
 */
@Data
public class Entity implements Serializable{


    private static final long serialVersionUID = -7405302224020576330L;
    /** id */
    protected int id;

    /** 创建时间 */
    protected Date createTime;

    /** 更新时间 */
    protected Date updateTime;

    /** 删除标示 */
    protected int delete;

    protected int version;

}
