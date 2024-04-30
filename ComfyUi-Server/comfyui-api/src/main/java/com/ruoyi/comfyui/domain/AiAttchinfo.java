package com.ruoyi.comfyui.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * AI附件对象 ai_attchinfo
 * 
 * @author yangshare
 * @date 2024-04-30
 */
public class AiAttchinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 该字段唯一且自增 */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String contenttype;

    /** 存储大小，单位为kb，比如：13156465 */
    @Excel(name = "存储大小，单位为kb，比如：13156465")
    private Long storage;

    /** 一个壁纸可以有多个标签，标签对应的字典【标签】，存字典value字段，多个用英文逗号间隔，比如：10,20,30
 */
    @Excel(name = "一个壁纸可以有多个标签，标签对应的字典【标签】，存字典value字段，多个用英文逗号间隔，比如：10,20,30")
    private String tag;

    /** 存储路径，比如：http://qiniu.com?id=2332323 */
    @Excel(name = "存储路径，比如：http://qiniu.com?id=2332323")
    private String filepath;

    /** 存储方式，比如：local 本地、qiniu 七牛、aliyun 阿里云oss */
    @Excel(name = "存储方式，比如：local 本地、qiniu 七牛、aliyun 阿里云oss")
    private String storageType;

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
    public void setContenttype(String contenttype) 
    {
        this.contenttype = contenttype;
    }

    public String getContenttype() 
    {
        return contenttype;
    }
    public void setStorage(Long storage) 
    {
        this.storage = storage;
    }

    public Long getStorage() 
    {
        return storage;
    }
    public void setTag(String tag) 
    {
        this.tag = tag;
    }

    public String getTag() 
    {
        return tag;
    }
    public void setFilepath(String filepath) 
    {
        this.filepath = filepath;
    }

    public String getFilepath() 
    {
        return filepath;
    }
    public void setStorageType(String storageType) 
    {
        this.storageType = storageType;
    }

    public String getStorageType() 
    {
        return storageType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("contenttype", getContenttype())
            .append("storage", getStorage())
            .append("tag", getTag())
            .append("filepath", getFilepath())
            .append("storageType", getStorageType())
            .append("createtime", getCreateTime())
            .toString();
    }
}
