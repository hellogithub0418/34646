package com.yx.model;

import java.io.Serializable;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Owner对象",description ="" )
public class Owner implements Serializable{
	/**
	 * @TableId注解是专门用在主键上的注解，
	 * 如果数据库中的主键字段名和实体中的属性名，
	 * 不一样且不是驼峰之类的对应关系，可以在实体中表示主键的属性上加@Tableid注解，
	 * 并指定@Tableid注解的value属性值为表中主键的字段名既可以对应上。
	 */
	@TableId(value = "owner_id",type = IdType.AUTO)
	private Integer ownerId;
	private String username;
	private String tel;
	private String sex;
	private String identity;
	private Integer houseId;
	private String remarks;
	private String password;
	
    //房屋信息
    private House house;
    
    //楼宇信息
    private Building building;
}
