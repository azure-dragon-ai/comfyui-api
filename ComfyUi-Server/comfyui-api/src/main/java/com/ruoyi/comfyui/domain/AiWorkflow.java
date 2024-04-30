package com.ruoyi.comfyui.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * AI生成工作流对象 ai_workflow
 * 
 * @author yangshare
 * @date 2024-04-30
 */
public class AiWorkflow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 工作流文件
 */
    @Excel(name = "工作流文件")
    private String jsonFilepath;

    /** 工作流接口文件 */
    @Excel(name = "工作流接口文件")
    private String apiFilepath;

    /** 节点组 */
    @Excel(name = "节点组")
    private String nodes;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setJsonFilepath(String jsonFilepath) 
    {
        this.jsonFilepath = jsonFilepath;
    }

    public String getJsonFilepath() 
    {
        return jsonFilepath;
    }
    public void setApiFilepath(String apiFilepath) 
    {
        this.apiFilepath = apiFilepath;
    }

    public String getApiFilepath() 
    {
        return apiFilepath;
    }
    public void setNodes(String nodes) 
    {
        this.nodes = nodes;
    }

    public String getNodes() 
    {
        return nodes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("jsonFilepath", getJsonFilepath())
            .append("apiFilepath", getApiFilepath())
            .append("nodes", getNodes())
            .toString();
    }
}
