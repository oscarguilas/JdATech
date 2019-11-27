package com.example.jdatech.model;

import java.util.ArrayList;

public class student {

    private String userid, name, classes;
    private ArrayList<String> settings, classgroup;

    public student(String userid, String name, String classes, ArrayList<String> settings, ArrayList<String> classgroup) {
        this.userid = userid;
        this.name = name;
        this.classes = classes;
        this.settings = settings;
        this.classgroup = classgroup;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public ArrayList<String> getSettings() {
        return settings;
    }

    public void setSettings(ArrayList<String> settings) {
        this.settings = settings;
    }

    public ArrayList<String> getClassgroup() {
        return classgroup;
    }

    public void setClassgroup(ArrayList<String> classgroup) {
        this.classgroup = classgroup;
    }
}
