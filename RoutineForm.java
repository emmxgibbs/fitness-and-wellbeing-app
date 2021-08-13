package com.team4.fitness_and_wellbeing.model;

public class RoutineForm {
    private String name;
    private Integer[] videoIdList;

    public RoutineForm(String name, Integer[] videoIdList) {
        this.name = name;
        this.videoIdList = videoIdList;
    }

    public String getName() {
        return name;
    }

    public Integer[] getVideoIdList() {
        return videoIdList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVideoIdList(Integer[] videoIdList) {
        this.videoIdList = videoIdList;
    }
}
