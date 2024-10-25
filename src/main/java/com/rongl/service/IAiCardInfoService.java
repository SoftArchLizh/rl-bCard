package com.rongl.service;

import com.rongl.entity.AiCardInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 李中华
 * @since 2024-10-24
 */
public interface IAiCardInfoService extends IService<AiCardInfo> {

    List<AiCardInfo> listAll();
    String  uploadFile(String filePath);
}
