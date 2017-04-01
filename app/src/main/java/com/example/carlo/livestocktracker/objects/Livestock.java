package com.example.carlo.livestocktracker.objects;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * Created by Carlo on 2/12/2017.
 */

@DatabaseTable(tableName = "livestock_details_tbl")

public class Livestock implements Serializable {

    @DatabaseField(id = true, generatedId = false) public int id;
    @DatabaseField public String name;
    @DatabaseField public String tag;
    @DatabaseField public String weight;
    @DatabaseField public Date dateOfBirth;
    @DatabaseField public String type;
    @DatabaseField public String breed;
    @DatabaseField public String offSpringCounter;
    @DatabaseField public String status;
    @DatabaseField public String houseNumber;
    @DatabaseField public String qrCode;
//    private List<LivestockComments> comments;
//    private List<LivestockMedHist> medicalHistories;
    private LivestockFile displayPicture;
//    private List<LivestockFile> photos;
//    private LivestockFarm farm;
//    private LivestockInvestor investor;
//    private LivestockInvestment investment;
    @DatabaseField public Date created_at;
//    private LivestockCreator creator;

    public Livestock(){

    }

//    public Livestock(String name,
//                     String tag,
//                     Number weight,
//                     Date dateOfBirth,
//                     String type,
//                     String breed,
//                     Number offSpringCounter,
//                     String status,
//                     String houseNumber,
//                     String qrCode,
//                     List<LivestockComments> comments,
//                     List<LivestockMedHist> medicalHistories,
//                     LivestockFile displayPicture,
//                     List<LivestockFile> photos,
//                     LivestockFarm farm,
//                     LivestockInvestor investor,
//                     LivestockInvestment investment,
//                     Date created_at,
//                     LivestockCreator creator) {
//
//        this.name = name;
//        this.tag = tag;
//        this.weight = weight;
//        this.dateOfBirth = dateOfBirth;
//        this.type = type;
//        this.breed = breed;
//        this.offSpringCounter = offSpringCounter;
//        this.status = status;
//        this.houseNumber = houseNumber;
//        this.qrCode = qrCode;
//        this.comments = comments;
//        this.medicalHistories = medicalHistories;
//        this.displayPicture = displayPicture;
//        this.photos = photos;
//        this.farm = farm;
//        this.investor = investor;
//        this.investment = investment;
//        this.created_at = created_at;
//        this.creator = creator;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOffSpringCounter() {
        return offSpringCounter;
    }

    public void setOffSpringCounter(String offSpringCounter) {
        this.offSpringCounter = offSpringCounter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

//    public List<LivestockComments> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<LivestockComments> comments) {
//        this.comments = comments;
//    }
//
//    public List<LivestockMedHist> getMedicalHistories() {
//        return medicalHistories;
//    }
//
//    public void setMedicalHistories(List<LivestockMedHist> medicalHistories) {
//        this.medicalHistories = medicalHistories;
//    }
//
    public LivestockFile getDisplayPicture() {
        return displayPicture;
    }

    public void setDisplayPicture(LivestockFile displayPicture) {
        this.displayPicture = displayPicture;
    }
//
//    public List<LivestockFile> getPhotos() {
//        return photos;
//    }
//
//    public void setPhotos(List<LivestockFile> photos) {
//        this.photos = photos;
//    }
//
//    public LivestockFarm getFarm() {
//        return farm;
//    }
//
//    public void setFarm(LivestockFarm farm) {
//        this.farm = farm;
//    }
//
//    public LivestockInvestor getInvestor() {
//        return investor;
//    }
//
//    public void setInvestor(LivestockInvestor investor) {
//        this.investor = investor;
//    }
//
//    public LivestockInvestment getInvestment() {
//        return investment;
//    }
//
//    public void setInvestment(LivestockInvestment investment) {
//        this.investment = investment;
//    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

//    public LivestockCreator getCreator() {
//        return creator;
//    }
//
//    public void setCreator(LivestockCreator creator) {
//        this.creator = creator;
//    }

}