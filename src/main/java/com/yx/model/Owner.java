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
	@TableId(value = "owner_id", type = IdType.AUTO)
	private Integer owner_id;
	private String username;
	private String tel;
	private String sex;
	private String identity;
	private Integer house_id;
	private String remarks;
	private String password;
	public Owner(Integer owner_id) {
		super();
		this.owner_id = owner_id;
	}



	public Owner() {
		super();
	}
}
