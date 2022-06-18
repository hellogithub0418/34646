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
@ApiModel(value = "Parking对象",description ="" )
public class Parking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4252853808327570363L;
	@TableId(value = "parkId", type = IdType.AUTO)
	private Integer parkId;
	private String numbers;
	private Integer status;
	private Integer ownerId;
	private String remarks;
	
	public Parking(Integer parkId) {
		super();
		this.parkId = parkId;
	}



	public Parking() {
		super();
	}
}
