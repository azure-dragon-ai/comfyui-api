package hiforce.pixel.open.sample.general;

import com.alibaba.fastjson2.JSON;
import hiforce.pixel.comfy.model.node.WorkflowApi;
import hiforce.pixel.open.client.comfy.PromptResult;
import hiforce.pixel.open.client.comfy.SimpleComfyInvoker;
import hiforce.pixel.open.sample.common.BaseLocalSample;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

        CompletableFuture<List<String>> future = asyncWaitAndQueryTaskExecuteResult(promptResult.getPromptId(), invoker);
        future.thenAccept(result -> {
            System.out.println("General Prompt execute result:" + JSON.toJSONString(result));
        });

    }
}
