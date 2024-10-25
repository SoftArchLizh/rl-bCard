package com.rl.ai;

import com.rongl.AIBCardServiceApplication;
import com.rongl.controller.AiCardInfoController;
import com.rongl.entity.AiCardInfo;
import com.rongl.service.impl.AiCardInfoServiceImpl;
import com.volvo.invoice.InvoiceServiceApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest(classes = AIBCardServiceApplication.class )
@AutoConfigureMockMvc
@Slf4j
public class AiCardInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private MockMultipartFile file;

    @BeforeEach
    public void setUp() throws IOException {
        // 读取本地文件
        File pngFile = new File("D:\\bCard\\png\\aicard_20241023124107.png");
        FileInputStream input = new FileInputStream(pngFile);
        file = new MockMultipartFile("file", pngFile.getName(), "image/png", input);
    }

    @Test
    public void testUploadFileToLocal() throws Exception {
        // 读取实际文件
//        byte[] fileContent = Files.readAllBytes(Paths.get("D:\\bCard\\png\\aicard_20241023124107.png"));
//        MockMultipartFile file = new MockMultipartFile("resumefile", "aicard_20241023124107.png", "text/plain", fileContent);

        // 读取实际图片文件
        byte[] fileContent = Files.readAllBytes(Paths.get("D:\\bCard\\png\\aicard_20241023124107.png"));
        MockMultipartFile file = new MockMultipartFile("resumefile", "aicard_20241023124107.png", "image/jpeg", fileContent);

        // 模拟HTTP POST请求上传文件
        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/aiCardInfo/upload")
                .file(file)
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("File uploaded successfully"));

        // 可以在这里添加更多的断言，例如验证服务层的方法是否被调用
        // verify(aiCardInfoService, times(1)).uploadFileToMinio(any());
    }

    @Test
    public void add_ValidAiCardInfo_ShouldReturnOK() throws Exception {
        AiCardInfo aiCardInfo = new AiCardInfo();
        aiCardInfo.setName("John Doe");
        aiCardInfo.setEmail("john.doe@example.com");


        mockMvc.perform(post("/api/aiCardInfo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\",\"email\":\"john.doe@example.com\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void listAll_Success() throws Exception {


        mockMvc.perform(post("/api/aiCardInfo/listAllCards"))
                .andExpect(status().isOk()) ;

    }


}
