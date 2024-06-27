package com.volvo.invoice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.volvo.invoice.dto.OpenRushInvoiceReqDTO;
import com.volvo.invoice.dto.OpenRushInvoiceRespDTO;
import com.volvo.invoice.dto.ResponseDTO;
import com.volvo.invoice.dto.TtInvoiceRecord;


import java.util.List;

@SuppressWarnings("ALL")
public interface InvoiceInfoService extends IService<TtInvoiceRecord> {


    /**
     * ��入记录
     *
     * @param vJdcfphz 记录对象
     */
    void insertVJdcfphz(TtInvoiceRecord vJdcfphz);

    ResponseDTO<List<OpenRushInvoiceRespDTO>> openInvoice(OpenRushInvoiceReqDTO openRushInvoiceReqDTO);



    /**
     * 删除记录
     *
     * @param id 记录ID
     */
    void deleteVJdcfphz(Long id);

    /**
     * 根据ID查询记录
     *
     * @param id 记录ID
     * @return 记录
     */
    TtInvoiceRecord getVJdcfphzById(Long id);

    /**
     * 根据车架号查询发票信息
     *
     * @param frameNumber 车架号
     * @return 发票信息
     */
    List<TtInvoiceRecord> selectInvoiceInfoByFrameNumber(String frameNumber);
}