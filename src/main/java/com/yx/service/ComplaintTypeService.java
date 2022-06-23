package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.model.ComplaintType;

import java.util.List;


public interface ComplaintTypeService extends IService<ComplaintType> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ComplaintType>
     */
    IPage<ComplaintType> findListByPage(Integer page, Integer pageCount);

    List<ComplaintType> queryType();
    /**
     * 添加
     *
     * @param complaintType 
     * @return int
     */
    int add(ComplaintType complaintType);

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
     * @param complaintType 
     * @return int
     */
    int updateData(ComplaintType complaintType);

    /**
     * id查询数据
     *
     * @param id id
     * @return ComplaintType
     */
    ComplaintType findById(Long id);
}
