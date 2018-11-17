package com.exercise.android.careergps.Item;

import java.io.Serializable;

/**
 * Created by Benix on 17/11/2018.
 */

public class User implements Serializable {
    private String u_id, uname, email, phonenum, pwd, lname, fname, yob, gender, country, city, joinno;

    public User(String u_id, String uname, String email, String phonenum, String pwd, String lname, String fname, String yob, String gender, String country, String city, String joinno) {
        this.u_id = u_id;
        this.uname = uname;
        this.email = email;
        this.phonenum = phonenum;
        this.pwd = pwd;
        this.lname = lname;
        this.fname = fname;
        this.yob = yob;
        this.gender = gender;
        this.country = country;
        this.city = city;
        this.joinno = joinno;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJoinno() {
        return joinno;
    }

    public void setJoino() {
        this.joinno = joinno;
    }
}