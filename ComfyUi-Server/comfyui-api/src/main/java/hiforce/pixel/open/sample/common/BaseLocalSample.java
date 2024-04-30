package hiforce.pixel.open.sample.common;

import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;
import hiforce.pixel.open.client.comfy.ImageOutputType;
import hiforce.pixel.open.client.comfy.SimpleComfyInvoker;
import hiforce.pixel.open.client.comfy.TaskDetailResult;
import hiforce.pixel.open.client.comfy.TaskQueueResult;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author Rocky Yu
 * @since 2024/2/22
 */
public abstract class BaseLocalSample extends BaseSample {

    /**
     * 同步执行方法
     *
     * @param promptId
     * @param invoker
     * @throws Exception
     */
    public void waitAndQueryTaskExecuteResult(String promptId, SimpleComfyInvoker invoker) throws Exception {

        Timer timer = new Timer();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                TaskQueueResult queueResult = invoker.doQueryTaskQueueInfo(Lists.newArrayList(promptId));
                if (queueResult.isRunning()) {
                    System.out.println("Task task running:" + JSON.toJSONString(queueResult));
                }
                else {
                    List<TaskDetailResult> result = invoker.doQueryTaskDetails(Lists.newArrayList(promptId));
                    List<String> imageUrls = result.stream().flatMap(p -> p.getOutputs().stream())
                            .flatMap(p -> p.getImages().stream())
                            .filter(p -> p.getType() == ImageOutputType.output)
                            .map(p -> String.format("%s/view?filename=%s&subfolder=%s&type=output", invoker.getHost(),
                                    p.getFilename(), StringUtils.isEmpty(p.getSubfolder()) ? "" : p.getSubfolder()))
                            .collect(Collectors.toList());
                    System.out.println("Task finished:" + JSON.toJSONString(imageUrls));
                    countDownLatch.countDown();
                    timer.cancel();
                }
            }
        }, 1000L, 1000L);
        countDownLatch.await();
    }

    /**
     * 异步执行方法
     *
     * @param promptId
     * @param invoker
     * @return
     */
    public CompletableFuture<List<String>> asyncWaitAndQueryTaskExecuteResult(String promptId, SimpleComfyInvoker invoker) {
        CompletableFuture<List<String>> future = new CompletableFuture<>();
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    // 查询任务队列状态
                    TaskQueueResult queueResult = invoker.doQueryTaskQueueInfo(Lists.newArrayList(promptId));
                    if (queueResult.isRunning()) {
                        // 如果任务正在运行，打印任务状态信息
                        System.out.println("Task task running:" + JSON.toJSONString(queueResult));
                    }
                    else {
                        // 查询任务详情
                        List<TaskDetailResult> result = invoker.doQueryTaskDetails(Lists.newArrayList(promptId));
                        // 处理任务输出中的图片链接
                        List<String> imageUrls = result.stream().flatMap(p -> p.getOutputs().stream())
                                .flatMap(p -> p.getImages().stream())
                                .filter(p -> p.getType() == ImageOutputType.output)
                                .map(p -> String.format("%s/view?filename=%s&subfolder=%s&type=output",
                                        invoker.getHost(), p.getFilename(),
                                        StringUtils.isEmpty(p.getSubfolder()) ? "" : p.getSubfolder()))
                                .collect(Collectors.toList());
                        // 打印任务完成信息及图片链接列表
                        System.out.println("Task finished:" + JSON.toJSONString(imageUrls));
                        // 任务完成，设置CompletableFuture的结果
                        future.complete(imageUrls);
                        // 取消计时器
                        timer.cancel();
                    }
                }
                catch (Exception e) {
                    future.completeExceptionally(e);
                    // 异常处理
                    e.printStackTrace();
                }
                finally {
                    // 关闭ExecutorService
                    executor.shutdown();
                }
            }
        }, 1000L, 1000L);

        return future;
    }

    public final void run() {
        try {
            execute();
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
