package com.yx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yx.dao.BuildingMapper;
import com.yx.model.Building;
import com.yx.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingMapper mapper;
	@Override
	public List<Building> findBuildAll(int page, int pageSize, String numbers) {
		// TODO Auto-generated method stub
		return mapper.findBuildAll(page, pageSize, numbers);
	}
	@Override
	public int updateData(Building building) {
		// TODO Auto-generated method stub
		return mapper.updateData(building);
	}
	@Override
	public int add(Building building) {
		// TODO Auto-generated method stub
		return mapper.add(building);
	}
	@Override
	public int delete(Building building) {
		// TODO Auto-generated method stub
		return mapper.delete(building);
	}

	
}
