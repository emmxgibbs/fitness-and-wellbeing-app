package com.team4.fitness_and_wellbeing.Controller;

import com.alibaba.fastjson.JSON;

import com.team4.fitness_and_wellbeing.utils.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
public class ImageUploadController {


    @RequestMapping("/imageUpload")
    public Map imageUpload(@RequestParam("fileName") MultipartFile file){
        String result_msg="";

        Map<String,Object> root=new HashMap<String, Object>();

        if (file.getSize() / 1000 > 100){
            result_msg="Picture size cannot exceed 100KB";
        }
        else{
            String fileType = file.getContentType();
            if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {

               // C:\Projects\IdeaProjects\team4_fitness_and_wellbeing_app\src\main\resources\static\ExerciseImg
                final String localPath="C:\\Projects\\IdeaProjects\\team4_fitness_and_wellbeing_app\\src\\main\\resources\\static\\ExerciseImg";

                String fileName = file.getOriginalFilename();
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //fileName = UUID.randomUUID()+suffixName;
                if (FileUtils.upload(file, localPath, fileName)) {

                    String relativePath= "static/img/ " +fileName;
                    root.put("relativePath",relativePath);
                    result_msg="Picture uploaded successfully";
                }
                else{
                    result_msg="Image upload failed";
                }
            }
            else{
                result_msg="Incorrect image format";
            }
        }

        root.put("result_msg",result_msg);

//        JSON.toJSONString(root,SerializerFeature.DisableCircularReferenceDetect);
        String root_json=JSON.toJSONString(root);
        System.out.println(root_json);
        return root;
    }

    @RequestMapping("/multipleImageUpload")
    public List multipleImageUpload(@RequestParam("uploadFiles") MultipartFile[] files){
        System.out.println("Number of pictures uploaded:"+files.length);

        List<Map<String,Object>> root=new ArrayList<Map<String,Object>>();

        for (MultipartFile file : files) {

            Map<String,Object> result=new HashMap<String, Object>();
            String result_msg="";
            if (file.getSize() / 1000 > 100){
                result_msg="Picture size cannot exceed 100KB";
            }
            else{

                String fileType = file.getContentType();
                if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {

                    final String localPath="C:\\Projects\\IdeaProjects\\team4_fitness_and_wellbeing_app\\src\\main\\resources\\static\\ExerciseImg";

                    String fileName = file.getOriginalFilename();

                    String suffixName = fileName.substring(fileName.lastIndexOf("."));

                    //fileName = UUID.randomUUID()+suffixName;
                    if (FileUtils.upload(file, localPath, fileName)) {

                        String relativePath= "static/img/" +fileName;
                        result.put("relativePath",relativePath);
                        result_msg="Picture uploaded successfully";
                    }
                    else{
                        result_msg="Image upload failed";
                    }
                }
                else{
                    result_msg="Incorrect image format";
                }
            }
            result.put("result_msg",result_msg);
            root.add(result);
        }
        String root_json=JSON.toJSONString(root);
        System.out.println(root_json);
        return root;
    }

}
