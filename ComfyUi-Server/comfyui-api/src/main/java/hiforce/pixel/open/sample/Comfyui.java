package hiforce.pixel.open.sample;

import com.alibaba.fastjson2.JSON;
import hiforce.pixel.comfy.model.node.WorkflowApi;
import hiforce.pixel.open.sample.general.GeneralPromptSample03;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Comfyui {

    // 格式化日期
    static String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    public static void main(String[] args) {
        GeneralPromptSample03 sample = new GeneralPromptSample03();
        /*String prompt = "car";
        String workflowJSON = sample.getTextFromResource("/general/线框图/线框图.json");
        String workflowApiJSON = sample.getTextFromResource("/general/线框图/线框图_api.json");
        sample.init(prompt, workflowJSON, workflowApiJSON).run();*/


        String prompt = "Chinese style animals, Chinese style pets, Chinese style wildlife, Chinese style birds, Chinese style cats, Chinese style dogs, Chinese style dragons, Chinese style tigers, Chinese style pandas, Chinese style horses";
        String workflowJSON = sample.getTextFromResource("/general/花园/花园.json");
        String workflowApiJSON = sample.getTextFromResource("/general/花园/花园_api.json");
        WorkflowApi workflowApi = JSON.parseObject(workflowApiJSON, WorkflowApi.class);

        for (int i = 0; i < 4; i++) {
            workflowApi.setNodeFieldValue(3, "seed", seed());
            workflowApi.setNodeFieldValue(6, "text", prompt);
            workflowApi.setNodeFieldValue(9, "filename_prefix", formattedDate + File.separator + "LineArt");
            sample.init(workflowJSON, workflowApi).run();
        }
    }

    private static long seed() {
        long seed = System.currentTimeMillis();

        // 初始化随机数生成器
        Random random = new Random(seed);

        // 生成一个随机长整数作为AI绘画的随机种子
        long aiPaintingSeed = Math.abs(random.nextLong());

        // 输出生成的随机种子
        System.out.println("Generated AI painting random seed: " + aiPaintingSeed);

        return aiPaintingSeed;

    }
}