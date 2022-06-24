package com.yx.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.RepairCost;

public interface RepairCostService extends IService<RepairCost>{

    PageInfo<RepairCost> findRepairAll(int page, int pagesise, RepairCost repairCost);

    List<RepairCost> queryList();
    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Repair>
     */
    IPage<RepairCost> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param repair 
     * @return int
     */
    int add(RepairCost repairCost);

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
     * @param repair 
     * @return int
     */
    int updateData(RepairCost repairCost);

    /**
     * id查询数据
     *
     * @param id id
     * @return Repair
     */
    RepairCost findById(Long id);


}