package com.rongl.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 李中华 ,wx:spllzh, Email: 28668817@qq.com
 * @since 2024-10-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ai_card_info")
@ApiModel(value="AiCardInfo对象", description="")
public class AiCardInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("id_key")
    private Long idKey;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "职位")
    @TableField("position")
    private String position;

    @ApiModelProperty(value = "Email")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "移动电话")
    @TableField("mobile_phone")
    private String mobilePhone;

    @ApiModelProperty(value = "公司")
    @TableField("company")
    private String company;

    @ApiModelProperty(value = "简介")
    @TableField("introduction")
    private String introduction;

    @ApiModelProperty(value = "头像url")
    @TableField("avatar_url")
    private String avatarUrl;

    @ApiModelProperty(value = "别名")
    @TableField("alias")
    private String alias;

    @ApiModelProperty(value = "公司简介")
    @TableField("company_introduction")
    private String companyIntroduction;

    @ApiModelProperty(value = "公司图片URL")
    @TableField("company_image_url")
    private String companyImageUrl;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_at")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "修改时间")
    @TableField("updated_at")
    private LocalDateTime updatedAt;

    @ApiModelProperty(value = "逻辑删除")
    @TableField("is_deleted")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建人")
    @TableField("created_by")
    private String createdBy;

    @ApiModelProperty(value = "修改人")
    @TableField("updated_by")
    private String updatedBy;


}
