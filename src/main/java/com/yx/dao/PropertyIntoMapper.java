package com.yx.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.PropertyInto;


@Component("PropertyIntoDao")
public interface PropertyIntoMapper extends BaseMapper<PropertyInto> {
	//List<PropertyInfo> queryPropertyInfoAll(PropertyInfo propertyInfo);
	List<PropertyInto> queryListAll(PropertyInto propertyInto);
}