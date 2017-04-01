package com.example.carlo.livestocktracker.objects;

import java.util.Date;

/**
 * Created by Carlo on 3/28/2017.
 */

public class LivestockMedHist {

    private String description;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
