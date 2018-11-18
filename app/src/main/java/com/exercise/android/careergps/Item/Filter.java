package com.exercise.android.careergps.Item;

import java.io.Serializable;

/**
 * Created by Benix on 18/11/2018.
 */

public class Filter implements Serializable {

    String jobtitle;
    String industrydesc;
    String education;
    String experience;
    String minsalary;
    String maxsalary;

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getIndustrydesc() {
        return industrydesc;
    }

    public void setIndustrydesc(String industrydesc) {
        this.industrydesc = industrydesc;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(String minsalary) {
        this.minsalary = minsalary;
    }

    public String getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(String maxsalary) {
        this.maxsalary = maxsalary;
    }

    public Filter(String jobtitle, String industrydesc, String education, String experience, String minsalary, String maxsalary) {
        this.jobtitle = jobtitle;

        this.industrydesc = industrydesc;
        this.education = education;
        this.experience = experience;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
    }
}
