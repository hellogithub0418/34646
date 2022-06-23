package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.PropertyInfoMapper;
import com.yx.model.PropertyInfo;
import com.yx.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service的impl是把mapper和service进行整合的文件。
 * @author 34646
 *
 */
@Service
public class PropertyInfoServiceImpl extends ServiceImpl<PropertyInfoMapper, PropertyInfo> implements PropertyService {
    @Autowired
    private PropertyInfoMapper propertyInfoMapper;


    @Override
    public IPage<PropertyInfo> findListByPage(Integer page, Integer pageCount){
        IPage<PropertyInfo> wherePage = new Page<>(page, pageCount);
        PropertyInfo where = new PropertyInfo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public PageInfo<PropertyInfo> findPropertyInfoAll(int page, int pageSize, PropertyInfo propertyInfo) {
        PageHelper.startPage(page,pageSize);
        //查询的结果集
        List<PropertyInfo> list=propertyInfoMapper.queryListAll(propertyInfo);
        PageInfo<PropertyInfo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int add(PropertyInfo propertyInfo){
        return baseMapper.insert(propertyInfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(PropertyInfo propertyInfo){
        return baseMapper.updateById(propertyInfo);
    }

    @Override
    public PropertyInfo findById(Long id){
        return  baseMapper.selectById(id);
    }

}
