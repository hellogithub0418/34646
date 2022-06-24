package com.yx.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.javassist.tools.framedump;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Carcharge对象",description ="" )
public class Carcharge implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6808534042237201254L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date payDate;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date endDate;
	private double money;
	private Integer status;
	private String remarks;
	private String type;
	private Integer parkId;
	
	@TableField(exist = false)
	private Owner owner;
	@TableField(exist = false)
	private Integer ownerId;
	
	@TableField(exist = false)
    private Parking parking;//停车位
	
	@TableField(value = "park_id")
    private Integer parkingId;
    
    @TableField(exist = false)
    private String username;
    
    @TableField(exist = false)
    private String numbers;
}
