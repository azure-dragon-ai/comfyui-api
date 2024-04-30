package com.ruoyi.comfyui.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * AI生产任务对象 ai_gen_task
 * 
 * @author yangshare
 * @date 2024-04-30
 */
public class AiGenTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 该字段唯一且自增 */
    private Long id;

    /** 提示词 */
    @Excel(name = "提示词")
    private String prompt;

    /** 工作流 */
    @Excel(name = "工作流")
    private Long workflowId;

    /** 任务执行的结果图片在comfyui客户端生成的任务id，用于查询生成图片 */
    @Excel(name = "任务执行的结果图片在comfyui客户端生成的任务id，用于查询生成图片")
    private Long promptId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPrompt(String prompt) 
    {
        this.prompt = prompt;
    }

    public String getPrompt() 
    {
        return prompt;
    }
    public void setWorkflowId(Long workflowId) 
    {
        this.workflowId = workflowId;
    }

    public Long getWorkflowId() 
    {
        return workflowId;
    }
    public void setPromptId(Long promptId) 
    {
        this.promptId = promptId;
    }

    public Long getPromptId() 
    {
        return promptId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("prompt", getPrompt())
            .append("workflowId", getWorkflowId())
            .append("promptId", getPromptId())
            .toString();
    }
}
