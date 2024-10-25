package com.volvo.oem51dk;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rongl.common.PropertiesCommon;
import com.volvo.invoice.InvoiceServiceApplication;

import com.volvo.invoice.dto.WarrantyOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = InvoiceServiceApplication.class )
@AutoConfigureMockMvc
@Slf4j
//@WebMvcTest(WarrantyOrdersController.class)
public class WarrantyOrdersControllerTest {

    @Autowired
    private MockMvc mockMvc;


    private WarrantyOrderDTO warrantyOrderDto;



    @BeforeEach
    public void setUp() {
        warrantyOrderDto = new WarrantyOrderDTO();
        // 初始化保修工单DTO，设置必要的属性值
    }






    /**
     * 创建  保修单
     * @throws Exception
     */
    @Test
    public void createWarrantyOrderReturnsCreated() throws Exception {
        // 定义服务层的预期行为，例如保存操作成功
        WarrantyOrderDTO savedOrder = new WarrantyOrderDTO(); // 假设保存后会返回一些信息
//        Mockito.when(warrantyOrderService.createWarrantyOrder(Mockito.any(WarrantyOrderDTO.class)))
//                .thenReturn(savedOrder);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(initializeWarrantyOrderDTO());

        ResultActions perform = mockMvc.perform(post("/warrantyOrder/createOrders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))// 验证返回的 HTTP 状态码是否为 200（OK）
               .andExpect(status().isCreated());
        log.info("perform:{}",perform);
        // 可以根据实际情况添加更多的断言，比如验证响应体内容
        assertNotNull(perform, "返回不应该为null");


    }


    /**
     * 通过vin码，去车辆中心 拿到车型数据 ： 分为成功和失败 两个场景的测试
     *
     * 测试成功  的场景,
     * @throws Exception
     */
    @Test
    public void createWarrantyOrderForSuccessVehicleData() throws Exception {
        // 定义服务层的预期行为，例如保存操作成功
        WarrantyOrderDTO savedOrder = initializeWarrantyOrderDTO(); // 假设保存后会返回一些信息

        savedOrder.setVinCode("1234567");//设置不存在的vin 码

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(savedOrder);
        ResultActions perform = mockMvc.perform(post("/warrantyOrder/createOrders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))// 验证返回的 HTTP 状态码是否为 200（OK）
                .andExpect(status().isCreated());
        String contentAsString = perform.andReturn().getResponse().getContentAsString();
        JSONObject jsonObject = JSONUtil.parseObj(contentAsString);
        // 直接转换为YourModelClass实例
        WarrantyOrderDTO warrantyOrderDTO = JSONUtil.toBean(jsonObject, WarrantyOrderDTO.class);
        boolean retCodeNotExistVinCode = warrantyOrderDTO.getRetCode().equals(PropertiesCommon.retCodeNotExistVinCode);

        assertNotNull(perform, "返回不应该为null");
        assertTrue(retCodeNotExistVinCode, "vin码不存在");


        log.info("perform:{}",perform);
        // 可以根据实际情况添加更多的断言，比如验证响应体内容
    }

    /**
     * 通过vin码，去车辆中心 拿到车型数据 ： 分为成功和失败 两个场景的测试
     *
     * 测试 成功  的场景
     * @throws Exception
     */
    @Test
    public void createWarrantyOrderForFailVehicleData() throws Exception {
        // 定义服务层的预期行为，例如保存操作成功
        WarrantyOrderDTO savedOrder = initializeWarrantyOrderDTO(); // 假设保存后会返回一些信息
        savedOrder.setVinCode(PropertiesCommon.vinCode);// 这是正确的vin码

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(savedOrder);
        ResultActions perform = mockMvc.perform(post("/warrantyOrder/createOrders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))// 验证返回的 HTTP 状态码是否为 200（OK）
                .andExpect(status().isCreated());
        String contentAsString = perform.andReturn().getResponse().getContentAsString();

        log.info("perform:{}",perform);
        // 可以根据实际情况添加更多的断言，比如验证响应体内容
    }


    @Test
    public void getWarrantyOrder_ReturnsOrderDetails() throws Exception {
        Long orderId = 1L; // 假定的订单ID

        WarrantyOrderDTO expectedOrder = new WarrantyOrderDTO(); // 初始化期望的保修工单信息
//        Mockito.when(warrantyOrderService.getWarrantyOrderById(orderId))
//                .thenReturn(expectedOrder);
//
        mockMvc.perform(get("/api/warranty-orders/{id}", orderId))
                .andExpect(status().isOk())
        // 根据实际返回的JSON结构添加jsonPath断言验证响应内容
        ;
    }


    public WarrantyOrderDTO initializeWarrantyOrderDTO() {
        WarrantyOrderDTO warrantyOrderDto = new WarrantyOrderDTO();

      //  warrantyOrderDto.setId(103); // 主键ID
        warrantyOrderDto.setDealerCode("DLR0002"); // 经销商编码
        warrantyOrderDto.setDealerName("Sample Dealer"); // 经销商名称
        warrantyOrderDto.setWarrantyOrderNo("WON2023001"); // 保修单号
        warrantyOrderDto.setWarrantyStatus("待处理"); // 保修状态
        warrantyOrderDto.setVinCode(PropertiesCommon.vinCode); // VIN码
        warrantyOrderDto.setWorkOrderNo("WRK001"); // 工单号
//        warrantyOrderDto.setRepairDate(LocalDateTime.now()); // 维修日期
        warrantyOrderDto.setIsClosed(false); // 是否结案
        warrantyOrderDto.setMileage(12000); // 行驶里程
        warrantyOrderDto.setVehicleModelCode("VH01"); // 车型代码
        warrantyOrderDto.setLicensePlate("京A12345"); // 车牌号
//        warrantyOrderDto.setSaleDate(LocalDate.of(2022, 1, 1)); // 销售日期
        warrantyOrderDto.setPartsTotal(new BigDecimal("1500.00")); // 零件总额
        warrantyOrderDto.setLaborHours(new BigDecimal("2.5")); // 工时数
        warrantyOrderDto.setWarrantyCost(new BigDecimal("1200.00")); // 零件保修成本总额
        warrantyOrderDto.setLaborFee(new BigDecimal("200.00")); // 工时费用
        warrantyOrderDto.setOutsourcingSalary(new BigDecimal("500.00")); // 委外工资总额
        warrantyOrderDto.setIsRejected(false); // 是否拒赔
//        warrantyOrderDto.setReportDate(LocalDate.now()); // 保修上报日期
        warrantyOrderDto.setReporter("John Doe"); // 保修上报人
        warrantyOrderDto.setBpmAuditComment("Approved."); // BPM审核意见
        warrantyOrderDto.setRemarks("No additional comments."); // 备注
//        warrantyOrderDto.setRefundDate(LocalDate.of(2023, 2, 15)); // 回款日期
        warrantyOrderDto.setIsUploaded(true); // 是否上传
        warrantyOrderDto.setUploadAttempts(1); // 上传次数
        warrantyOrderDto.setPartsApplicationAmount(new BigDecimal("1400.00")); // 零件申请金额
        warrantyOrderDto.setLaborApplicationAmount(new BigDecimal("180.00")); // 工时申请金额
        warrantyOrderDto.setQw90Msg("Additional info for QW90."); // qw90Msg

        // 初始化交修明细和附件列表的示例
//        List<Map<String, Object>> repairDetails = new ArrayList<>();
//        Map<String, Object> detail = new HashMap<>();
//        detail.put("partName", "Engine Part");
//        detail.put("quantity", 2);
//        repairDetails.add(detail);
//        warrantyOrderDto.setRepairDetails(repairDetails);

//        List<Map<String, Object>> attachments = new ArrayList<>();
//        Map<String, Object> attachment = new HashMap<>();
//        attachment.put("fileName", "invoice.pdf");
//        attachment.put("fileType", "PDF");
//        attachments.add(attachment);
//        warrantyOrderDto.setAttachments(attachments);
        return  warrantyOrderDto;
    }


}

// 注意：JsonUtil.toJson 是一个假设存在的工具方法，用于将对象转换为JSON字符串。
// 在实际应用中，您可以使用Jackson、Gson等库来实现。
