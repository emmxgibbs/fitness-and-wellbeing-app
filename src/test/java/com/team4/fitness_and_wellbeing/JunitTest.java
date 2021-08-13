package com.team4.fitness_and_wellbeing;

import com.team4.fitness_and_wellbeing.mapper.VideoMapper;
import com.team4.fitness_and_wellbeing.model.Video;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@DisplayName("Test")
@SpringBootTest
public class JunitTest {

    @Autowired
    VideoMapper videoMapper;

    @BeforeEach
    void testBeforeEach(){
        System.out.println("Start to test");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("Finish");
    }


    //Test insert file
    @Test
    public void testInsert(){
        Video video = new Video();
        video.setTitle("exercise");
        video.setDescription("once a week");
        video.setUrl("http://localhost:8080/images/file");
        video.setWay("C:/fileupload");

        int result = this.videoMapper.insertUrl(
                "exercise",
                "C:/fileupload",
                "http://localhost:8080/images/file",
                "once a week",
                "exercise");
        System.out.println("result = " + result);
        System.out.println(video.getId());
        Assertions.assertSame("exercise,C:/fileupload,http://localhost:8080/images/file,once a week,exercise",result);
    }



    //Test delete file
    @Test
    void testDelete(){
        int row = videoMapper.deleteById(1);
        System.out.println(row);
    }


}
