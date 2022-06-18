package com.yx.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "House对象",description ="" )
public class House implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2513810280804509952L;
	@TableId(value = "house_id", type = IdType.AUTO)
	private Integer house_id;
	private String numbers;
	private Integer status;
	private Date into_date;
	private Integer building_id;
	private String remarks;
	private double area;
	public House(Integer house_id) {
		super();
		this.house_id = house_id;
	}



	public House() {
		super();
	}
}
