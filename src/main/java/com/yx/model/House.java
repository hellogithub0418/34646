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
	@TableId(value = "houseId", type = IdType.AUTO)
	private Integer houseId;
	private String numbers;
	private Integer status;
	private Date intoDate;
	private Integer buildingId;
	private String remarks;
	private double area;
	public House(Integer houseId) {
		super();
		this.houseId = houseId;
	}



	public House() {
		super();
	}
}
