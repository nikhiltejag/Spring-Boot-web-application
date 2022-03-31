package com.in28minutes.springbootfirstwebapplication.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {

    private int id;
    private String user;

    @Size(min = 10, message = "Keep atleast 10 characters..")
    private String desc;
    private Date targetDate;
    private boolean isDone;

    public Todo() {
        super();
    }

    public Todo(int id, String user, String desc, Date targetDate, boolean isDone) {
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Todo [desc=" + desc + ", id=" + id + ", isDone=" + isDone + ", targetDate=" + targetDate + ", user="
                + user + "]";
    }

}
