package com.team4.fitness_and_wellbeing.service.Imp;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team4.fitness_and_wellbeing.mapper.VideoMapper;
import com.team4.fitness_and_wellbeing.model.Video;
import com.team4.fitness_and_wellbeing.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    VideoMapper videoMapper;

    @Override
    public int insertUrl(String name, String way, String url, String description, String title) {
        int result = videoMapper.insertUrl(name, way, url, description, title);
        System.out.println("Result:" + result);
        return result;
    }

    @Override
    public List<Video> selectVideo() {
        List<Video> video = videoMapper.selectVideo();
        return video;
    }

    @Override
    public List<Video> getVideos(Set<Integer> videoIds) {
        return videoMapper.getVideos(videoIds);
    }
}
