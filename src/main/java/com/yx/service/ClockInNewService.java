package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Clockinnew;

import java.util.Date;

/**
 * 
 * @author 34646
 *
 */
public interface ClockInNewService extends IService<Clockinnew> {

    PageInfo<Clockinnew> queryClockInAll(int pageNum, int pageSize, Clockinnew clockinnew);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Clockinnew>
     */
    IPage<Clockinnew> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param clockinnew 
     * @return int
     */
    int add(Clockinnew clockinnew);

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
     * @param clockinnew 
     * @return int
     */
    int updateData(Clockinnew clockinnew);

    /**
     * id查询数据
     *
     * @param id id
     * @return Clockinnew
     */
    Clockinnew findById(Long id);

    Date queryCountByOwnId(Integer ownerId);
}
