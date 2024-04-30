package com.ruoyi.comfyui.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.comfyui.mapper.AiWorkflowMapper;
import com.ruoyi.comfyui.domain.AiWorkflow;
import com.ruoyi.comfyui.service.IAiWorkflowService;

/**
 * AI生成工作流Service业务层处理
 * 
 * @author yangshare
 * @date 2024-04-30
 */
@Service
public class AiWorkflowServiceImpl implements IAiWorkflowService 
{
    @Autowired
    private AiWorkflowMapper aiWorkflowMapper;

    /**
     * 查询AI生成工作流
     * 
     * @param id AI生成工作流主键
     * @return AI生成工作流
     */
    @Override
    public AiWorkflow selectAiWorkflowById(Long id)
    {
        return aiWorkflowMapper.selectAiWorkflowById(id);
    }

    /**
     * 查询AI生成工作流列表
     * 
     * @param aiWorkflow AI生成工作流
     * @return AI生成工作流
     */
    @Override
    public List<AiWorkflow> selectAiWorkflowList(AiWorkflow aiWorkflow)
    {
        return aiWorkflowMapper.selectAiWorkflowList(aiWorkflow);
    }

    /**
     * 新增AI生成工作流
     * 
     * @param aiWorkflow AI生成工作流
     * @return 结果
     */
    @Override
    public int insertAiWorkflow(AiWorkflow aiWorkflow)
    {
        return aiWorkflowMapper.insertAiWorkflow(aiWorkflow);
    }

    /**
     * 修改AI生成工作流
     * 
     * @param aiWorkflow AI生成工作流
     * @return 结果
     */
    @Override
    public int updateAiWorkflow(AiWorkflow aiWorkflow)
    {
        return aiWorkflowMapper.updateAiWorkflow(aiWorkflow);
    }

    /**
     * 批量删除AI生成工作流
     * 
     * @param ids 需要删除的AI生成工作流主键
     * @return 结果
     */
    @Override
    public int deleteAiWorkflowByIds(Long[] ids)
    {
        return aiWorkflowMapper.deleteAiWorkflowByIds(ids);
    }

    /**
     * 删除AI生成工作流信息
     * 
     * @param id AI生成工作流主键
     * @return 结果
     */
    @Override
    public int deleteAiWorkflowById(Long id)
    {
        return aiWorkflowMapper.deleteAiWorkflowById(id);
    }
}
