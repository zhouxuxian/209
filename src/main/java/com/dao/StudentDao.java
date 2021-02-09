package com.dao;

import com.domain.Student;
import com.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDao {


    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    public List<Student> findAll(){
        String sql = "select * from stuInfo";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return students;
    }

    public void delete(int id){
        String sql = "delete from stuInfo where id = ? ";
        jdbcTemplate.update(sql,id);
    }

    public void insert(Student student){
        String sql = "insert into stuInfo(id,name,sex,classId) values (?,?,?,?)";
        jdbcTemplate.update(sql,student.getId(),student.getName(),student.getSex(),student.getClassId());
    }

    public void update(Student student){
        String sql = "update stuInfo set name =?,sex=?,classId=? where id=?";
        jdbcTemplate.update(sql,student.getName(),student.getSex(),student.getClassId(),student.getId());
    }






}
