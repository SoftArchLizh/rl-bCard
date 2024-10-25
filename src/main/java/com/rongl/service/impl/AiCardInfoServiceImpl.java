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
        // 文件保存在本地文件夹
        String filePath = "D:/";
        String fileName = file.getOriginalFilename();
        path = filePath + fileName;
        try {
            file.transferTo(new java.io.File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("文件保存成功！");
        System.out.println("文件保存路径：" + path);
        System.out.println("文件大小：" + file.getSize());
        System.out.println("文件类型：" + file.getContentType());
        System.out.println("文件名称：" + file.getName());
        System.out.println("文件原始名称：" + file.getOriginalFilename());

        boolean flag = false;
        if (file.isEmpty()) {
            throw new RuntimeException("文件不存在！");
        }

        return "";

    }
}
