package com.team4.fitness_and_wellbeing.Dao;


import com.team4.fitness_and_wellbeing.model.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Mapper
@Component
public interface VideoDao {

    //Insert
    @Insert({"insert into video (name, way, url) values(#{name},#{way},#{url})"})
    public int insertUrl(@Param("name")String name, @Param("way")String way, @Param("url")String url);

    //Query
    @Select("select * from video")
    public List<Video> selectVideo();

    @Query(value = "SELECT * FROM video WHERE video.id IN :videoIds", nativeQuery = true)
    public List<Video> getVideos(@Param("videoIds") Set<Integer> videoIds);
}
