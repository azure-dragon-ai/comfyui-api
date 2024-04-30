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
import com.ruoyi.comfyui.domain.AiGenTask;
import com.ruoyi.comfyui.service.IAiGenTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * AI生产任务Controller
 * 
 * @author yangshare
 * @date 2024-04-30
 */
@RestController
@RequestMapping("/comfyui/task")
public class AiGenTaskController extends BaseController
{
    @Autowired
    private IAiGenTaskService aiGenTaskService;

    /**
     * 查询AI生产任务列表
     */
    @PreAuthorize("@ss.hasPermi('comfyui:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(AiGenTask aiGenTask)
    {
        startPage();
        List<AiGenTask> list = aiGenTaskService.selectAiGenTaskList(aiGenTask);
        return getDataTable(list);
    }

    /**
     * 导出AI生产任务列表
     */
    @PreAuthorize("@ss.hasPermi('comfyui:task:export')")
    @Log(title = "AI生产任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AiGenTask aiGenTask)
    {
        List<AiGenTask> list = aiGenTaskService.selectAiGenTaskList(aiGenTask);
        ExcelUtil<AiGenTask> util = new ExcelUtil<AiGenTask>(AiGenTask.class);
        util.exportExcel(response, list, "AI生产任务数据");
    }

    /**
     * 获取AI生产任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('comfyui:task:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aiGenTaskService.selectAiGenTaskById(id));
    }

    /**
     * 新增AI生产任务
     */
    @PreAuthorize("@ss.hasPermi('comfyui:task:add')")
    @Log(title = "AI生产任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AiGenTask aiGenTask)
    {
        return toAjax(aiGenTaskService.insertAiGenTask(aiGenTask));
    }

    /**
     * 修改AI生产任务
     */
    @PreAuthorize("@ss.hasPermi('comfyui:task:edit')")
    @Log(title = "AI生产任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AiGenTask aiGenTask)
    {
        return toAjax(aiGenTaskService.updateAiGenTask(aiGenTask));
    }

    /**
     * 删除AI生产任务
     */
    @PreAuthorize("@ss.hasPermi('comfyui:task:remove')")
    @Log(title = "AI生产任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aiGenTaskService.deleteAiGenTaskByIds(ids));
    }
}
