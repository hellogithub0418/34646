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
@ApiModel(value = "PropertyType对象",description ="" )
public class PropertyType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5786019965443618220L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String name;
	private double price;
	private String unit;
	private String remarks;
	public PropertyType(Integer id) {
		super();
		this.id = id;
	}



	public PropertyType() {
		super();
	}
}
