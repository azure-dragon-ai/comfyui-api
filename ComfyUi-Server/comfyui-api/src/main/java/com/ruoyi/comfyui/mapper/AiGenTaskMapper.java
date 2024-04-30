package com.ruoyi.comfyui.mapper;

import java.util.List;
import com.ruoyi.comfyui.domain.AiGenTask;

/**
 * AI生产任务Mapper接口
 * 
 * @author yangshare
 * @date 2024-04-30
 */
public interface AiGenTaskMapper 
{
    /**
     * 查询AI生产任务
     * 
     * @param id AI生产任务主键
     * @return AI生产任务
     */
    public AiGenTask selectAiGenTaskById(Long id);

    /**
     * 查询AI生产任务列表
     * 
     * @param aiGenTask AI生产任务
     * @return AI生产任务集合
     */
    public List<AiGenTask> selectAiGenTaskList(AiGenTask aiGenTask);

    /**
     * 新增AI生产任务
     * 
     * @param aiGenTask AI生产任务
     * @return 结果
     */
    public int insertAiGenTask(AiGenTask aiGenTask);

    /**
     * 修改AI生产任务
     * 
     * @param aiGenTask AI生产任务
     * @return 结果
     */
    public int updateAiGenTask(AiGenTask aiGenTask);

    /**
     * 删除AI生产任务
     * 
     * @param id AI生产任务主键
     * @return 结果
     */
    public int deleteAiGenTaskById(Long id);

    /**
     * 批量删除AI生产任务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiGenTaskByIds(Long[] ids);
}
