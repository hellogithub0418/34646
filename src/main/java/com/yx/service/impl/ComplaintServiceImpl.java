package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.ComplaintMapper;
import com.yx.model.Complaint;
import com.yx.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author 34646
 *
 */
@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {

    @Autowired
    private ComplaintMapper complaintDao;

    @Override
    public PageInfo<Complaint> findComplaintAll(int page, int pagesize, Complaint complaint) {
        PageHelper.startPage(page,pagesize);
        List<Complaint> list=complaintDao.queryComplaintAll(complaint);
        PageInfo<Complaint> pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public IPage<Complaint> findListByPage(Integer page, Integer pageCount){
        IPage<Complaint> wherePage = new Page<>(page, pageCount);
        Complaint where = new Complaint();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }



    @Override
    public int add(Complaint complaint){
        return baseMapper.insert(complaint);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Complaint complaint){
        return baseMapper.updateById(complaint);
    }

    @Override
    public Complaint findById(Long id){
        return  baseMapper.selectById(id);
    }
}
