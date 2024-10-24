package com.rongl.service.impl;

import com.rongl.entity.AiCardInfo;
import com.rongl.mapper.AiCardInfoMapper;
import com.rongl.service.IAiCardInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李中华
 * @since 2024-10-24
 */
@Service
public class AiCardInfoServiceImpl extends ServiceImpl<AiCardInfoMapper, AiCardInfo> implements IAiCardInfoService {

    @Override
    public List<AiCardInfo> listAll() {
        return null;
    }

    public String  uploadFile(MultipartFile file) {
        String path = "";

        boolean flag = false;
        if (file.isEmpty()) {
            throw new RuntimeException("文件不存在！");
        }

        return "";

    }
}
