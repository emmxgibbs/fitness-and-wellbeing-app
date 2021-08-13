package com.team4.fitness_and_wellbeing.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

//Upload Configuration Class
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    //Configure the save path to C:/fileUpload/
    @Value("${file.imagesPath}")
    private String filePath;

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();

        //Set the maximum size of the uploaded file to 1024MB
        factory.setMaxFileSize(DataSize.parse("1024MB"));
        //Set the total uploaded data size to 1024MB
        factory.setMaxRequestSize(DataSize.parse("1024MB"));
        return factory.createMultipartConfig();

    }

    public void addResourceHandlers(ResourceHandlerRegistry registry){



        if (filePath.equals("") || filePath.equals("${file.imagesPath}")){
            String filesPath = WebAppConfig.class.getClassLoader().getResource("").getPath();
            if (filesPath.indexOf(".jar") > 0){
                filesPath = filesPath.substring(0, filesPath.indexOf(".jar"));
            }else if(filesPath.indexOf("classes") > 0){
                filesPath = filesPath.substring(0, filesPath.indexOf("classes"));
            }
            filesPath = filesPath.substring(0, filesPath.lastIndexOf("/")) + "/images/";
            filePath = filesPath;
        }
        System.out.println("filePath :" + filePath + "\n");

        registry.addResourceHandler("/images/**").addResourceLocations(filePath);
        super.addResourceHandlers(registry);
    }



}
