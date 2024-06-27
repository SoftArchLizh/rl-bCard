package com.volvo.invoice.controller;

import com.volvo.invoice.dto.VJdcfphz;
import com.volvo.invoice.service.VJdcfphzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "发票管理")
@Slf4j
@RestController
@RequestMapping("/v-jdcfphzs")
public class VJdcfphzController {

    private final VJdcfphzService vJdcfphzService;

    @Autowired
    public VJdcfphzController(VJdcfphzService vJdcfphzService) {
        this.vJdcfphzService = vJdcfphzService;
    }

    /**
     * 处理发票回调
     *
     * @param vJdcfphz 记录对象
     */
    @PostMapping("/process/callback")
    public String processInvoiceCallback(
            @RequestBody VJdcfphz vJdcfphz) {

        String  retString = vJdcfphzService.processInvoiceCallback(vJdcfphz);

        return retString;
    }


    @ApiOperation("增加发票信息")
    @PostMapping("/insert")
    public void insertVJdcfphz(@RequestBody VJdcfphz vJdcfphz) {
        vJdcfphzService.insertVJdcfphz(vJdcfphz);
    }

    @ApiOperation("删除发票信息")
    @GetMapping("/delete/{id}")
    public void deleteVJdcfphz(@PathVariable("id") Long id) {
        vJdcfphzService.deleteVJdcfphz(id);
    }

    @ApiOperation("根据ID查询发票信息")
    @GetMapping("/get/{id}")
    public VJdcfphz getVJdcfphzById(@PathVariable("id") Long id) {
        return vJdcfphzService.getVJdcfphzById(id);
    }


    @ApiOperation("更新发票信息")
    @PostMapping("/update")
    public void updateVJdcfphz(@RequestBody VJdcfphz vJdcfphz) {
        vJdcfphzService.updateVJdcfphz(vJdcfphz);
    }
}
