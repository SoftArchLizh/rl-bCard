package com.volvo.invoice.controller;

import com.alibaba.fastjson.JSON;
import com.volvo.invoice.dto.OpenRushInvoiceReqDTO;
import com.volvo.invoice.dto.OpenRushInvoiceRespDTO;
import com.volvo.invoice.dto.ResponseDTO;
import com.volvo.invoice.dto.TtInvoiceRecord;
import com.volvo.invoice.service.InvoiceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@Api(tags = "订单发票管理")
@Slf4j
//@RestController
//@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private final InvoiceInfoService invoiceInfoService;

    @ApiOperation(value = "开票接口2.0")
    @PostMapping(path = "/openInvoice")
    @ResponseBody
    public ResponseDTO<List<OpenRushInvoiceRespDTO>> openInvoice(@RequestBody OpenRushInvoiceReqDTO openRushInvoiceReqDTO) {
        log.info("发票开票2.0接口-controller params:{}", JSON.toJSONString(openRushInvoiceReqDTO));
        try {

            ResponseDTO<List<OpenRushInvoiceRespDTO>> responseDTO = invoiceInfoService.openInvoice(openRushInvoiceReqDTO);
            log.info("发票开票2.0接口-controller 调用结束，结果：{}",JSON.toJSONString(responseDTO));
            return responseDTO;
        } catch (Exception e){
            log.error("发票开票2.0接口-controller 调用失败" ,e.getMessage());
            return null;
        }
    }


    public InvoiceController(InvoiceInfoService invoiceInfoService) {
        this.invoiceInfoService = invoiceInfoService;
    }

    @PostMapping("/insert")
    public void insertInvoice(@RequestBody TtInvoiceRecord vJdcfphz) {
        invoiceInfoService.insertVJdcfphz(vJdcfphz);
    }

    @GetMapping("/delete/{id}")
    public void deleteInvoice(@PathVariable("id") Long id) {
        invoiceInfoService.deleteVJdcfphz(id);
    }

    @GetMapping("/get/{id}")
    public TtInvoiceRecord getInvoiceById(@PathVariable("id") Long id) {
        return invoiceInfoService.getVJdcfphzById(id);
    }

}
