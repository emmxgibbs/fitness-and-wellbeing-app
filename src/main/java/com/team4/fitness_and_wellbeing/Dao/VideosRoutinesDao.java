package com.team4.fitness_and_wellbeing.Dao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "videos_routines")
public class VideosRoutinesDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "routine_id")
    private int routineId;

    @Column(name = "video_id")
    private int videoId;

    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routineId) {
        this.routineId = routineId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}