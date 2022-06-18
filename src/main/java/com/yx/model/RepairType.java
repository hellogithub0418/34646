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
@ApiModel(value = "RepairType对象",description ="" )
public class RepairType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3773157029143932183L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String name;
	private String remarks;
	private Integer status;
	public RepairType(Integer id) {
		super();
		this.id = id;
	}



	public RepairType() {
		super();
	}
}
