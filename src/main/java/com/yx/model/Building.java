package com.yx.model;

import java.io.Serializable;

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
	@TableId(value = "building_id")
	private Integer buildingId;
	private String buildingName;
	private String uints;
	private String remarks;

	public Building(Integer buildingId) {
		super();
		this.buildingId = buildingId;
	}

	public Building() {
		super();
	}

}
