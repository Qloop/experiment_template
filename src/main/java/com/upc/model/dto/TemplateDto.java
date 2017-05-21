package com.upc.model.dto;

/**
 * Created by Qloop on 2017/5/21.
 */
public class TemplateDto {


    /**
     * result : "0"
     * goal : 实验目的
     * data : </br> <> & &alt {{}}
     * 实验数据记录和处理
     * equipment : 实验器材
     * warning : 注意事项
     * title : 实验标题
     * demand : 实验要求
     * thinking : 思考与讨论
     * theory : 实验原理
     */
    private String result;
    private String goal;
    private String data;
    private String equipment;
    private String warning;
    private String title;
    private String demand;
    private String thinking;
    private String theory;


    public TemplateDto() {
    }


    public TemplateDto(String result) {
        this.result = result;
    }

    public TemplateDto(String result, String goal, String data, String equipment, String warning,
                       String title, String demand, String thinking, String theory) {
        this.result = result;
        this.goal = goal;
        this.data = data;
        this.equipment = equipment;
        this.warning = warning;
        this.title = title;
        this.demand = demand;
        this.thinking = thinking;
        this.theory = theory;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public void setThinking(String thinking) {
        this.thinking = thinking;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public String getGoal() {
        return goal;
    }

    public String getData() {
        return data;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getWarning() {
        return warning;
    }

    public String getTitle() {
        return title;
    }

    public String getDemand() {
        return demand;
    }

    public String getThinking() {
        return thinking;
    }

    public String getTheory() {
        return theory;
    }
}
