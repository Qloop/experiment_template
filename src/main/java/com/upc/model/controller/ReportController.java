package com.upc.model.controller;

import com.upc.model.dto.ImageUrlsDto;
import com.upc.model.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Qloop on 2017/5/21.
 */

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/submit_report", method = RequestMethod.POST)
    public Map<String, Long> submitReport(@RequestBody String reportJsonContent) {
        return reportService.save(reportJsonContent);
    }

    @RequestMapping(value = "/submit_imgs")
    public ImageUrlsDto postImgs(@RequestParam("imgs") MultipartFile[] files, long templateId) {
        return reportService.saveImgs(files, templateId);
    }

}
