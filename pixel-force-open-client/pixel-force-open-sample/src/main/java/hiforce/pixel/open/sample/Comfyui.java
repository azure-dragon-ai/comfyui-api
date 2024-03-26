package hiforce.pixel.open.sample;

import hiforce.pixel.open.sample.general.GeneralPromptSample03;

public class Comfyui {
    public static void main(String[] args) {
        GeneralPromptSample03 sample = new GeneralPromptSample03();
        String prompt = "rabbit";
        String workflowJSON = sample.getTextFromResource("/general/线框图/线框图.json");
        String workflowApiJSON = sample.getTextFromResource("/general/线框图/线框图_api.json");
        sample.init(prompt, workflowJSON, workflowApiJSON).run();
    }
}