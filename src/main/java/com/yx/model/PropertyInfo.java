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
	
	//表之间关联
	private Building building;
	private  House house;
    private  Owner owner;
    private PropertyType ptype;
	
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	private Integer type;
	private Double price;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date time;
	private Integer status;
	private Integer houseId;
	private String remarks;

}
