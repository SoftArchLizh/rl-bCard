package com.volvo.invoice.controller;

import com.volvo.invoice.dto.TtInvoiceRecord;
import com.volvo.invoice.service.InvoiceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@Api(tags = "autoDev controller")
@Slf4j
@RestController
@RequestMapping("/home")
public class HomeController {

    private final InvoiceInfoService invoiceInfoService;

    public HomeController(InvoiceInfoService invoiceInfoService) {
        this.invoiceInfoService = invoiceInfoService;
    }



    @ApiOperation("hello控制类")
    @GetMapping("/delete/{id}")
    public void deleteInvoice(@PathVariable("id") Long id) {
        invoiceInfoService.deleteVJdcfphz(id);
    }

    @GetMapping("/get/{id}")
    public TtInvoiceRecord getInvoiceById(@PathVariable("id") Long id) {
        return invoiceInfoService.getVJdcfphzById(id);
    }

}
