package com.volvo.invoice.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.volvo.invoice.dto.*;
import com.volvo.invoice.mapper.TtInvoiceRecordMapper;
import com.volvo.invoice.service.InvoiceInfoService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@Slf4j
public class InvoiceInfoServiceImpl
        extends ServiceImpl<TtInvoiceRecordMapper, TtInvoiceRecord>
        implements InvoiceInfoService {

    @Override
    public void insertVJdcfphz(TtInvoiceRecord vJdcfphz) {
        log.info("开始执行业务方法: " + vJdcfphz);

        this.save(vJdcfphz);
        log.info("");

    }

    @Override
    public ResponseDTO<List<OpenRushInvoiceRespDTO>> openInvoice(OpenRushInvoiceReqDTO openRushInvoiceReqDTO) {

        log.info("正在开票。。。");
        return this.openRushInvoice(RedBlueEnum.BLUE, openRushInvoiceReqDTO);
    }

    private ResponseDTO<List<OpenRushInvoiceRespDTO>> openRushInvoice(RedBlueEnum redBlueEnum, OpenRushInvoiceReqDTO openRushInvoiceReqDTO)
    {
        if(null == openRushInvoiceReqDTO){
            return ResponseUtils.failure(ResponseCodeEnum.PARAMS_CODE_ERROR.value(),ResponseCodeEnum.PARAMS_CODE_ERROR.getDesc());
        }

        //验证最外层参数
        Map<String, StringBuilder> errorMap = new HashMap<>();
//        ValidatorUtils.validate(openRushInvoiceReqDTO, errorMap);
        if (errorMap.size() > 0) {
            return ResponseUtils.failure(ResponseCodeEnum.PARAMS_CODE_ERROR.value(), JSON.toJSONString(errorMap));
        }

        //业务方验证
        //校验 业务方是否在咱们定义的枚举列表中
        if(!InvoiceBusinessCode.checkCodeExist(openRushInvoiceReqDTO.getBusinessCode())){
            return ResponseUtils.failure(ResponseCodeEnum.PARAMS_CODE_ERROR.value(),"业务方"+openRushInvoiceReqDTO.getBusinessCode()+"不存在，不能开票");
        }

        if(CollectionUtils.isEmpty(openRushInvoiceReqDTO.getContent().getCommonInvoiceList())
                && CollectionUtils.isEmpty(openRushInvoiceReqDTO.getContent().getIncemetInvoiceList())
                && CollectionUtils.isEmpty(openRushInvoiceReqDTO.getContent().getStandardInvoiceList())){
            return ResponseUtils.failure(ResponseCodeEnum.PARAMS_CODE_ERROR.value(),"发票内容里commonInvoiceList、incemetInvoiceList、stanldInvoiceList三个参数不能都为空！");
        }

        List<OpenRushInvoiceRespDTO> respDTOList = new ArrayList<>();
        //执行发票1.0的开票流程

        //执行发票1.5的开票流程

        //执行发票2.0的开票流程
        List<OpenRushStandardInvoiceReqDTO> standardInvoiceList = openRushInvoiceReqDTO.getContent().getStandardInvoiceList();
        if(!CollectionUtils.isEmpty(standardInvoiceList)){
            List<OpenRushInvoiceRespDTO> respStandardDTOList = openRushStandardInvoice(redBlueEnum, openRushInvoiceReqDTO.getBusinessCode(),openRushInvoiceReqDTO.getRequestId(),standardInvoiceList);
            if(!CollectionUtils.isEmpty(respStandardDTOList)){
                respDTOList.addAll(respStandardDTOList);
            }
        }

        if(CollectionUtils.isEmpty(respDTOList)){
            return ResponseUtils.success(respDTOList);
        }else{
            if(respDTOList.stream().anyMatch(i -> !i.isSuccessFlag())){
                return ResponseUtils.failure(respDTOList);
            }else{
                return ResponseUtils.success(respDTOList);
            }
        }
    }



    private List<OpenRushInvoiceRespDTO> openRushStandardInvoice(RedBlueEnum redBlueEnum,String businessCode,String requestId, List<OpenRushStandardInvoiceReqDTO> stanldInvoiceList) {
        List<OpenRushInvoiceRespDTO> respDTOList = new ArrayList<>();
        OpenRushInvoiceRespDTO openRushInvoiceRespDTO;
//        InvoiceSalesConfigDO invoiceSalesConfigDO;
         Object invoiceSalesConfigDO;
        for (OpenRushStandardInvoiceReqDTO openRushStandardInvoiceReqDTO : stanldInvoiceList) {
            //校验参数
            //判断是否重复提交
//            openRushInvoiceRespDTO = this.checkRepeatedSubmission(redBlueEnum,businessCode, requestId, openRushStandardInvoiceReqDTO);
            openRushInvoiceRespDTO = null; //this.checkRepeatedSubmission(redBlueEnum,businessCode, requestId, openRushStandardInvoiceReqDTO);
            if(null != openRushInvoiceRespDTO){
                respDTOList.add(openRushInvoiceRespDTO);
                return respDTOList;
            }

            openRushInvoiceRespDTO = new OpenRushInvoiceRespDTO();
            //从数据库中获取销方信息
//            invoiceSalesConfigDO = invoiceSalesConfigService.getByMainMerchantCode(openRushStandardInvoiceReqDTO.getMainMerchantCode());
            invoiceSalesConfigDO = null ;//invoiceSalesConfigService.getByMainMerchantCode(openRushStandardInvoiceReqDTO.getMainMerchantCode());
            if(null == invoiceSalesConfigDO || StringUtils.isBlank("SellerTaxNum" )){
//            if(null == invoiceSalesConfigDO || StringUtils.isBlank(invoiceSalesConfigDO.getSellerTaxNum())){
                openRushInvoiceRespDTO.setSuccessFlag(false);
                openRushInvoiceRespDTO.setErrorCode(ResponseCodeEnum.OPEN_RUSH_MAIN_MERCHANT_NOT_EXIST.value());
                openRushInvoiceRespDTO.setErrorMsg(ResponseCodeEnum.OPEN_RUSH_MAIN_MERCHANT_NOT_EXIST.getDesc());
                respDTOList.add(openRushInvoiceRespDTO);
                return respDTOList;
            }

            //填充信息
//            setParamsForOpenRushInvoiceRespDTO(redBlueEnum,openRushStandardInvoiceReqDTO, invoiceSalesConfigDO);

            //验证参数
//            openRushInvoiceRespDTO = this.openRushCheckParams(openRushStandardInvoiceReqDTO, invoiceSalesConfigDO, businessCode);
            openRushInvoiceRespDTO =null ;
            if (!openRushInvoiceRespDTO.isSuccessFlag()) {
                respDTOList.add(openRushInvoiceRespDTO);
                return respDTOList;
            }

            //调用开票，并存储数据到库中
            openRushInvoiceRespDTO = null ; //operationOpenOrRushInvoice(businessCode,requestId,openRushStandardInvoiceReqDTO);
//            openRushInvoiceRespDTO = operationOpenOrRushInvoice(businessCode,requestId,openRushStandardInvoiceReqDTO);
            if(!openRushInvoiceRespDTO.isSuccessFlag()){
                respDTOList.add(openRushInvoiceRespDTO);
                return respDTOList;
            }
//            openRushInvoiceRespDTO.setOrderNo(openRushStandardInvoiceReqDTO.getOrderNo());
            openRushInvoiceRespDTO.setOrderNo( "");
            respDTOList.add(openRushInvoiceRespDTO);
        }
        return respDTOList;
    }

    @Override
    public void deleteVJdcfphz(Long id) {
        this.removeById(id);
    }

    @Override
    public TtInvoiceRecord getVJdcfphzById(Long id) {
        return this.getById(id);
    }

    @Override
    public List<TtInvoiceRecord> selectInvoiceInfoByFrameNumber(String frameNumber) {
        return null;
    }
}
