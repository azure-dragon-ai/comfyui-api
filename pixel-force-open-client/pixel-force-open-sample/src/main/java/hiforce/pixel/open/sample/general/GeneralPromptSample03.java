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

    private String workflowJSON;

    private WorkflowApi workflowApi;
    ;

    public BaseLocalSample init(String workflowJSON, WorkflowApi workflowApi) {
        this.workflowJSON = workflowJSON;
        this.workflowApi = workflowApi;
        return this;
    }

    @Override
    public void execute() throws Exception {

        SimpleComfyInvoker invoker = new SimpleComfyInvoker("http://192.168.6.2:8188");

        PromptResult promptResult = invoker.startQueuePrompt(workflowApi, workflowJSON);

        System.out.println("General Prompt invoke result:" + JSON.toJSONString(promptResult));

        waitAndQueryTaskExecuteResult(promptResult.getPromptId(), invoker);
    }
}
