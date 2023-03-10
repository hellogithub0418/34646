package com.yx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.HouseMapper;
import com.yx.model.House;
import com.yx.service.HouseService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService {
    @Autowired
    private HouseMapper houseDao;
    @Override
    public PageInfo<House> findHouseAll(int page, int pagesize, String numbers) {
        PageHelper.startPage(page,pagesize);
        List<House> list=houseDao.findHouseAll(numbers);
        PageInfo<House> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<House> findList() {
        return baseMapper.selectList(null);
    }

    @Override
    public IPage<House> findListByPage(Integer page, Integer pageCount){
        IPage<House> wherePage = new Page<>(page, pageCount);
        House where = new House();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(House house){
        return baseMapper.insert(house);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(House house){
        return baseMapper.updateById(house);
    }

    @Override
    public House findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public House queryHouseById(Integer houId) {
        return houseDao.queryHouseById(houId);
    }
    
    /**
     * 查询房间数量
     * @param buildingId
     * @return
     */
    @Override
    public int queryCountH(Integer buildingId) {
    	LambdaQueryWrapper<House> wrapper = Wrappers.lambdaQuery(House.class);
        wrapper.eq(House::getBuildingId	, buildingId);
        int count = baseMapper.selectCount(wrapper);
		return count;
    }
    @Override
    public List<House> queryHouseIdByBid(Integer buildingId) {
    	return houseDao.queryHouseIdByBid(buildingId);
    }
}
