package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.model.PropertyType;

import java.util.List;

/**
 * 
 * @author 34646
 *
 */
public interface PropertyTypeService extends IService<PropertyType> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<PropertyType>
     */
    IPage<PropertyType> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param propertyType 
     * @return int
     */
    int add(PropertyType propertyType);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param propertyType 
     * @return int
     */
    int updateData(PropertyType propertyType);

    /**
     * id查询数据
     *
     * @param id id
     * @return PropertyType
     */
    PropertyType findById(Long id);


    List<PropertyType> findAll();
}
