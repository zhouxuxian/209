package com;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.domain.Student;
import com.domain.Teacher;

import java.util.List;

public class Test {
    public static StudentDao studentDao = new StudentDao();
    public static TeacherDao teacherDao = new TeacherDao();


    /**
     * 查询所有
     */
    @org.junit.jupiter.api.Test
    public void test1() {
        List<Teacher> teachers = teacherDao.findAll();
        List<Student> students = studentDao.findAll();
        System.out.println("--------所有教师---------");
        teachers.stream().forEach(System.out::println);
        System.out.println("--------所有学生---------");
        students.stream().forEach(System.out::println);
    }

    /**
     * 插入一个教师
     */
  @org.junit.jupiter.api.Test
    public void test2(){
       Teacher teacher = new Teacher(1,"zfq",1);
        teacherDao.insert(teacher);
    }

    /**
     * 插入一个学生
     */
    @org.junit.jupiter.api.Test
    public void test3(){
       Student student = new Student(5,"pxj","女",2);
        studentDao.insert(student);
    }

    /**
     * 删除一个学生
     */
    @org.junit.jupiter.api.Test
    public void test4(){
        studentDao.delete(3);
    }

    /**
     * 更新一个学生
     */
    @org.junit.jupiter.api.Test
    public void test5(){
        Student newStudent = new Student(4,"efg","女",5);
        studentDao.update(newStudent);

    }

    /**
     * 更新一个教师
     */
    @org.junit.jupiter.api.Test
    public void test6(){
        Teacher newTeacher = new Teacher(1,"zzzy",1);
        teacherDao.update(newTeacher);
    }

    /**
     * 删除一个教师
     */
    @org.junit.jupiter.api.Test
    public void test7(){

        teacherDao.delete(1);
    }






}
