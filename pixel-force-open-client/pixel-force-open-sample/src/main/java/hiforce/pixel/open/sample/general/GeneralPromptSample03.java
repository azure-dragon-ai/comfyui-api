package hiforce.pixel.open.sample.general;

import com.alibaba.fastjson.JSON;
import hiforce.pixel.comfy.model.node.WorkflowApi;
import hiforce.pixel.open.client.comfy.PromptResult;
import hiforce.pixel.open.client.comfy.SimpleComfyInvoker;
import hiforce.pixel.open.sample.common.BaseLocalSample;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Rocky Yu
 * @since 2024/2/22
 */
public class GeneralPromptSample03 extends BaseLocalSample {

    private String prompt;

    private String workflowJSON;

    private String workflowApiJSON;

    public BaseLocalSample init(String prompt, String workflowJSON, String workflowApiJSON) {
        this.prompt = prompt;
        this.workflowJSON = workflowJSON;
        this.workflowApiJSON = workflowApiJSON;
        return this;
    }

    @Override
    public void execute() throws Exception {

        // 格式化日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = LocalDate.now().format(formatter);

        WorkflowApi workflowApi = JSON.parseObject(workflowApiJSON, WorkflowApi.class);
        workflowApi.setNodeFieldValue(30, "text",
                prompt);

        workflowApi.setNodeFieldValue(26, "filename_prefix",
                formattedDate + File.separator + "LineArt");

        SimpleComfyInvoker invoker = new SimpleComfyInvoker("http://192.168.6.2:8188");
        PromptResult promptResult = invoker.startQueuePrompt(workflowApi, workflowJSON);

        System.out.println("General Prompt invoke result:" + JSON.toJSONString(promptResult));

        waitAndQueryTaskExecuteResult(promptResult.getPromptId(), invoker);
    }
}
