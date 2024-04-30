package com.ruoyi.comfyui.service;

import java.util.List;
import com.ruoyi.comfyui.domain.AiWallpaper;

/**
 * AI附件Service接口
 * 
 * @author yangshare
 * @date 2024-04-30
 */
public interface IAiWallpaperService 
{
    /**
     * 查询AI附件
     * 
     * @param id AI附件主键
     * @return AI附件
     */
    public AiWallpaper selectAiWallpaperById(Long id);

    /**
     * 查询AI附件列表
     * 
     * @param aiWallpaper AI附件
     * @return AI附件集合
     */
    public List<AiWallpaper> selectAiWallpaperList(AiWallpaper aiWallpaper);

    /**
     * 新增AI附件
     * 
     * @param aiWallpaper AI附件
     * @return 结果
     */
    public int insertAiWallpaper(AiWallpaper aiWallpaper);

    /**
     * 修改AI附件
     * 
     * @param aiWallpaper AI附件
     * @return 结果
     */
    public int updateAiWallpaper(AiWallpaper aiWallpaper);

    /**
     * 批量删除AI附件
     * 
     * @param ids 需要删除的AI附件主键集合
     * @return 结果
     */
    public int deleteAiWallpaperByIds(Long[] ids);

    /**
     * 删除AI附件信息
     * 
     * @param id AI附件主键
     * @return 结果
     */
    public int deleteAiWallpaperById(Long id);
}
