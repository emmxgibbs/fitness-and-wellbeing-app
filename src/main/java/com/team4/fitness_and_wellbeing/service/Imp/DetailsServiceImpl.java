package com.team4.fitness_and_wellbeing.service.Imp;

import com.team4.fitness_and_wellbeing.Dao.DetailsDao;
import com.team4.fitness_and_wellbeing.model.Details;
import com.team4.fitness_and_wellbeing.service.DetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DetailsServiceImpl implements DetailsService {
    @Resource
    private DetailsDao detailsDao;


    @Override
    public Details getDetails(String id) {
       Details details = null;
       try{
           details = detailsDao.selectById(id);
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
       return details;
    }

    @Override
    public boolean updateService(String id,
                                 String sex,
                                 String height,
                                 String weight,
                                 String level,
                                 String speciality,
                                 String qualification,
                                 String organisation) {
        try{
            detailsDao.updateById(sex,height,weight,level,speciality,qualification,id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Details details) {
        return detailsDao.update(details);
    }

}
