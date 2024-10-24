package com.rongl.controller;


import com.rongl.common.ReturnResult;
import com.rongl.entity.AiCardInfo;
import com.rongl.service.IAiCardInfoService;
import com.rongl.service.impl.AiCardInfoServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


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

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "名片上传 ", notes = " 上传名片 ， 默认上传到本地")
    public ReturnResult uploadFileMinio(@RequestParam("resumefile") MultipartFile file) {

        log.info("上传名片");
        String s = aiCardInfoService.uploadFile(file);
        return ReturnResult.ErrorLogout();
    }


    @PostMapping
    @ApiOperation(value = "新增AI卡片", notes = "根据AiCardInfo对象新增一条记录")
    public ReturnResult add(@RequestBody AiCardInfo aiCardInfo) {

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

    @GetMapping
    @ApiOperation(value = "查询所有AI卡片", notes = "查询所有记录")
    public ReturnResult listAll() {

        List<AiCardInfo> cardInfos = null;
        try {
            cardInfos = aiCardInfoService.listAll();
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return  ReturnResult.OK().setData(cardInfos);

    }

}
