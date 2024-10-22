package com.volvo.invoice.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.volvo.invoice.common.PropertiesCommon;
import com.volvo.invoice.dto.WarrantyOrderDTO;
import com.volvo.invoice.dto.WarrantyOrders;
import com.volvo.invoice.mapper.WarrantyOrdersMapper;
import com.volvo.invoice.service.IWarrantyOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 保修工单表 服务实现类
 * </p>
 *
 * @author 李中华
 * @since 2024-06-28
 */
@Service
@Slf4j
public class WarrantyOrdersServiceImpl extends ServiceImpl<WarrantyOrdersMapper, WarrantyOrders> implements IWarrantyOrdersService {

    @Autowired
    WarrantyOrdersMapper warrantyOrdersMapper;

    @Override
    public WarrantyOrderDTO createWarrantyOrders(WarrantyOrderDTO warrantyOrderDTO) {
        try {
            System.out.println(" warrantyOrderDTO = " + warrantyOrderDTO);
            log.info("begin  WarrantyOrdersServiceImpl   createWarrantyOrders:{}", warrantyOrderDTO);
            WarrantyOrders warrantyOrders = BeanUtil.copyProperties(warrantyOrderDTO, WarrantyOrders.class);

            String vinCode = warrantyOrders.getVinCode();

            if (!PropertiesCommon.vinCode.equals(vinCode) ){
                log.info("vinCode is not correct");
                warrantyOrderDTO.setRetCode(PropertiesCommon.retCodeNotExistVinCode );
                return warrantyOrderDTO;
            }


            boolean save = this.save(warrantyOrders);
//            int insert = warrantyOrdersMapper.insert(warrantyOrders);
            if (save) {
                warrantyOrderDTO.setId(warrantyOrders.getId());
                return warrantyOrderDTO;
            }
            log.info("end  WarrantyOrdersServiceImpl   createWarrantyOrders:{}", warrantyOrderDTO);
        }catch (Exception e) {
            e.printStackTrace();
            log.error("WarrantyOrdersServiceImpl   createWarrantyOrders error:{}", e);
        }

        return null;
    }
}
