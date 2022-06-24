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
import com.yx.dao.RepairCostMapper;
import com.yx.model.RepairCost;
import com.yx.service.RepairCostService;
@Service
public class RepairCostServiceImpl extends ServiceImpl<RepairCostMapper, RepairCost> implements RepairCostService
{

    @Autowired
    private RepairCostMapper repairCostDao;
    @Override
    public PageInfo<RepairCost> findRepairAll(int page, int pagesize, RepairCost repairCost) {
        PageHelper.startPage(page,pagesize);
        List<RepairCost> list=repairCostDao.queryRepairCostAll(repairCost);
        PageInfo<RepairCost> pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<RepairCost> queryList() {
        return repairCostDao.queryRepairCostAll(null);
    }


    @Override
    public IPage<RepairCost> findListByPage(Integer page, Integer pageCount){
        IPage<RepairCost> wherePage = new Page<>(page, pageCount);
        RepairCost where = new RepairCost();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(RepairCost repairCost){
        return baseMapper.insert(repairCost);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(RepairCost repairCost){
        return baseMapper.updateById(repairCost);
    }

    @Override
    public RepairCost findById(Long id){
        return  baseMapper.selectById(id);
    }

   
}