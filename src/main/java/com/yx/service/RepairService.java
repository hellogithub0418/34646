package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Repair;


import java.util.List;


public interface RepairService extends IService<Repair> {

    PageInfo<Repair> findRepairAll(int page, int pagesise, Repair repair);

    List<Repair> queryListAll();
    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Repair>
     */
    IPage<Repair> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param repair 
     * @return int
     */
    int add(Repair repair);

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
    int updateData(Repair repair);

    /**
     * id查询数据
     *
     * @param id id
     * @return Repair
     */
    Repair findById(Long id);

	



}
