package com.upc.model.service;

import com.google.gson.Gson;
import com.upc.model.config.Config;
import com.upc.model.dao.TemplateDao;
import com.upc.model.dto.TemplateDto;
import com.upc.model.model.Template;
import com.upc.model.utils.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Qloop on 2017/5/20.
 */
@Service
public class TemplateService {

    @Autowired
    private TemplateDao templateDao;

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
     * }
     */
    public String createTemplate(String templateContent) {
        Gson gson = new Gson();
        Template templateBean = gson.fromJson(templateContent, Template.class);
        //noinspection Duplicates
        if (templateBean == null) {
            return Config.Convert_ERROR_CODE + "";
        } else {
            templateBean.setCreateDate(new Date());
            templateDao.save(templateBean);
            return Config.SUCCESS_CODE + "";
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
}
