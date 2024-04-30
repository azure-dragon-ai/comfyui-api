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

    /** $column.columnComment */
    private Long id;

    /** 工作流json文件附件id
 */
    @Excel(name = "工作流json文件附件id")
    private Long jsonAttchId;

    /** 工作流api-json文件附件id */
    @Excel(name = "工作流api-json文件附件id")
    private Long apiAttchId;

    /** comfyui工作流名称 */
    @Excel(name = "comfyui工作流名称")
    private String name;

    /** comfyui工作流api文件的节点组 */
    @Excel(name = "comfyui工作流api文件的节点组")
    private String nodes;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setJsonAttchId(Long jsonAttchId) 
    {
        this.jsonAttchId = jsonAttchId;
    }

    public Long getJsonAttchId() 
    {
        return jsonAttchId;
    }
    public void setApiAttchId(Long apiAttchId) 
    {
        this.apiAttchId = apiAttchId;
    }

    public Long getApiAttchId() 
    {
        return apiAttchId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
            .append("jsonAttchId", getJsonAttchId())
            .append("apiAttchId", getApiAttchId())
            .append("name", getName())
            .append("nodes", getNodes())
            .toString();
    }
}
