package com.ruoyi.comfyui.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.comfyui.mapper.AiAttchinfoMapper;
import com.ruoyi.comfyui.domain.AiAttchinfo;
import com.ruoyi.comfyui.service.IAiAttchinfoService;

/**
 * AI附件Service业务层处理
 * 
 * @author yangshare
 * @date 2024-04-30
 */
@Service
public class AiAttchinfoServiceImpl implements IAiAttchinfoService 
{
    @Autowired
    private AiAttchinfoMapper aiAttchinfoMapper;

    /**
     * 查询AI附件
     * 
     * @param id AI附件主键
     * @return AI附件
     */
    @Override
    public AiAttchinfo selectAiAttchinfoById(Long id)
    {
        return aiAttchinfoMapper.selectAiAttchinfoById(id);
    }

    /**
     * 查询AI附件列表
     * 
     * @param aiAttchinfo AI附件
     * @return AI附件
     */
    @Override
    public List<AiAttchinfo> selectAiAttchinfoList(AiAttchinfo aiAttchinfo)
    {
        return aiAttchinfoMapper.selectAiAttchinfoList(aiAttchinfo);
    }

    /**
     * 新增AI附件
     * 
     * @param aiAttchinfo AI附件
     * @return 结果
     */
    @Override
    public int insertAiAttchinfo(AiAttchinfo aiAttchinfo)
    {
        return aiAttchinfoMapper.insertAiAttchinfo(aiAttchinfo);
    }

    /**
     * 修改AI附件
     * 
     * @param aiAttchinfo AI附件
     * @return 结果
     */
    @Override
    public int updateAiAttchinfo(AiAttchinfo aiAttchinfo)
    {
        return aiAttchinfoMapper.updateAiAttchinfo(aiAttchinfo);
    }

    /**
     * 批量删除AI附件
     * 
     * @param ids 需要删除的AI附件主键
     * @return 结果
     */
    @Override
    public int deleteAiAttchinfoByIds(Long[] ids)
    {
        return aiAttchinfoMapper.deleteAiAttchinfoByIds(ids);
    }

    /**
     * 删除AI附件信息
     * 
     * @param id AI附件主键
     * @return 结果
     */
    @Override
    public int deleteAiAttchinfoById(Long id)
    {
        return aiAttchinfoMapper.deleteAiAttchinfoById(id);
    }
}
