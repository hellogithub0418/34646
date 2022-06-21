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
@ApiModel(value = "Building对象",description ="" )
public class Building implements Serializable{
	
	
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -2439935264510908737L;
//	@TableId(value = "buildingId", type = IdType.AUTO)
	
	
	private Integer buildingId;
	private String buildingName;
	private String uints;
	private String remarks;

//	public Building(Integer buildingId) {
//		super();
//		this.buildingId = buildingId;
//	}
//
//	public Building() {
//		super();
//	}

}
