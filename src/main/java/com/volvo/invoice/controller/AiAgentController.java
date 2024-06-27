package com.volvo.invoice.controller;

import com.volvo.invoice.dto.TtInvoiceRecord;
import com.volvo.invoice.service.InvoiceInfoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(tags = "autoDev controller")
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

    @GetMapping("/get/{id}")
    public TtInvoiceRecord getInvoiceById(@PathVariable("id") Long id) {
        return invoiceInfoService.getVJdcfphzById(id);
    }

}
