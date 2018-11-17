package com.exercise.android.careergps.Item;

import java.io.Serializable;

/**
 * Created by Benix on 17/11/2018.
 */

public class User implements Serializable {
    private String u_id, user_name, email, phone_num, pwd, last_name, first_name, yob, gender, p_img, education, exp;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
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

    public String getP_img() {
        return p_img;
    }

    public void setP_img(String p_img) {
        this.p_img = p_img;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public User(String u_id, String user_name, String email, String phone_num, String pwd, String last_name, String first_name, String yob, String gender, String p_img, String education, String exp) {
        this.u_id = u_id;
        this.user_name = user_name;
        this.email = email;
        this.phone_num = phone_num;
        this.pwd = pwd;
        this.last_name = last_name;
        this.first_name = first_name;
        this.yob = yob;
        this.gender = gender;
        this.p_img = p_img;
        this.education = education;
        this.exp = exp;

    }
}