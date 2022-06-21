package com.yx.dao;
import java.util.List;
import com.yx.model.Building;

public interface BuildingMapper {
    List<Building> findBuildAll(int page,int pageSize,String numbers);
    public int updateData(Building building);
    int add(Building building);
	int delete(Building building);
}
