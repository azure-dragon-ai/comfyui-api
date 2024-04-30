package com.ruoyi.comfyui.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.comfyui.domain.AiWallpaper;
import com.ruoyi.comfyui.service.IAiWallpaperService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * AI附件Controller
 * 
 * @author yangshare
 * @date 2024-04-30
 */
@RestController
@RequestMapping("/comfyui/wallpaper")
public class AiWallpaperController extends BaseController
{
    @Autowired
    private IAiWallpaperService aiWallpaperService;

    /**
     * 查询AI附件列表
     */
    @PreAuthorize("@ss.hasPermi('comfyui:wallpaper:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiWallpaper aiWallpaper)
    {
        startPage();
        List<AiWallpaper> list = aiWallpaperService.selectAiWallpaperList(aiWallpaper);
        return getDataTable(list);
    }

    /**
     * 导出AI附件列表
     */
    @PreAuthorize("@ss.hasPermi('comfyui:wallpaper:export')")
    @Log(title = "AI附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiWallpaper aiWallpaper)
    {
        List<AiWallpaper> list = aiWallpaperService.selectAiWallpaperList(aiWallpaper);
        ExcelUtil<AiWallpaper> util = new ExcelUtil<AiWallpaper>(AiWallpaper.class);
        util.exportExcel(response, list, "AI附件数据");
    }

    /**
     * 获取AI附件详细信息
     */
    @PreAuthorize("@ss.hasPermi('comfyui:wallpaper:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiWallpaperService.selectAiWallpaperById(id));
    }

    /**
     * 新增AI附件
     */
    @PreAuthorize("@ss.hasPermi('comfyui:wallpaper:add')")
    @Log(title = "AI附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiWallpaper aiWallpaper)
    {
        return toAjax(aiWallpaperService.insertAiWallpaper(aiWallpaper));
    }

    /**
     * 修改AI附件
     */
    @PreAuthorize("@ss.hasPermi('comfyui:wallpaper:edit')")
    @Log(title = "AI附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiWallpaper aiWallpaper)
    {
        return toAjax(aiWallpaperService.updateAiWallpaper(aiWallpaper));
    }

    /**
     * 删除AI附件
     */
    @PreAuthorize("@ss.hasPermi('comfyui:wallpaper:remove')")
    @Log(title = "AI附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiWallpaperService.deleteAiWallpaperByIds(ids));
    }
}
