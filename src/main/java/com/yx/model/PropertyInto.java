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
@ApiModel(value = "PropertyInto对象",description ="" )
public class PropertyInto implements Serializable{
	/**
	 * 
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date time;
	private Integer type;
	private Double price;
	private Integer buildingId;
	private String remarks;

}
