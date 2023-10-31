package com.example.mySpring.dto;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class userInfo {
    private String name;
    private String gender;
    private int year;
    private int month;
    private int day;
    private String[] favorite;

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String[] getFavorite() {
        return favorite;
    }
}
