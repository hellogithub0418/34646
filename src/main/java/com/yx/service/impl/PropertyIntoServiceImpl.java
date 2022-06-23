package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.PropertyIntoMapper;
import com.yx.model.PropertyInto;
import com.yx.service.PropertyIntoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service的impl是把mapper和service进行整合的文件。
 * @author 34646
 *
 */
@Service
public class PropertyIntoServiceImpl extends ServiceImpl<PropertyIntoMapper,PropertyInto> implements PropertyIntoService {
    @Autowired
    private PropertyIntoMapper propertyIntoMapper;


    @Override
    public IPage<PropertyInto> findListByPage(Integer page, Integer pageCount){
        IPage<PropertyInto> wherePage = new Page<>(page, pageCount);
        PropertyInto where = new PropertyInto();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public PageInfo<PropertyInto> findPropertyIntoAll(int page, int pageSize, PropertyInto propertyInto) {
        PageHelper.startPage(page,pageSize);
        //查询的结果集
        List<PropertyInto> list=propertyIntoMapper.queryListAll(propertyInto);
        PageInfo<PropertyInto> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int add(PropertyInto propertyInto){
        return baseMapper.insert(propertyInto);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(PropertyInto propertyInto){
        return baseMapper.updateById(propertyInto);
    }

    @Override
    public PropertyInto findById(Long id){
        return  baseMapper.selectById(id);
    }

}
