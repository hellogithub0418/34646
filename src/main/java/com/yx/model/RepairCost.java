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
@ApiModel(value = "RepairCost对象",description ="" )
public class RepairCost implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3336553355332433913L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private Integer repairId;
	private double price;
	private String remarks;
	public RepairCost(Integer id) {
		super();
		this.id = id;
	}



	public RepairCost() {
		super();
	}
}
