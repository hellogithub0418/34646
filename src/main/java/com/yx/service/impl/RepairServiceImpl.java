package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.RepairMapper;
import com.yx.model.Repair;

import com.yx.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements RepairService {

    @Autowired
    private RepairMapper repairDao;
    @Override
    public PageInfo<Repair> findRepairAll(int page, int pagesize, Repair repair) {
        PageHelper.startPage(page,pagesize);
        List<Repair> list=repairDao.queryListAll(repair);
        PageInfo<Repair> pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<Repair> queryListAll() {
        return repairDao.queryListAll(null);
    }


    @Override
    public IPage<Repair> findListByPage(Integer page, Integer pageCount){
        IPage<Repair> wherePage = new Page<>(page, pageCount);
        Repair where = new Repair();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Repair repair){
        return baseMapper.insert(repair);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Repair repair){
        return baseMapper.updateById(repair);
    }

    @Override
    public Repair findById(Long id){
        return  baseMapper.selectById(id);
    }

   
}
