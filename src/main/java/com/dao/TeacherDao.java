package com.dao;

import com.domain.Teacher;
import com.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TeacherDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    public List<Teacher> findAll(){
        String sql = "select * from teacherInfo";
        List<Teacher> teachers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Teacher.class));
        return teachers;
    }

    public void delete(int id){
        String sql = "delete from teacherInfo where id = ? ";
        jdbcTemplate.update(sql,id);
    }
   public void insert(Teacher teacher){
        String sql = "insert into teacherInfo(id,name,classId) values (?,?,?)";
        jdbcTemplate.update(sql,teacher.getId(),teacher.getName(),teacher.getClassId());
    }



    public void update(Teacher teacher){
        String sql = "update teacherInfo set name =?,classId=? where id=?";
        jdbcTemplate.update(sql,teacher.getName(),teacher.getClassId(),teacher.getId());
    }





}
