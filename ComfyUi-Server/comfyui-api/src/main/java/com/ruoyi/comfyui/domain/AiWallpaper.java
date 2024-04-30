package com.ruoyi.comfyui.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * AI附件对象 ai_wallpaper
 * 
 * @author yangshare
 * @date 2024-04-30
 */
public class AiWallpaper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 该字段唯一且自增 */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 壁纸分辨率，比如：1920*1080 */
    @Excel(name = "壁纸分辨率，比如：1920*1080")
    private String resolution;

    /** 一个壁纸可以有多个标签，标签对应的字典【标签】，存字典value字段，多个用英文逗号间隔，比如：10,20,30
 */
    @Excel(name = "一个壁纸可以有多个标签，标签对应的字典【标签】，存字典value字段，多个用英文逗号间隔，比如：10,20,30")
    private String tag;

    /** 一个壁纸只能有一个场景分类，分类对应的字典【壁纸场景分类】，存字典value字段 */
    @Excel(name = "一个壁纸只能有一个场景分类，分类对应的字典【壁纸场景分类】，存字典value字段")
    private String scenesType;

    /** 一个壁纸只能有一个设备分类，分类对应的字典【壁纸设备分类】，存字典value字段 */
    @Excel(name = "一个壁纸只能有一个设备分类，分类对应的字典【壁纸设备分类】，存字典value字段")
    private String deviceType;

    /** 缩略图附件，ai_attchinfo表的id
 */
    @Excel(name = "缩略图附件，ai_attchinfo表的id")
    private Long thumbAttchId;

    /** 原始图附件，ai_attchinfo表的id */
    @Excel(name = "原始图附件，ai_attchinfo表的id")
    private Long imageAttchId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setResolution(String resolution) 
    {
        this.resolution = resolution;
    }

    public String getResolution() 
    {
        return resolution;
    }
    public void setTag(String tag) 
    {
        this.tag = tag;
    }

    public String getTag() 
    {
        return tag;
    }
    public void setScenesType(String scenesType) 
    {
        this.scenesType = scenesType;
    }

    public String getScenesType() 
    {
        return scenesType;
    }
    public void setDeviceType(String deviceType) 
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType() 
    {
        return deviceType;
    }
    public void setThumbAttchId(Long thumbAttchId) 
    {
        this.thumbAttchId = thumbAttchId;
    }

    public Long getThumbAttchId() 
    {
        return thumbAttchId;
    }
    public void setImageAttchId(Long imageAttchId) 
    {
        this.imageAttchId = imageAttchId;
    }

    public Long getImageAttchId() 
    {
        return imageAttchId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("resolution", getResolution())
            .append("tag", getTag())
            .append("scenesType", getScenesType())
            .append("deviceType", getDeviceType())
            .append("createtime", getCreateTime())
            .append("thumbAttchId", getThumbAttchId())
            .append("imageAttchId", getImageAttchId())
            .toString();
    }
}
