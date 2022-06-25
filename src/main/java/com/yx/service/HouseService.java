package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.House;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HouseService extends IService<House> {

    /**
     * 分页查询房屋信息
     */
    PageInfo<House> findHouseAll(int page,int pagesize,String numbers);

    List<House> findList();

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<House>
     */
    IPage<House> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param house 
     * @return int
     */
    int add(House house);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param house 
     * @return int
     */
    int updateData(House house);

    /**
     * id查询数据
     *
     * @param id id
     * @return House
     */
    House findById(Long id);

    House queryHouseById(Integer houId);
    
    /**
     * 查询房间数量
     * @param buildingId
     * @return
     */
    int queryCountH(Integer buildingId);
    
    List<House> queryHouseIdByBid(@Param("buildingId") Integer buildingId);
    
}
