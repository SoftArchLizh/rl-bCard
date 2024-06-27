package com.volvo.invoice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 开票/红冲发票对象里的content
 */
@Data
public class OpenRushInvoiceContentReqDTO {

    @ApiModelProperty("增值税1.5接口，列表对象")
    private List<TtOrderStartDTO> commonInvoiceList;

    //这个需要等1208分支的代码合并到1230之后，将对象改为1.5的适配对象
    @ApiModelProperty("发票1.5接口，列表对象")
    private List<NuoShuiInvoiceDTO> incemetInvoiceList;

    @ApiModelProperty("发票2.0接口用的对象")
    private List<OpenRushStandardInvoiceReqDTO> standardInvoiceList;
}
