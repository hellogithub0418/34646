package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.House;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("houseDao")
public interface HouseMapper extends BaseMapper<House> {

    /**
     * 查询
     */

    List<House> findHouseAll(@Param("numbers") String numbers);
    
    //int queryCountH(@Param("buildingId")Integer buildingId);

    /**
     * 通过owner中house_id查找house
     */
    House queryHouseById(@Param("houId") Integer houId);
    
    /**
     * 通过buildingId查询houseId
     * 
     */
    List<House> queryHouseIdByBid(@Param("buildingId") Integer buildingId);
}
