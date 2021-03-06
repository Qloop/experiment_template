package com.upc.model.controller;

import com.upc.model.dto.ReportListDto;
import com.upc.model.dto.StuReportDto;
import com.upc.model.dto.TemplateDto;
import com.upc.model.dto.TemplateListDto;
import com.upc.model.service.ReportService;
import com.upc.model.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Qloop on 2017/5/21.
 */
@RestController
public class DisplayController {

    @Autowired
    private TemplateService templateService;
    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public TemplateDto displayTemplate(long id) {
        return templateService.getTemplate(id);
    }

    @RequestMapping(value = "/get_stu_info", method = RequestMethod.GET)
    public ReportListDto getStuInfoByTemplateId(long templateId) {
        return reportService.getAllReportByTemplateId(templateId);
    }

    @RequestMapping(value = "/teacher_watch", method = RequestMethod.GET)
    public StuReportDto displayStuReport(long templateId, long stuId) {
        return templateService.getStuReport(templateId, stuId);
    }

    @RequestMapping(value = "/template_list", method = RequestMethod.GET)
    public TemplateListDto getTemplateList(long author) {
        return templateService.getAllTemplateByAuthorId(author);
    }

}
