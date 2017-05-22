package com.upc.model.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Qloop on 17/5/19.
 */
@Entity
@Table(name = "t_template")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String goal;
    private String goalSPCount = "0";
    private String theory;
    private String theorySPCount = "0";
    private String equipment;
    private String equipmentSPCount = "0";
    private String demand;
    private String demandSPCount = "0";
    private String data;
    private String dataSPCount = "0";
    private String warning;
    private String warningSPCount = "0";
    private String thinking;

    @NotNull
    private String title;
    private long authorId;

    private Date createDate;

    public Template() {
    }


    public Template(String goal, String theory, String equipment, String demand, String data, String warning,
                    String thinking, String title, long authorId, Date createDate) {
        this.goal = goal;
        this.theory = theory;
        this.equipment = equipment;
        this.demand = demand;
        this.data = data;
        this.warning = warning;
        this.thinking = thinking;
        this.title = title;
        this.authorId = authorId;
        this.createDate = createDate;
    }

    public void setId(long id) {
        this.id = id;
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
        this.createDate = createDate;
    }

    public long getId() {
        return id;
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

    public Date getCreateDate() {
        return createDate;
    }
}
