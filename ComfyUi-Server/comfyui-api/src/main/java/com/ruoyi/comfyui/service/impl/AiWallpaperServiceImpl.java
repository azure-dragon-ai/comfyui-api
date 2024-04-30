package com.ruoyi.comfyui.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.comfyui.mapper.AiWallpaperMapper;
import com.ruoyi.comfyui.domain.AiWallpaper;
import com.ruoyi.comfyui.service.IAiWallpaperService;

/**
 * AI附件Service业务层处理
 * 
 * @author yangshare
 * @date 2024-04-30
 */
@Service
public class AiWallpaperServiceImpl implements IAiWallpaperService 
{
    @Autowired
    private AiWallpaperMapper aiWallpaperMapper;

    /**
     * 查询AI附件
     * 
     * @param id AI附件主键
     * @return AI附件
     */
    @Override
    public AiWallpaper selectAiWallpaperById(Long id)
    {
        return aiWallpaperMapper.selectAiWallpaperById(id);
    }

    /**
     * 查询AI附件列表
     * 
     * @param aiWallpaper AI附件
     * @return AI附件
     */
    @Override
    public List<AiWallpaper> selectAiWallpaperList(AiWallpaper aiWallpaper)
    {
        return aiWallpaperMapper.selectAiWallpaperList(aiWallpaper);
    }

    /**
     * 新增AI附件
     * 
     * @param aiWallpaper AI附件
     * @return 结果
     */
    @Override
    public int insertAiWallpaper(AiWallpaper aiWallpaper)
    {
        return aiWallpaperMapper.insertAiWallpaper(aiWallpaper);
    }

    /**
     * 修改AI附件
     * 
     * @param aiWallpaper AI附件
     * @return 结果
     */
    @Override
    public int updateAiWallpaper(AiWallpaper aiWallpaper)
    {
        return aiWallpaperMapper.updateAiWallpaper(aiWallpaper);
    }

    /**
     * 批量删除AI附件
     * 
     * @param ids 需要删除的AI附件主键
     * @return 结果
     */
    @Override
    public int deleteAiWallpaperByIds(Long[] ids)
    {
        return aiWallpaperMapper.deleteAiWallpaperByIds(ids);
    }

    /**
     * 删除AI附件信息
     * 
     * @param id AI附件主键
     * @return 结果
     */
    @Override
    public int deleteAiWallpaperById(Long id)
    {
        return aiWallpaperMapper.deleteAiWallpaperById(id);
    }
}
