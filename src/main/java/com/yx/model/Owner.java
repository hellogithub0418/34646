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
	 * 
	 */
	private static final long serialVersionUID = -3748155191525529253L;
	@TableId(value = "ownerId", type = IdType.AUTO)
	private Integer ownerId;
	private String username;
	private String tel;
	private String sex;
	private String identity;
	private Integer houseId;
	private String remarks;
	private String password;
	public Owner(Integer ownerId) {
		super();
		this.ownerId = ownerId;
	}



	public Owner() {
		super();
	}
}
