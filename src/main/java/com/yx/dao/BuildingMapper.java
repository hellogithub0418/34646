package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Building;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("buildingDao")
public interface BuildingMapper extends BaseMapper<Building> {

    List<Building> queryBuildAll(@Param("numbers") String numbers);

    /**
     * 通过house中building_id查找building
     */
    Building queryBuildById(@Param("buildId") Integer buildId);
}
