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
import com.ruoyi.comfyui.domain.AiAttchinfo;
import com.ruoyi.comfyui.service.IAiAttchinfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * AI附件Controller
 * 
 * @author yangshare
 * @date 2024-04-30
 */
@RestController
@RequestMapping("/comfyui/attchinfo")
public class AiAttchinfoController extends BaseController
{
    @Autowired
    private IAiAttchinfoService aiAttchinfoService;

    /**
     * 查询AI附件列表
     */
    @PreAuthorize("@ss.hasPermi('comfyui:attchinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiAttchinfo aiAttchinfo)
    {
        startPage();
        List<AiAttchinfo> list = aiAttchinfoService.selectAiAttchinfoList(aiAttchinfo);
        return getDataTable(list);
    }

    /**
     * 导出AI附件列表
     */
    @PreAuthorize("@ss.hasPermi('comfyui:attchinfo:export')")
    @Log(title = "AI附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiAttchinfo aiAttchinfo)
    {
        List<AiAttchinfo> list = aiAttchinfoService.selectAiAttchinfoList(aiAttchinfo);
        ExcelUtil<AiAttchinfo> util = new ExcelUtil<AiAttchinfo>(AiAttchinfo.class);
        util.exportExcel(response, list, "AI附件数据");
    }

    /**
     * 获取AI附件详细信息
     */
    @PreAuthorize("@ss.hasPermi('comfyui:attchinfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiAttchinfoService.selectAiAttchinfoById(id));
    }

    /**
     * 新增AI附件
     */
    @PreAuthorize("@ss.hasPermi('comfyui:attchinfo:add')")
    @Log(title = "AI附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiAttchinfo aiAttchinfo)
    {
        return toAjax(aiAttchinfoService.insertAiAttchinfo(aiAttchinfo));
    }

    /**
     * 修改AI附件
     */
    @PreAuthorize("@ss.hasPermi('comfyui:attchinfo:edit')")
    @Log(title = "AI附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiAttchinfo aiAttchinfo)
    {
        return toAjax(aiAttchinfoService.updateAiAttchinfo(aiAttchinfo));
    }

    /**
     * 删除AI附件
     */
    @PreAuthorize("@ss.hasPermi('comfyui:attchinfo:remove')")
    @Log(title = "AI附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiAttchinfoService.deleteAiAttchinfoByIds(ids));
    }
}
