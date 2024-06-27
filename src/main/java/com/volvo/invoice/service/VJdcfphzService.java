package com.volvo.invoice.service;

import com.volvo.invoice.dto.VJdcfphz;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;


public interface VJdcfphzService extends IService<VJdcfphz> {

    String processInvoiceCallback(VJdcfphz vJdcfphz);

    /**
     * 插入记录
     * @param vJdcfphz 记录对象
     */
    @ApiOperation("插入记录")
    void insertVJdcfphz(VJdcfphz vJdcfphz);

    /**
     * 删除记录
     * @param id 记录ID
     */
    @ApiOperation("删除记录")
    void deleteVJdcfphz(Long id);

    /**
     * 根据ID查询记录
     * @param id 记录ID
     * @return 记录
     */
    @ApiOperation("根据ID查询记录")
    VJdcfphz getVJdcfphzById(Long id);

    /**
     * 更新记录
     * @param vJdcfphz 记录对象
     */
    @ApiOperation("更新记录")
    void updateVJdcfphz(VJdcfphz vJdcfphz);
}