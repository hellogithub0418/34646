package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.ClockinnewMapper;
import com.yx.model.Clockinnew;
import com.yx.service.ClockInNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author 34646
 *
 */
@Service
public class ClockInNewServiceImpl extends ServiceImpl<ClockinnewMapper, Clockinnew> implements ClockInNewService {

    @Autowired
    private ClockinnewMapper clockInNewDao;

    @Override
    public PageInfo<Clockinnew> queryClockInAll(int pageNum, int pageSize, Clockinnew clockinnew) {
        PageHelper.startPage(pageNum,pageSize);
        List<Clockinnew> list = clockInNewDao.queryClockInAll(clockinnew);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Clockinnew> findListByPage(Integer page, Integer pageCount){
        IPage<Clockinnew> wherePage = new Page<>(page, pageCount);
        Clockinnew where = new Clockinnew();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Clockinnew clockinnew){
        return baseMapper.insert(clockinnew);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Clockinnew clockinnew){
        return baseMapper.updateById(clockinnew);
    }

    @Override
    public Clockinnew findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Date queryCountByOwnId(Integer ownerId) {
        return clockInNewDao.queryCountByOwnId(ownerId);
    }
}
