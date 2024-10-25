package com.rongl.controller;


import com.rongl.common.BCardUtils;
import com.rongl.common.PropertiesCommon;
import com.rongl.common.ReturnResult;
import com.rongl.entity.AiCardInfo;
import com.rongl.service.IAiCardInfoService;
import com.rongl.service.impl.AiCardInfoServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 李中华
 * @since 2024-10-24
 */
@Api(tags = "AI名片管理")//：该注解标注在接口模块类上，用于对接口模块类进行描述说明
@Slf4j
@RestController
@RequestMapping("/api/aiCardInfo")
public class AiCardInfoController {

    @Autowired
    private AiCardInfoServiceImpl aiCardInfoService;

    @Value("${bCard-path-win}")
    private String pathWin;
    @Value("${bCard-path-linux}")
    private String pathLinux;
    @Value("${bCard-outpath-linux}")
    private String outpathLinux;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "名片上传 ", notes = " 上传名片 ， 默认上传到本地")
    public ReturnResult uploadFileToLocal(@RequestParam("bCardfile") MultipartFile file, HttpServletRequest request) {

        log.info("上传名片");

        try {
            UUID uuid = UUID.randomUUID();
            String uploadfile = "";
            if (BCardUtils.getCurrentOS().equals( PropertiesCommon.OSwin)) {
                uploadfile = pathWin +uuid+file.getOriginalFilename();

            }else if (BCardUtils.getCurrentOS().equals( PropertiesCommon.OSlinux)) {
                uploadfile = pathLinux +uuid+file.getOriginalFilename();
                outpathLinux = outpathLinux+uuid+file.getOriginalFilename();
            }else if (BCardUtils.getCurrentOS().equals( PropertiesCommon.OSmac)) {
                uploadfile = pathLinux +uuid+file.getOriginalFilename();
                outpathLinux = outpathLinux+uuid+file.getOriginalFilename();
            }else {
                log.error("未知的操作系统");
                return ReturnResult.ErrorLogout();
            }
            String headerToken  = request.getHeader("X-Token"); //
            String uid  = request.getHeader("uniqueId");
            // 从header 里获取用户 唯一标识，用于后续 记录日志 ； 禁止批量上传
            log.info("X-Token ： "+headerToken);
            log.info("uid  ： "+uid);
            log.info("文件保存路径：" + uploadfile);
            Files.copy(file.getInputStream(), Paths.get(uploadfile));

            String s = aiCardInfoService.uploadFile(outpathLinux);

        } catch (IOException e) {
           log.error(e.getMessage());
        }

        return ReturnResult.ErrorLogout();
    }


    @PostMapping
    @ApiOperation(value = "新增AI卡片", notes = "根据AiCardInfo对象新增一条记录")
    public ReturnResult add(@RequestBody AiCardInfo aiCardInfo) {
        log.info("新增AI卡片");
        try {
            aiCardInfoService.save(aiCardInfo);
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return  ReturnResult.OK();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除AI卡片", notes = "根据ID删除一条记录")
    public ReturnResult delete(@PathVariable Long id) {
        try {
            aiCardInfoService.removeById(id);
        }catch (Exception e){
                log.error(e.getMessage());
        }

        return  ReturnResult.OK();
    }

    @PutMapping
    @ApiOperation(value = "修改AI卡片", notes = "根据AiCardInfo对象修改一条记录")
    public ReturnResult update(@RequestBody com.rongl.entity.AiCardInfo aiCardInfo) {


        try {
            aiCardInfoService.updateById(aiCardInfo);
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return  ReturnResult.OK();

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询AI卡片", notes = "根据ID查询一条记录")
    public ReturnResult   get(@PathVariable Long id) {
        AiCardInfo byId=null;
        try {
              byId = aiCardInfoService.getById(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return  ReturnResult.OK().setData(byId);

    }


    @ApiOperation(value = "查询所有AI卡片", notes = "查询所有记录")
    @RequestMapping(value = "/listAllCards", method = RequestMethod.POST)
    public ReturnResult listAll() {

        log.info("查询所有AI卡片");
        List<AiCardInfo> cardInfos = null;
        try {
            cardInfos = aiCardInfoService.listAll();
            log.info("查询到"+cardInfos.size()+"条数据");
            cardInfos.forEach(cardInfo -> log.info(cardInfo.toString()));

        }catch (Exception e){
            log.error(e.getMessage());
        }

        return  ReturnResult.OK().setData(cardInfos);

    }

}
