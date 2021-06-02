package com.example.phamngocnhuy_18055121;

public class Student {
    private String id;
    private String name;
    private String classhoc;
    private String status;
    private String workingAt;

    public Student() {
    }

    public Student(String name, String classhoc, String status, String workingAt) {
        this.name = name;
        this.classhoc = classhoc;
        this.status = status;
        this.workingAt = workingAt;
    }

    public Student(String id, String name, String classhoc, String status, String workingAt) {
        this.id = id;
        this.name = name;
        this.classhoc = classhoc;
        this.status = status;
        this.workingAt = workingAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasshoc() {
        return classhoc;
    }

    public void setClasshoc(String classhoc) {
        this.classhoc = classhoc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkingAt() {
        return workingAt;
    }

    public void setWorkingAt(String workingAt) {
        this.workingAt = workingAt;
    }

    @Override
    public String toString() {
        return id + ' ' + name + ' ' + classhoc + ' ' + status + ' ' + workingAt;
    }
}
