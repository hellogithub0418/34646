package com.yx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.CarchargeMapper;
import com.yx.model.Carcharge;
import com.yx.model.ComplaintType;
import com.yx.service.CarchargeService;


@Service
public class CarchargeServiceImpl extends ServiceImpl<CarchargeMapper, Carcharge> implements CarchargeService{

    @Autowired
    private CarchargeMapper carchargeDao;


    @Override
    public PageInfo<Carcharge> findCarchargeAll(int page, int pagesize, Carcharge carcharge) {
        PageHelper.startPage(page,pagesize);
        List<Carcharge> list=carchargeDao.queryCarChargeAll(carcharge);
        PageInfo<Carcharge> pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public IPage<Carcharge> findListByPage(Integer page, Integer pageCount){
        IPage<Carcharge> wherePage = new Page<>(page, pageCount);
        Carcharge where = new Carcharge();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Carcharge carcharge){
        return baseMapper.insert(carcharge);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Carcharge carcharge){
        return baseMapper.updateById(carcharge);
    }

    @Override
    public Carcharge findById(Long id){
        return  baseMapper.selectById(id);
    }
    @Override
    public List<Carcharge> queryCarcharge() {
        return baseMapper.queryCarChargeAll(null);
    }
}