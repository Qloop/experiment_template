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
    private String theory;
    private String equipment;
    private String demand;
    private String data;
    private String warning;
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

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setWarning(String warning) {
        this.warning = warning;
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

    public String getTheory() {
        return theory;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getDemand() {
        return demand;
    }

    public String getData() {
        return data;
    }

    public String getWarning() {
        return warning;
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
