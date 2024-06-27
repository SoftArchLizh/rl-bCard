package com.volvo.invoice.controller;

import com.google.common.collect.Lists;
import com.volvo.invoice.dto.TtInvoiceRecord;
import com.volvo.invoice.service.InvoiceInfoService;
import io.swagger.annotations.Api;
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

    @PostMapping("/swiper/getImageList")
    @CrossOrigin("*") // 允许所有来源访问  如何解决 Access-Control-Allow-Origin
    public String   insertInvoice() {
        log.info("收到 autodev的请求 ，正在处理 ");
        LinkedList<String> imageList = Lists.newLinkedList();
        imageList.add("../../static/offer/offer20240518195054.png");
        imageList.add("../../static/offer/offer-3.png");
        imageList.add("../../static/offer/offer-1.png");
//        imageList.add("../../static/offer/offer-1.png");
        String ret  = imageList.toString();
        log.info(ret);
        return ret;
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
