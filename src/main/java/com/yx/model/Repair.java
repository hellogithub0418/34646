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
@ApiModel(value = "Repair对象",description ="" )
public class Repair implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6929869583824216663L;
	@TableId(value = "repair_id", type = IdType.AUTO)
	private Integer repairId;
	private Integer buildingId;
	
	private String problem;
	@JsonFormat( timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date reportTime;
	@JsonFormat( timezone="GMT+8", pattern="yyyy-MM-dd")
	private Date handleTime;
	private Integer status;
	private String remarks;
	private Building building;
	private String buildingName;
	private String uints;
	private String username;
    
}
