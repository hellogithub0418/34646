package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.OwnerMapper;
import com.yx.model.Owner;
import com.yx.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author 34646
 *
 */
@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements OwnerService {

    @Autowired
    private OwnerMapper ownerMapper;
    @Override
    public PageInfo<Owner> findOwnerAll(int page, int pagesize, Owner owner) {
        PageHelper.startPage(page,pagesize);
        List<Owner> list=ownerMapper.queryOwnerAll(owner);
        PageInfo<Owner> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public IPage<Owner> findListByPage(Integer page, Integer pageCount){
        IPage<Owner> wherePage = new Page<>(page, pageCount);
        Owner where = new Owner();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }


    @Override
    public int add(Owner owner){
        return baseMapper.insert(owner);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Owner owner){
        return baseMapper.updateById(owner);
    }

    @Override
    public Owner findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Owner queryOwnerById(long parseLong) {
        return ownerMapper.queryOwnerById(parseLong);
    }
    
    @Override
    public void deleteOwnerByOwnerIds(Integer id) {
        ownerMapper.deleteOwnerByOwnerIds(id);
    }
    

}
