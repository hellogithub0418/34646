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
@ApiModel(value = "Repair对象",description ="" )
public class Repair implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6929869583824216663L;
	@TableId(value = "repair_id", type = IdType.AUTO)
	private Integer repair_id;
	private Integer building_id;
	private String problem;
	private Date report_time;
	private Date handle_time;
	private Integer status;
	private String remarks;
	public Repair(Integer repair_id) {
		super();
		this.repair_id = repair_id;
	}



	public Repair() {
		super();
	}
}
