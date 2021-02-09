package com.domain;

public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer classId;

    public Student() {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Student(Integer id, String name, String sex, Integer classId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", classId=" + classId +
                '}';
    }
}
