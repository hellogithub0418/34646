package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.PropertyInfo;
import com.yx.model.Userinfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 数据库进行数据持久化操作，方法语句是直接针对数据库操作
 * @author 34646
 *
 */
@Component("PropertyInfoDao")
public interface PropertyInfoMapper extends BaseMapper<PropertyInfo> {
	//List<PropertyInfo> queryPropertyInfoAll(PropertyInfo propertyInfo);
	List<PropertyInfo> queryListAll(PropertyInfo propertyInfo);
}
