package com.yx.service;

import java.util.List;

import com.yx.model.Building;

public interface BuildingService {
	List<Building> findBuildAll(int page,int pageSize,String numbers);
	int updateData(Building building);
	int add(Building building);
	int delete(Building building);
}
