package com.example.phil.noteapp;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Phil on 06.06.2016.
 */
public class Note {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mFinished;

    public Note() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isFinished() {
        return mFinished;
    }

    public void setFinished(boolean finished) {
        mFinished = finished;
    }

    public String getTitle() { //NOTE: Rightclick > Generate Getters and Setters !
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

}
