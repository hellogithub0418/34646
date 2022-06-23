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
	@TableId(value = "id")
	private Integer id;
	private String name;
	private String remarks;
}
