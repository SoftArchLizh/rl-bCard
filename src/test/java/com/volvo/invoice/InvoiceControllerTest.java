package com.volvo.invoice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.volvo.invoice.controller.InvoiceController;
import com.volvo.invoice.dto.*;
import com.volvo.invoice.service.InvoiceInfoService;
import com.volvo.invoice.service.VJdcfphzService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static org.mockito.Mockito.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Mock
//    private InvoiceInfoService invoiceInfoService;
//
//    @Mock
//    private VJdcfphzService vJdcfphzService;


    @InjectMocks
    private InvoiceController invoiceController;



        @Test
        public void testOpenInvoice() throws Exception {
            // 创建一个 OpenRushInvoiceReqDTO 对象，并填充测试数据
            OpenRushInvoiceReqDTO openRushInvoiceReqDTO = new OpenRushInvoiceReqDTO();
            // TODO: 设置 openRushInvoiceReqDTO 的属性值
            openRushInvoiceReqDTO.setBusinessCode(InvoiceBusinessCode.CHARGE.getCode());

            OpenRushInvoiceContentReqDTO reqDTO = new  OpenRushInvoiceContentReqDTO();
            reqDTO.setIncemetInvoiceList(new ArrayList<>());
            openRushInvoiceReqDTO.setContent(reqDTO);
            // 将 OpenRushInvoiceReqDTO 对象转换为 JSON 格式的字符串
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(openRushInvoiceReqDTO);

            // 使用 mockMvc 对象模拟一个 POST 请求到 /invoices/openInvoice，并将 OpenRushInvoiceReqDTO 对象作为请求体
            mockMvc.perform(MockMvcRequestBuilders.post("/invoices/openInvoice")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))
                    // 验证返回的 HTTP 状态码是否为 200（OK）
                    .andExpect(status().isOk());
            // TODO: 验证返回的数据是否符合预期
        }



    @Test
    public void testInsertInvoice() throws Exception {
        TtInvoiceRecord invoiceRecord = generateRandomInvoiceRecord();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(invoiceRecord);
        // 使用mockMvc模拟请求调用接口
        mockMvc.perform(post("/invoices/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testInsertVJdcfphz() throws Exception {



        VJdcfphz vJdcfphz = new VJdcfphz();
//        vJdcfphz.setInvoiceCode(5);
        vJdcfphz.setQuantity(2);
//        vJdcfphz.setBillingType("专票5");
//        vJdcfphz.setTaxRate(BigDecimal.valueOf(13));
//        vJdcfphz.setTotalUnitPrice(BigDecimal.valueOf(1500));
//        vJdcfphz.setInvoiceAmount(BigDecimal.valueOf(26));
//        vJdcfphz.setFrameNumber("vin_20240301");
        log.info("Invoice : "+vJdcfphz.toString());
//        vJdcfphzService.insertVJdcfphz(vJdcfphz);



        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(vJdcfphz);


        mockMvc.perform(MockMvcRequestBuilders.post("/vJdcfphz/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    //    @Test
//    public void testDeleteInvoice() throws Exception {
//        Long invoiceId = generateRandomInvoiceId();
//        // 使用mockMvc模拟请求调用接口
//        mockMvc.perform(delete("/invoices/{invoiceId}", invoiceId))
//                .andExpect(status().isOk());
//        // 验证是否调用了对应的service层方法
//        verify(invoiceInfoService, times(1)).deleteInvoice(invoiceId);
//    }
//
    @Test
    public void testGetInvoiceById() throws Exception {
        Long invoiceId = 1L;
        TtInvoiceRecord mockInvoiceRecord = generateRandomInvoiceRecord();

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = get("/invoices/{invoiceId}", invoiceId);
        // 使用mockMvc模拟请求调用接口
        ResultActions perform = mockMvc.perform(get("/invoices/{invoiceId}", invoiceId));

//                .andExpect(status().isOk()) ;
        System.out.println("OK");
    }
//
//    @Test
//    public void testUpdateInvoice() throws Exception {
//        TtInvoiceRecord invoiceRecord = generateRandomInvoiceRecord();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(invoiceRecord);
//        // 使用mockMvc模拟请求调用接口
//        mockMvc.perform(put("/invoices")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk());
//        // 验证是否调用了对应的service层方法
//        verify(invoiceInfoService, times(1)).updateInvoice(invoiceRecord);
//    }

    private TtInvoiceRecord generateRandomInvoiceRecord() {
        // 生成随机的发票记录
        TtInvoiceRecord invoiceRecord = new TtInvoiceRecord();
        // 设置随机值
        // ...
//        invoiceRecord.setAmount(BigDecimal.valueOf(1251));
//        invoiceRecord.setOrderId(5);
        invoiceRecord.setOrderNo("order20240606");
        invoiceRecord.setFrameNumber("vin_20240602");
        invoiceRecord.setOrderAmount(BigDecimal.valueOf(120000));
//        invoiceRecord.setInvoiceId(1);
//        invoiceRecord.setInvoiceDate(new Date());
        return invoiceRecord;
    }

    private Long generateRandomInvoiceId() {
        // 生成随机的发票ID
        return new Random().nextLong();
    }
}
