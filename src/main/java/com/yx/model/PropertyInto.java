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
@ApiModel(value = "PropertyInto对象",description ="" )
public class PropertyInto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5861444599335324900L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private Date time;
	private Integer type;
	private double price;
	private Integer buildingId;
	private String remarks;
	public PropertyInto(Integer id) {
		super();
		this.id = id;
	}



	public PropertyInto() {
		super();
	}
}
