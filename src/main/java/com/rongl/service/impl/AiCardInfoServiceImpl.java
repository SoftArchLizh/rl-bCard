package com.rongl.service.impl;

import com.rongl.entity.AiCardInfo;
import com.rongl.mapper.AiCardInfoMapper;
import com.rongl.service.IAiCardInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AiCardInfoServiceImpl extends ServiceImpl<AiCardInfoMapper, AiCardInfo> implements IAiCardInfoService {

    @Override
    public List<AiCardInfo> listAll() {
        log.info("开始  listAll");
        return null;
    }

    @Override
    public String  uploadFile(String filePath) {
        String path = "";
        log.info("外部访问路径：： "+filePath);


        return "开始保存名片到本地";

    }
}
