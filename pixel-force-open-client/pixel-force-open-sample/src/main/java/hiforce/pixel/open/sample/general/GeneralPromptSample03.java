package hiforce.pixel.open.sample.general;

import com.alibaba.fastjson.JSON;
import hiforce.pixel.comfy.model.node.WorkflowApi;
import hiforce.pixel.open.client.comfy.PromptResult;
import hiforce.pixel.open.client.comfy.SimpleComfyInvoker;
import hiforce.pixel.open.sample.common.BaseLocalSample;

/**
 * @author Rocky Yu
 * @since 2024/2/22
 */
public class GeneralPromptSample03 extends BaseLocalSample {

    public static void main(String[] args) {
        GeneralPromptSample03 sample = new GeneralPromptSample03();
        sample.run();
    }

    @Override
    public void execute() throws Exception {
        String workflowJSON = getTextFromResource("/general/线框图/线框图.json");
        String workflowApiJSON = getTextFromResource("/general/线框图/线框图_api.json");

        WorkflowApi workflowApi = JSON.parseObject(workflowApiJSON, WorkflowApi.class);
        workflowApi.setNodeFieldValue(6, "text",
                "beautiful scenery nature glass bottle landscape, , purple galaxy bottle,");

        SimpleComfyInvoker invoker = new SimpleComfyInvoker("http://192.168.6.2:8188");
        PromptResult promptResult = invoker.startQueuePrompt(workflowApi, workflowJSON);

        System.out.println("General Prompt invoke result:" + JSON.toJSONString(promptResult));

        waitAndQueryTaskExecuteResult(promptResult.getPromptId(), invoker);
    }
}
