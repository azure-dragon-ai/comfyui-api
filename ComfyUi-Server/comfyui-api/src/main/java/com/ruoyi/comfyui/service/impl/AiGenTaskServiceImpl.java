package com.ruoyi.comfyui.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.comfyui.mapper.AiGenTaskMapper;
import com.ruoyi.comfyui.domain.AiGenTask;
import com.ruoyi.comfyui.service.IAiGenTaskService;

/**
 * AI生产任务Service业务层处理
 * 
 * @author yangshare
 * @date 2024-04-30
 */
@Service
public class AiGenTaskServiceImpl implements IAiGenTaskService 
{
    @Autowired
    private AiGenTaskMapper aiGenTaskMapper;

    /**
     * 查询AI生产任务
     * 
     * @param id AI生产任务主键
     * @return AI生产任务
     */
    @Override
    public AiGenTask selectAiGenTaskById(Long id)
    {
        return aiGenTaskMapper.selectAiGenTaskById(id);
    }

    /**
     * 查询AI生产任务列表
     * 
     * @param aiGenTask AI生产任务
     * @return AI生产任务
     */
    @Override
    public List<AiGenTask> selectAiGenTaskList(AiGenTask aiGenTask)
    {
        return aiGenTaskMapper.selectAiGenTaskList(aiGenTask);
    }

    /**
     * 新增AI生产任务
     * 
     * @param aiGenTask AI生产任务
     * @return 结果
     */
    @Override
    public int insertAiGenTask(AiGenTask aiGenTask)
    {
        return aiGenTaskMapper.insertAiGenTask(aiGenTask);
    }

    /**
     * 修改AI生产任务
     * 
     * @param aiGenTask AI生产任务
     * @return 结果
     */
    @Override
    public int updateAiGenTask(AiGenTask aiGenTask)
    {
        return aiGenTaskMapper.updateAiGenTask(aiGenTask);
    }

    /**
     * 批量删除AI生产任务
     * 
     * @param ids 需要删除的AI生产任务主键
     * @return 结果
     */
    @Override
    public int deleteAiGenTaskByIds(Long[] ids)
    {
        return aiGenTaskMapper.deleteAiGenTaskByIds(ids);
    }

    /**
     * 删除AI生产任务信息
     * 
     * @param id AI生产任务主键
     * @return 结果
     */
    @Override
    public int deleteAiGenTaskById(Long id)
    {
        return aiGenTaskMapper.deleteAiGenTaskById(id);
    }
}
