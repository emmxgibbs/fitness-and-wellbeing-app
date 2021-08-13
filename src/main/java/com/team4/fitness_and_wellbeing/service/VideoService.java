package com.team4.fitness_and_wellbeing.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.team4.fitness_and_wellbeing.model.Video;

import java.util.List;
import java.util.Set;

public interface VideoService extends IService<Video> {


    public int insertUrl(String name, String way, String url, String description, String title);

    public List<Video> selectVideo();

    public List<Video> getVideos(Set<Integer> videoIds);

}
