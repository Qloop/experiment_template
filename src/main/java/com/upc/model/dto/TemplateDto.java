package com.upc.model.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private String goalSPCount;
    private String theory;
    private String theorySPCount;
    private String equipment;
    private String equipmentSPCount;
    private String demand;
    private String demandSPCount;
    private String data;
    private String dataSPCount;
    private String warning;
    private String warningSPCount;
    private String thinking;

    @NotNull
    private String title;
    private long authorId;

    private String createDate;


    public TemplateDto() {
    }


    public TemplateDto(String result) {
        this.result = result;
    }

    public TemplateDto(String result, String goal, String goalSPCount, String theory,
                       String theorySPCount, String equipment, String equipmentSPCount, String demand, String demandSPCount,
                       String data, String dataSPCount, String warning, String warningSPCount, String thinking, String title,
                       long authorId, Date createDate) {
        this.result = result;
        this.goal = goal;
        this.goalSPCount = goalSPCount;
        this.theory = theory;
        this.theorySPCount = theorySPCount;
        this.equipment = equipment;
        this.equipmentSPCount = equipmentSPCount;
        this.demand = demand;
        this.demandSPCount = demandSPCount;
        this.data = data;
        this.dataSPCount = dataSPCount;
        this.warning = warning;
        this.warningSPCount = warningSPCount;
        this.thinking = thinking;
        this.title = title;
        this.authorId = authorId;
        this.createDate = createDate.toString();
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setGoalSPCount(String goalSPCount) {
        this.goalSPCount = goalSPCount;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public void setTheorySPCount(String theorySPCount) {
        this.theorySPCount = theorySPCount;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setEquipmentSPCount(String equipmentSPCount) {
        this.equipmentSPCount = equipmentSPCount;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public void setDemandSPCount(String demandSPCount) {
        this.demandSPCount = demandSPCount;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDataSPCount(String dataSPCount) {
        this.dataSPCount = dataSPCount;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public void setWarningSPCount(String warningSPCount) {
        this.warningSPCount = warningSPCount;
    }

    public void setThinking(String thinking) {
        this.thinking = thinking;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate.toString();
    }

    public String getResult() {
        return result;
    }

    public String getGoal() {
        return goal;
    }

    public String getGoalSPCount() {
        return goalSPCount;
    }

    public String getTheory() {
        return theory;
    }

    public String getTheorySPCount() {
        return theorySPCount;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getEquipmentSPCount() {
        return equipmentSPCount;
    }

    public String getDemand() {
        return demand;
    }

    public String getDemandSPCount() {
        return demandSPCount;
    }

    public String getData() {
        return data;
    }

    public String getDataSPCount() {
        return dataSPCount;
    }

    public String getWarning() {
        return warning;
    }

    public String getWarningSPCount() {
        return warningSPCount;
    }

    public String getThinking() {
        return thinking;
    }

    public String getTitle() {
        return title;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getCreateDate() {
        return createDate;
    }
}
