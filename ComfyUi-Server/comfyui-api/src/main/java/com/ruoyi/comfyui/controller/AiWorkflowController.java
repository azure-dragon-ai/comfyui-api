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
import com.ruoyi.comfyui.domain.AiWorkflow;
import com.ruoyi.comfyui.service.IAiWorkflowService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * AI生成工作流Controller
 * 
 * @author yangshare
 * @date 2024-04-30
 */
@RestController
@RequestMapping("/comfyui/workflow")
public class AiWorkflowController extends BaseController
{
    @Autowired
    private IAiWorkflowService aiWorkflowService;

    /**
     * 查询AI生成工作流列表
     */
    @PreAuthorize("@ss.hasPermi('comfyui:workflow:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiWorkflow aiWorkflow)
    {
        startPage();
        List<AiWorkflow> list = aiWorkflowService.selectAiWorkflowList(aiWorkflow);
        return getDataTable(list);
    }

    /**
     * 导出AI生成工作流列表
     */
    @PreAuthorize("@ss.hasPermi('comfyui:workflow:export')")
    @Log(title = "AI生成工作流", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiWorkflow aiWorkflow)
    {
        List<AiWorkflow> list = aiWorkflowService.selectAiWorkflowList(aiWorkflow);
        ExcelUtil<AiWorkflow> util = new ExcelUtil<AiWorkflow>(AiWorkflow.class);
        util.exportExcel(response, list, "AI生成工作流数据");
    }

    /**
     * 获取AI生成工作流详细信息
     */
    @PreAuthorize("@ss.hasPermi('comfyui:workflow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiWorkflowService.selectAiWorkflowById(id));
    }

    /**
     * 新增AI生成工作流
     */
    @PreAuthorize("@ss.hasPermi('comfyui:workflow:add')")
    @Log(title = "AI生成工作流", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiWorkflow aiWorkflow)
    {
        return toAjax(aiWorkflowService.insertAiWorkflow(aiWorkflow));
    }

    /**
     * 修改AI生成工作流
     */
    @PreAuthorize("@ss.hasPermi('comfyui:workflow:edit')")
    @Log(title = "AI生成工作流", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiWorkflow aiWorkflow)
    {
        return toAjax(aiWorkflowService.updateAiWorkflow(aiWorkflow));
    }

    /**
     * 删除AI生成工作流
     */
    @PreAuthorize("@ss.hasPermi('comfyui:workflow:remove')")
    @Log(title = "AI生成工作流", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiWorkflowService.deleteAiWorkflowByIds(ids));
    }
}
