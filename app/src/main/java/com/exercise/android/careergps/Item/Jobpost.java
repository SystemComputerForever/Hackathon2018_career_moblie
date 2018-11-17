package com.exercise.android.careergps.Item;

import java.io.Serializable;

/**
 * Created by Benix on 17/11/2018.
 */

public class Jobpost implements Serializable {
    public String post_id, jobtitle, displayname, managerialleveldesc, shortdescription, fielddesc, subfielddesc, industrydesc, minexp, maxexp, date, education, salary, skills;

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getskills() {
        return skills;
    }

    public void setskills(String skills) {
        this.skills = skills;
    }

    public Jobpost(String post_id, String jobtitle, String displayname, String managerialleveldesc, String shortdescription, String fielddesc, String subfielddesc, String industrydesc, String minexp, String maxexp, String date, String education, String salary, String skills) {
        this.post_id = post_id;
        this.jobtitle = jobtitle;
        this.displayname = displayname;
        this.managerialleveldesc = managerialleveldesc;
        this.shortdescription = shortdescription;
        this.fielddesc = fielddesc;
        this.subfielddesc = subfielddesc;
        this.industrydesc = industrydesc;
        this.minexp = minexp;
        this.maxexp = maxexp;
        this.date = date;
        this.education = education;
        this.salary = salary;
        this.skills = skills;
    }

    public String getId() {
        return post_id;
    }

    public void setId(String post_id) {
        this.post_id = post_id;
    }

    public String getjobtitle() {
        return jobtitle;
    }

    public void setjobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getManagerialleveldesc() {
        return managerialleveldesc;
    }

    public void setManagerialleveldesc(String managerialleveldesc) {
        this.managerialleveldesc = managerialleveldesc;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public String getFielddesc() {
        return fielddesc;
    }

    public void setFielddesc(String fielddesc) {
        this.fielddesc = fielddesc;
    }

    public String getsubfielddesc() {
        return subfielddesc;
    }

    public void setsubfielddesc(String subfielddesc) {
        this.subfielddesc = subfielddesc;
    }

    public String getIndustrydesc() {
        return industrydesc;
    }

    public void setIndustrydesc(String industrydesc) {
        this.industrydesc = industrydesc;
    }

    public String getMinexp() {
        return minexp;
    }

    public void setMinexp(String minexp) {
        this.minexp = minexp;
    }

    public String getMaxexp() {
        return maxexp;
    }

    public void setMaxexp(String maxexp) {
        this.maxexp = maxexp;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String geteducation() {
        return education;
    }

    public void seteducation(String education) {
        this.education = education;
    }
}
