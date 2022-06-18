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
@ApiModel(value = "Complaint对象",description ="" )
public class Complaint implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8188070889290007780L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private Integer comId;
	@JsonFormat(pattern = "yyyy-MM-dd ",timezone = "GMT+8")
	private Date comDate;
	@JsonFormat(pattern = "yyyy-MM-dd ",timezone = "GMT+8")
	private Date handleDate;
	private Integer ownerId;
	private Integer status;
	private Integer handler;
	private String remarks;
	
	public Complaint(Integer id) {
		super();
		this.id = id;
	}



	public Complaint() {
		super();
	}
}
