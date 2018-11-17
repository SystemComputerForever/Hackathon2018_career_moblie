package com.exercise.android.careergps.Item;

import java.io.Serializable;

/**
 * Created by Benix on 17/11/2018.
 */

public class Jobpost implements Serializable {
    public String id, jobtitletext, displayname, managerialleveldesc, shortdescription, fielddesc, subfield, industrydesc, minexp, maxexp, activationdate, educationleveldesc;

    public Jobpost(String id, String jobtitletext, String displayname, String managerialleveldesc, String shortdescription, String fielddesc, String subfield, String industrydesc, String minexp, String maxexp, String activationdate, String educationleveldesc) {
        this.id = id;
        this.jobtitletext = jobtitletext;
        this.displayname = displayname;
        this.managerialleveldesc = managerialleveldesc;
        this.shortdescription = shortdescription;
        this.fielddesc = fielddesc;
        this.subfield = subfield;
        this.industrydesc = industrydesc;
        this.minexp = minexp;
        this.maxexp = maxexp;
        this.activationdate = activationdate;
        this.educationleveldesc = educationleveldesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobtitletext() {
        return jobtitletext;
    }

    public void setJobtitletext(String jobtitletext) {
        this.jobtitletext = jobtitletext;
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

    public String getSubfield() {
        return subfield;
    }

    public void setSubfield(String subfield) {
        this.subfield = subfield;
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

    public String getActivationdate() {
        return activationdate;
    }

    public void setActivationdate(String activationdate) {
        this.activationdate = activationdate;
    }

    public String getEducationleveldesc() {
        return educationleveldesc;
    }

    public void setEducationleveldesc(String educationleveldesc) {
        this.educationleveldesc = educationleveldesc;
    }
}
