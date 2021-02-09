package com.dao;

import com.domain.Student;
import com.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;

import java.util.List;

public class StudentDao {


    private JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
    private DataSourceTransactionManager transactionManager = JdbcUtils.transactionManager(jdbcTemplate);

    public List<Student> findAll(){
        String sql = "select * from stuInfo";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return students;
    }

    public void delete(int id){
        String sql = "delete from stuInfo where id = ? ";
        jdbcTemplate.update(sql,id);
    }
    public Student findById(int id){
        String sql = "select * from stuInfo where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
        return student;

    }

    public void insert(Student student){
        String sql = "insert into stuInfo(id,name,sex,classId) values (?,?,?,?)";
        jdbcTemplate.update(sql,student.getId(),student.getName(),student.getSex(),student.getClassId());
    }

    public void update(Student student){
        TransactionStatus transactionStatus = null;
        try {
            transactionStatus = JdbcUtils.beginTransaction(transactionManager);
            if (findById(student.getId())==null){
                throw new Exception();
            }
            String sql = "update stuInfo set name =?,sex=?,classId=? where id=?";
            jdbcTemplate.update(sql,student.getName(),student.getSex(),student.getClassId(),student.getId());

            JdbcUtils.commitTransaction(transactionManager,transactionStatus);
        }catch (Exception e){
            System.out.println();
            System.err.println("不存在此人,更新失败");
            JdbcUtils.rollbackTransaction(transactionManager,transactionStatus);
        }






    }






}
