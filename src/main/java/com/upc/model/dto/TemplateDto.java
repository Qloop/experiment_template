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
    private int goalSPCount;
    private String theory;
    private int theorySPCount;
    private String equipment;
    private int equipmentSPCount;
    private String demand;
    private int demandSPCount;
    private String data;
    private int dataSPCount;
    private String warning;
    private int warningSPCount;
    private String thinking;

    @NotNull
    private String title;
    private long authorId;

    private Date createDate;


    public TemplateDto() {
    }


    public TemplateDto(String result) {
        this.result = result;
    }

    public TemplateDto(String result, String goal, int goalSPCount, String theory,
                       int theorySPCount, String equipment, int equipmentSPCount, String demand, int demandSPCount,
                       String data, int dataSPCount, String warning, int warningSPCount, String thinking, String title,
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
        this.createDate = createDate;
    }

    public void setGoalSPCount(int goalSPCount) {
        this.goalSPCount = goalSPCount;
    }

    public void setTheorySPCount(int theorySPCount) {
        this.theorySPCount = theorySPCount;
    }

    public void setEquipmentSPCount(int equipmentSPCount) {
        this.equipmentSPCount = equipmentSPCount;
    }

    public void setDemandSPCount(int demandSPCount) {
        this.demandSPCount = demandSPCount;
    }

    public void setDataSPCount(int dataSPCount) {
        this.dataSPCount = dataSPCount;
    }

    public void setWarningSPCount(int warningSPCount) {
        this.warningSPCount = warningSPCount;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getGoalSPCount() {
        return goalSPCount;
    }

    public int getTheorySPCount() {
        return theorySPCount;
    }

    public int getEquipmentSPCount() {
        return equipmentSPCount;
    }

    public int getDemandSPCount() {
        return demandSPCount;
    }

    public int getDataSPCount() {
        return dataSPCount;
    }

    public int getWarningSPCount() {
        return warningSPCount;
    }

    public long getAuthorId() {
        return authorId;
    }

    public Date getCreateDate() {
        return createDate;
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
