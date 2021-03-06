package com.upc.model.controller;

import com.upc.model.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Qloop on 2017/5/19.
 */
@RestController
public class CreateController {

    @Autowired
    private TemplateService templateService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Map<String, Long> createTemplate(@RequestBody String templateJsonContent) {
        return templateService.createTemplate(templateJsonContent);
    }
}
