package com.ruoyi.web.controller.comfyui;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SeedUtils;
import com.ruoyi.system.service.ISysConfigService;
import hiforce.pixel.comfy.model.node.WorkflowApi;
import hiforce.pixel.open.sample.general.GeneralPromptSample03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * comfyui 对外相关接口
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/comfyui/app")
public class ComfyuiController extends BaseController {
    @Autowired
    private ISysConfigService configService;

    @PostMapping("/prompt")
    public AjaxResult prompt(@RequestBody JSONObject prompt) {
        // 在这里处理 prompt 参数
        System.out.println(prompt);

        GeneralPromptSample03 sample = new GeneralPromptSample03();
        /*String prompt = "car";
        String workflowJSON = sample.getTextFromResource("/general/线框图/线框图.json");
        String workflowApiJSON = sample.getTextFromResource("/general/线框图/线框图_api.json");
        sample.init(prompt, workflowJSON, workflowApiJSON).run();*/


        String workflowJSON = sample.getTextFromResource("/general/花园/花园.json");
        String workflowApiJSON = sample.getTextFromResource("/general/花园/花园_api.json");
        WorkflowApi workflowApi = JSON.parseObject(workflowApiJSON, WorkflowApi.class);

        workflowApi.setNodeFieldValue(3, "seed", Long.toString(SeedUtils.seed()));
        workflowApi.setNodeFieldValue(6, "text", prompt.getString("prompt"));
        workflowApi.setNodeFieldValue(9, "filename_prefix", DateUtils.getDate() + File.separator + "LineArt");
        sample.init(workflowJSON, workflowApi).run();

        return success("生图任务执行成功！");
    }

}
