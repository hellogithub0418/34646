package com.yx.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.bytebuddy.description.modifier.Ownership;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Parking对象", description = "")
public class Parking implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId(value = "park_id", type = IdType.AUTO)
	private Integer parkingId;
	private String numbers;
	private Integer status;
	private String remarks;
	
	//查询数据时用
	private Owner owner;
	
	@TableField(value = "owner_id")
	private Integer ownerId;

}
