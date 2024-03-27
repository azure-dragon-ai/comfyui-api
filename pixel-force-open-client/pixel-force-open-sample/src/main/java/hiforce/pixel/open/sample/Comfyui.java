package hiforce.pixel.open.sample;

import com.alibaba.fastjson.JSON;
import hiforce.pixel.comfy.model.node.WorkflowApi;
import hiforce.pixel.open.sample.general.GeneralPromptSample03;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Comfyui {

    // 格式化日期
    static String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    public static void main(String[] args) {
        GeneralPromptSample03 sample = new GeneralPromptSample03();
        /*String prompt = "car";
        String workflowJSON = sample.getTextFromResource("/general/线框图/线框图.json");
        String workflowApiJSON = sample.getTextFromResource("/general/线框图/线框图_api.json");
        sample.init(prompt, workflowJSON, workflowApiJSON).run();*/


        String prompt = "golden hour in beijing, dreamy chinese town,ground_vehicle, tree, motor_vehicle, scenery, motorcycle, east_asian_architecture, lantern, road, outdoors, architecture, paper_lantern, street, building, autumn_leaves, bicycle, autumn, sky, people";
        String workflowJSON = sample.getTextFromResource("/general/花园/花园.json");
        String workflowApiJSON = sample.getTextFromResource("/general/花园/花园_api.json");
        WorkflowApi workflowApi = JSON.parseObject(workflowApiJSON, WorkflowApi.class);
        workflowApi.setNodeFieldValue(6, "text", prompt);
        workflowApi.setNodeFieldValue(9, "filename_prefix", formattedDate + File.separator + "LineArt");
        sample.init(workflowJSON, workflowApi).run();
    }
}