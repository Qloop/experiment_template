package com.upc.model.dto;


import java.util.Date;
import java.util.List;

/**
 * Created by Qloop on 2017/5/23.
 */
public class TemplateListDto {

    private List<TemplateBean> templateBeanList;
    private String result;

    public void setTemplateBeanList(List<TemplateBean> templateBeanList) {
        this.templateBeanList = templateBeanList;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<TemplateBean> getTemplateBeanList() {
        return templateBeanList;
    }

    public String getResult() {
        return result;
    }

    public static class TemplateBean {
        private long templateId;
        private String title;
        private String createDate;

        public void setTemplateId(long templateId) {
            this.templateId = templateId;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public long getTemplateId() {
            return templateId;
        }

        public String getTitle() {
            return title;
        }

        public String getCreateDate() {
            return createDate;
        }
    }

}
