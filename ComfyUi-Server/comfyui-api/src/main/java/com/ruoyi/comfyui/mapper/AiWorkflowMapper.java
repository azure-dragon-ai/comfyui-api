package com.ruoyi.comfyui.mapper;

import java.util.List;
import com.ruoyi.comfyui.domain.AiWorkflow;

/**
 * AI生成工作流Mapper接口
 * 
 * @author yangshare
 * @date 2024-04-30
 */
public interface AiWorkflowMapper 
{
    /**
     * 查询AI生成工作流
     * 
     * @param id AI生成工作流主键
     * @return AI生成工作流
     */
    public AiWorkflow selectAiWorkflowById(Long id);

    /**
     * 查询AI生成工作流列表
     * 
     * @param aiWorkflow AI生成工作流
     * @return AI生成工作流集合
     */
    public List<AiWorkflow> selectAiWorkflowList(AiWorkflow aiWorkflow);

    /**
     * 新增AI生成工作流
     * 
     * @param aiWorkflow AI生成工作流
     * @return 结果
     */
    public int insertAiWorkflow(AiWorkflow aiWorkflow);

    /**
     * 修改AI生成工作流
     * 
     * @param aiWorkflow AI生成工作流
     * @return 结果
     */
    public int updateAiWorkflow(AiWorkflow aiWorkflow);

    /**
     * 删除AI生成工作流
     * 
     * @param id AI生成工作流主键
     * @return 结果
     */
    public int deleteAiWorkflowById(Long id);

    /**
     * 批量删除AI生成工作流
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiWorkflowByIds(Long[] ids);
}
