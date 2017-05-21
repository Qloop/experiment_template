package com.upc.model.service;

import com.google.gson.Gson;
import com.upc.model.config.Config;
import com.upc.model.dao.StuReportDao;
import com.upc.model.dao.TemplateDao;
import com.upc.model.dto.StuReportDto;
import com.upc.model.dto.TemplateDto;
import com.upc.model.model.StuReport;
import com.upc.model.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qloop on 2017/5/20.
 */
@Service
public class TemplateService {

    @Autowired
    private TemplateDao templateDao;
    @Autowired
    private StuReportDao stuReportDao;

    /**
     * {
     * "authorId": "123",
     * "title": "实验标题",
     * "goal": "实验目的",
     * "theory": "实验原理",
     * "equipment": "实验器材",
     * "demand": "实验要求",
     * "warning": "注意事项",
     * "data": "实验数据记录和处理",
     * "thinking": "思考与讨论"
     * "spaceCount": 20
     * }
     */
    public Map<String, Long> createTemplate(String templateContent) {
        Map<String, Long> map = new HashMap<>();
        Gson gson = new Gson();
        Template templateBean = gson.fromJson(templateContent, Template.class);
        //noinspection Duplicates
        if (templateBean == null) {
            map.put("result", (long)Config.Convert_ERROR_CODE);
            return map;
        } else {
            templateBean.setCreateDate(new Date());
            templateDao.save(templateBean);
            map.put("result", (long) Config.SUCCESS_CODE);
            map.put("templateId", templateBean.getId());
            return map;
        }
    }

    /**
     * @param id 实验模版ID
     */
    public TemplateDto getTemplate(long id) {
        Template template = templateDao.findById(id);
        if (template == null) {
            return new TemplateDto(Config.NOT_FIND + "");
        } else {
            TemplateDto templateDto = new TemplateDto(Config.SUCCESS_CODE + "", template.getGoal(), template.getData(), template.getEquipment(),
                    template.getWarning(), template.getTitle(), template.getDemand(), template.getThinking(), template.getTheory());
            return templateDto;
        }
    }

    public StuReportDto getStuReport(long templateId, long stuId) {
        StuReportDto stuReportDto = new StuReportDto();
        StuReport report = stuReportDao.findByStuIdAndTemplateId(stuId, templateId);
        if (report != null) {
            stuReportDto.setResult(Config.SUCCESS_CODE + "");
            stuReportDto.setId(report.getId());
            stuReportDto.setDataRept(report.getDataRept());
            stuReportDto.setDemandRept(report.getDemandRept());
            stuReportDto.setEquipmentRept(report.getEquipmentRept());
            stuReportDto.setGoalRept(report.getGoalRept());
            stuReportDto.setImgs(report.getImgs());
            stuReportDto.setTheoryRept(report.getTheoryRept());
            stuReportDto.setCreateDate(report.getCreateDate());
            stuReportDto.setStuClass(report.getStuClass());
            stuReportDto.setStuId(report.getStuId());
            stuReportDto.setStuName(report.getStuName());
            stuReportDto.setTemplateId(report.getTemplateId());
            stuReportDto.setThinkingRept(report.getThinkingRept());
        } else {
            stuReportDto.setResult(Config.NOT_FIND + "");
        }
        return stuReportDto;
    }
}
