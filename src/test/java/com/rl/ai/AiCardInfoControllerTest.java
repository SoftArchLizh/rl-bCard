package com.rl.ai;

import java.util.*;
import java.math.*;
import com.rongl.common.ReturnResult;
import com.rongl.controller.AiCardInfoController;
import com.rongl.service.impl.AiCardInfoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AiCardInfoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AiCardInfoServiceImpl aiCardInfoService;

    @InjectMocks
    private AiCardInfoController aiCardInfoController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(aiCardInfoController).build();
    }

    @Test
    public void uploadFileMinio_ValidFile_ShouldReturnErrorLogout() throws Exception {
        // Arrange
        MultipartFile file = mock(MultipartFile.class);
        when(file.getContentType()).thenReturn(MediaType.IMAGE_PNG_VALUE);
        when(file.getSize()).thenReturn(100L);

        doNothing().when(aiCardInfoService).uploadFile(any(MultipartFile.class));

        // Act & Assert
        mockMvc.perform(multipart("/api/aiCardInfo/upload")
                .file((MockMultipartFile) file)
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk());

        verify(aiCardInfoService, times(1)).uploadFile(any(MultipartFile.class));
    }

    @Test
    public void uploadFileMinio_InvalidFile_ShouldReturnBadRequest() throws Exception {
        // Arrange
        MultipartFile file = mock(MultipartFile.class);
        when(file.getContentType()).thenReturn(MediaType.TEXT_PLAIN_VALUE);
        when(file.getSize()).thenReturn(100L);

        // Act & Assert
        mockMvc.perform(multipart("/api/aiCardInfo/upload")
                .file((MockMultipartFile) file)
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isBadRequest());
    }
}

