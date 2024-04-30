package com.ruoyi.comfyui.mapper;

import java.util.List;
import com.ruoyi.comfyui.domain.AiAttchinfo;

/**
 * AI附件Mapper接口
 * 
 * @author yangshare
 * @date 2024-04-30
 */
public interface AiAttchinfoMapper 
{
    /**
     * 查询AI附件
     * 
     * @param id AI附件主键
     * @return AI附件
     */
    public AiAttchinfo selectAiAttchinfoById(Long id);

    /**
     * 查询AI附件列表
     * 
     * @param aiAttchinfo AI附件
     * @return AI附件集合
     */
    public List<AiAttchinfo> selectAiAttchinfoList(AiAttchinfo aiAttchinfo);

    /**
     * 新增AI附件
     * 
     * @param aiAttchinfo AI附件
     * @return 结果
     */
    public int insertAiAttchinfo(AiAttchinfo aiAttchinfo);

    /**
     * 修改AI附件
     * 
     * @param aiAttchinfo AI附件
     * @return 结果
     */
    public int updateAiAttchinfo(AiAttchinfo aiAttchinfo);

    /**
     * 删除AI附件
     * 
     * @param id AI附件主键
     * @return 结果
     */
    public int deleteAiAttchinfoById(Long id);

    /**
     * 批量删除AI附件
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiAttchinfoByIds(Long[] ids);
}
