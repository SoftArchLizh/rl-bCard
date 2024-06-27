package com.volvo.invoice;

import static org.mockito.Mockito.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.volvo.invoice.dto.TtInvoiceRecord;
import com.volvo.invoice.dto.VJdcfphz;
import com.volvo.invoice.service.VJdcfphzService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
class VJdcfphzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private VJdcfphzService vJdcfphzService;

    @BeforeEach
    void setUp() {
        // 初始化mock数据
        // 设置mock行为
    }

    @Test
    void testInsertVJdcfphz() throws Exception {
        VJdcfphz vJdcfphz = new VJdcfphz();
        vJdcfphz.setQuantity(2);
//        vJdcfphz.setBillingType("专票");
//        vJdcfphz.setTaxRate(BigDecimal.valueOf(13));
//        vJdcfphz.setTotalUnitPrice(BigDecimal.valueOf(1500));
//        vJdcfphzService.insertVJdcfphz(vJdcfphz);



        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(vJdcfphz);


        mockMvc.perform(MockMvcRequestBuilders.post("/vJdcfphz/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    /**
     * 接收新的发票数据回传
     * @throws Exception
     */
    @Test
    void testReceiveInvoiceCallback() throws Exception {
        VJdcfphz vJdcfphz = new VJdcfphz();
        vJdcfphz.setInvoiceAmount(BigDecimal.valueOf(120000));
        vJdcfphz.setInvoiceCode("20240306001");

        vJdcfphz.setInvoiceAmount(BigDecimal.valueOf(180000));
        vJdcfphz.setQuantity(2);
        vJdcfphz.setInvoiceType("专票");
        vJdcfphz.setInputTaxRate(BigDecimal.valueOf(13));
        vJdcfphz.setTotalPrice(BigDecimal.valueOf(1500));
        vJdcfphz.setVin("vin_20240302");
//        vJdcfphzService.insertVJdcfphz(vJdcfphz);



        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(vJdcfphz);


        mockMvc.perform(MockMvcRequestBuilders.post("/v-jdcfphzs/process/callback")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }



//    @Test
//    void testDeleteVJdcfphz() throws Exception {
//        Long id = 1L; // 使用一个存在的ID
//        when(vJdcfphzService.deleteVJdcfphz(any(Long.class))).thenReturn(true);
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/jdcfphz/{id}", id))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void testGetVJdcfphzById() throws Exception {
//        Long id = 1L; // 使用一个存在的ID
//        VJdcfphz vJdcfphz = // 创建随机的VJdcfphz对象
//                when(vJdcfphzService.getVJdcfphzById(any(Long.class))).thenReturn(vJdcfphz);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/v1/jdcfphz/{id}", id))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void testUpdateVJdcfphz() throws Exception {
//        VJdcfphz vJdcfphz = // 创建随机的VJdcfphz对象
//                when(vJdcfphzService.updateVJdcfphz(any(VJdcfphz.class))).thenReturn(true);
//
//        mockMvc.perform(MockMvcRequestBuilders.put("/v1/jdcfphz")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(vJdcfphz)))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
}
