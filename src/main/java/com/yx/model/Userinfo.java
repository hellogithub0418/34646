package com.yx.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 实体类，与数据库中的属性值基本保持一致
 * 当@EqualsAndHashCode(callSuper = false)时不会比较其继承的父类的属性可能会导致错误判断
 * @author 34646
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Userinfo对象", description="")
public class Userinfo implements Serializable {

   

    /**
	 * 
	 */
	private static final long serialVersionUID = -8937613975242900951L;

	@TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Integer type;

    private String remarks;


}
