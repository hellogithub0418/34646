package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.UserinfoMapper;
import com.yx.model.Userinfo;
import com.yx.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service的impl是把mapper和service进行整合的文件。
 * @author 34646
 *
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;


    @Override
    public IPage<Userinfo> findListByPage(Integer page, Integer pageCount){
        IPage<Userinfo> wherePage = new Page<>(page, pageCount);
        Userinfo where = new Userinfo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public PageInfo<Userinfo> findUserinfoAll(int page, int pageSize, Userinfo userinfo) {
        PageHelper.startPage(page,pageSize);
        //查询的结果集
        List<Userinfo> list=userinfoMapper.queryUserinfoAll(userinfo);
        PageInfo<Userinfo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int add(Userinfo userinfo){
        return baseMapper.insert(userinfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Userinfo userinfo){
        return baseMapper.updateById(userinfo);
    }

    @Override
    public Userinfo findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Userinfo queryUserByNameAndPwd(Userinfo userinfo) {
        return userinfoMapper.queryUserByNameAndPwd(userinfo);
    }

    @Override
    public void deleteUserByUsername(String username) {
        userinfoMapper.deleteUserByUsername(username);
    }
}
