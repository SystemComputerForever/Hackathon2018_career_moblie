package com.exercise.android.careergps.Item;

import java.io.Serializable;

/**
 * Created by Benix on 17/11/2018.
 */

public class Comment implements Serializable {
    private String department, position, content, created_date, educationleveldesc, workexp;

    public Comment(String department, String position, String content, String created_date, String educationleveldesc, String workexp) {
        this.department = department;
        this.position = position;
        this.content = content;
        this.created_date = created_date;
        this.educationleveldesc = educationleveldesc;
        this.workexp = workexp;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getEducationleveldesc() {
        return educationleveldesc;
    }

    public void setEducationleveldesc(String educationleveldesc) {
        this.educationleveldesc = educationleveldesc;
    }

    public String getWorkexp() {
        return workexp;
    }

    public void setWorkexp(String workexp) {
        this.workexp = workexp;
    }
}
