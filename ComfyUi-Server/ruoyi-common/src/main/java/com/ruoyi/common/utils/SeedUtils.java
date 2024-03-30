package com.ruoyi.common.utils;

import java.util.Random;

/**
 * 作者： yangc
 * 创建时间：2024/3/29 18:38
 * 版本： 1.0
 */
public class SeedUtils {
    public static long seed() {
        long seed = System.currentTimeMillis();

        // 初始化随机数生成器
        Random random = new Random(seed);

        // 生成一个随机长整数作为AI绘画的随机种子
        long aiPaintingSeed = Math.abs(random.nextLong());

        // 输出生成的随机种子
        //System.out.println("Generated AI painting random seed: " + aiPaintingSeed);

        return aiPaintingSeed;

    }
}
