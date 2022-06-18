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
	@TableId(value = "park_id", type = IdType.AUTO)
	private Integer park_id;
	private String numbers;
	private Integer status;
	private Integer owner_id;
	private String remarks;
	
	public Parking(Integer park_id) {
		super();
		this.park_id = park_id;
	}



	public Parking() {
		super();
	}
}
