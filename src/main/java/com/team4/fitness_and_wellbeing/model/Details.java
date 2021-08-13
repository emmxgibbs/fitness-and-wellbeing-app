package com.team4.fitness_and_wellbeing.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Details implements Serializable {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String sex;
    private String height;
    private String weight;
    private String level;
    private String speciality;
    private String qualification;
    private String organisation;

    public Details(){

    }

    public Details(String id, String sex, String height, String weight, String level, String speciality, String qualification, String organisation) {
        this.id = id;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.level = level;
        this.speciality = speciality;
        this.qualification = qualification;
        this.organisation = organisation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }


    @Override
    public String toString() {
        return "Details{" +
                "id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", level='" + level + '\'' +
                ", speciality='" + speciality + '\'' +
                ", qualification='" + qualification + '\'' +
                ", organisation='" + organisation + '\'' +
                '}';
    }
}
