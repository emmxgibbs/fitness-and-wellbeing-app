package com.team4.fitness_and_wellbeing.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team4.fitness_and_wellbeing.model.Video;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Mapper
@Component
public interface VideoMapper extends BaseMapper<Video> {

    //Insert
    @Insert({"insert into video (name, way, url,description,title) values(#{name},#{way},#{url},#{description},#{title})"})
    public int insertUrl(@Param("name")String name,
                         @Param("way")String way,
                         @Param("url")String url,
                         @Param("description")String description,
                         @Param("title")String title);

    //Query
    @Select("select * from video")
    public List<Video> selectVideo();

    @Query(value = "SELECT * FROM video WHERE video.id IN :videoIds", nativeQuery = true)
    public List<Video> getVideos(@Param("videoIds") Set<Integer> videoIds);


    //Update
//    @Update("update video set" +
//            "description = #{description}," +
//            "title = #{title}" +
//            "where id=#{id}" )
//    public int update(Video video);


    //Search for update
//    @Select("select title,description from video where id= #{id}")
//    public Video getFile(long id);

}
