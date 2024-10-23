package com.volvo.invoice.controller;

import com.volvo.invoice.dto.TtInvoiceRecord;
import com.volvo.invoice.service.InvoiceInfoService;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(tags = "接口模块类描述说明")//：该注解标注在接口模块类上，用于对接口模块类进行描述说明
@Slf4j
@RestController
@RequestMapping("/api/agent")
public class AiAgentController {

    private final InvoiceInfoService invoiceInfoService;

    public AiAgentController(InvoiceInfoService invoiceInfoService) {
        this.invoiceInfoService = invoiceInfoService;
    }

    @PostMapping("/api-market")
    public String   insertInvoice() {
        log.info("收到 autodev的请求 ，正在处理 ");

        return "收到 autodev的请求 ，正在处理  20240330";
    }

       @GetMapping("/delete/{id}")
    public void deleteInvoice(@PathVariable("id") Long id) {
        invoiceInfoService.deleteVJdcfphz(id);
    }

    @ApiOperation(value="接口方法简要说明",notes="接口方法详细描述" )//：该注解标注在接口模块类的接口方法上，用于对接口方法进行描述说明。其中notes字段可以插入HTML标签，response字段表示该方法的返回值类型。

    @GetMapping("/get/{id}")
    public TtInvoiceRecord getInvoiceById(@PathVariable("id") Long id) {
        return invoiceInfoService.getVJdcfphzById(id);
    }

}
