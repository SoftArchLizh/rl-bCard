package com.volvo.invoice.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.volvo.invoice.dto.TtInvoiceRecord;
import com.volvo.invoice.dto.VJdcfphz;
import com.volvo.invoice.mapper.VJdcfphzMapper;
import com.volvo.invoice.service.InvoiceInfoService;
import com.volvo.invoice.service.VJdcfphzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class VJdcfphzServiceImpl
        extends ServiceImpl<VJdcfphzMapper, VJdcfphz>
        implements VJdcfphzService {

    @Autowired
    InvoiceInfoService invoiceInfoService;

    @Override
    public String processInvoiceCallback(VJdcfphz vJdcfphz) {
        String ret="成功";
        try{
            // 1 保存发票信息到 数据库表 v_jdcfphz
            this.save(vJdcfphz);
            //2  根据车架号 修改或是填充 订单记录表的 发票编码 和 发票日期
            UpdateWrapper<TtInvoiceRecord> updateWrapper= new UpdateWrapper<>();
            updateWrapper.eq("frame_number",vJdcfphz.getVin())
                    .set("invoice_id",vJdcfphz.getInvoiceCode())
                    .set("invoice_date",new Date());
            invoiceInfoService.update(updateWrapper);

        }catch (Exception e){
            e.printStackTrace();
            log.error("发票回调异常"+e.getMessage());
            ret="失败";
        }


        return ret;
    }

    @Override
    public void insertVJdcfphz(VJdcfphz vJdcfphz) {
        this.save(vJdcfphz);
    }

    @Override
    public void deleteVJdcfphz(Long id) {
        this.removeById(id);
    }

    @Override
    public VJdcfphz getVJdcfphzById(Long id) {
        return this.getById(id);
    }

    @Override
    public void updateVJdcfphz(VJdcfphz vJdcfphz) {

    }

}
