package com.yx.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "PropertyInfo对象",description ="" )
public class PropertyInfo implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -3618922690170478332L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private Integer type;
	private double price;
	@JsonFormat(pattern = "yyyy-MM-dd ",timezone = "GMT+8")
	private Date time;
	private Integer status;
	private Integer houseId;
	private String remarks;
	public PropertyInfo(Integer id) {
		super();
		this.id = id;
	}



	public PropertyInfo() {
		super();
	}
}
