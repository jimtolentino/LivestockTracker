package com.example.carlo.livestocktracker.objects;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Carlo on 2/12/2017.
 */

public class Livestock implements Serializable {

    private int id;
    private String num;
    private String type;
    private String breed;
    private String houseNum;
    private String weight;
    private int photo;
    private LivestockFile displayPicture;
    private List<LivestockFile> photos;


    public Livestock(){

    }

    public Livestock(int id, String num, int photo, String type, String breed, String houseNum, String weight) {
        this.id = id;
        this.num = num;
        this.photo = photo;
        this.type = type;
        this.breed = breed;
        this.houseNum = houseNum;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}