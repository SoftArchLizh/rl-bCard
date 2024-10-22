package com.volvo.invoice.controller;

import com.volvo.invoice.dto.WarrantyOrderDTO;
import com.volvo.invoice.dto.WarrantyOrders;
import com.volvo.invoice.service.IWarrantyOrdersService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.hutool.core.bean.BeanUtil;
/**
 * Date: 2024/6/28 9:33
 **/
@Api(tags = "保修工单 ")
@Slf4j
@RestController
@RequestMapping("/warrantyOrder")
public class WarrantyOrdersController {

    @Autowired
    private IWarrantyOrdersService warrantyOrderService;


    @PostMapping("/createOrders")
    public ResponseEntity<WarrantyOrderDTO> createWarrantyOrder(@RequestBody WarrantyOrderDTO warrantyOrderDTO) {
//        BeanUtil.copyProperties(warrantyOrderDTO, WarrantyOrders.class);
        ResponseEntity<WarrantyOrderDTO> body = null ;
        try {
            log.info("WarrantyOrdersController, warrantyOrderDTO:{}", warrantyOrderDTO);
            WarrantyOrders warrantyOrders = BeanUtil.copyProperties(warrantyOrderDTO, WarrantyOrders.class);
            WarrantyOrderDTO retDto = warrantyOrderService.createWarrantyOrders(warrantyOrderDTO);

            if(retDto==null){
                body = ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(warrantyOrderDTO);
            }else
                body = ResponseEntity.status(HttpStatus.CREATED).body(retDto);

        }catch (Exception e){
            e.printStackTrace();
            log.error("createWarrantyOrder error:{}",e.getMessage());
        }

        return body;
    }

    @GetMapping("/{warrantyOrderNo}")
    public ResponseEntity<WarrantyOrderDTO> getWarrantyOrder(@RequestBody WarrantyOrderDTO warrantyOrderDTO) {

//        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
        return null;
    }
}
