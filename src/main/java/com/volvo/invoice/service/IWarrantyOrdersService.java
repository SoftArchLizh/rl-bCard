package com.volvo.invoice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.volvo.invoice.dto.WarrantyOrderDTO;
import com.volvo.invoice.dto.WarrantyOrders;


/**
 * <p>
 * 保修工单表 服务类
 * </p>
 *
 * @author 李中华
 * @since 2024-06-28
 */
public interface IWarrantyOrdersService extends IService<WarrantyOrders> {

    public WarrantyOrderDTO createWarrantyOrders(WarrantyOrderDTO warrantyOrderDTO);
}
