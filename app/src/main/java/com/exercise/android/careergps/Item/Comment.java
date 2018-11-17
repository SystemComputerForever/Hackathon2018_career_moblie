package com.exercise.android.careergps.Item;

import java.io.Serializable;

/**
 * Created by Benix on 17/11/2018.
 */

public class Comment implements Serializable {
    private String department, position, content, post_deadline, educationleveldesc, workexp;

    public Comment(String department, String position, String content, String post_deadline, String educationleveldesc, String workexp) {
        this.department = department;
        this.position = position;
        this.content = content;
        this.post_deadline = post_deadline;
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

    public String getPost_deadline() {
        return post_deadline;
    }

    public void setPost_deadline(String post_deadline) {
        this.post_deadline = post_deadline;
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
