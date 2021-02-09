package com.domain;

public class Teacher {
    private Integer id;
    private String name;
    private Integer classId;
    public Teacher() {
    }

    public Teacher(Integer id, String name,Integer classId) {
        this.id = id;
        this.name = name;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
