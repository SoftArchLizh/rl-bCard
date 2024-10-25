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
    public String  uploadFile666(MultipartFile file) {
        String path = "";
        log.info("开始保存名片到本地");
        // 文件保存在本地文件夹
        String filePath = "D:/";
        String fileName = file.getOriginalFilename();
        path = filePath + fileName;
        try {
            file.transferTo(new java.io.File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("文件保存成功！");
        log.info("文件保存路径：" + path);
        log.info("文件大小：" + file.getSize());
        log.info("文件类型：" + file.getContentType());
        log.info("文件名称：" + file.getName());
        log.info("文件原始名称：" + file.getOriginalFilename());

        boolean flag = false;
        if (file.isEmpty()) {
            throw new RuntimeException("文件不存在！");
        }

        return "开始保存名片到本地";

    }
}
