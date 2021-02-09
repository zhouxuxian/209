package com.dao;

import com.domain.Teacher;
import com.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;

import java.util.List;

public class TeacherDao {
    private JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
    private DataSourceTransactionManager transactionManager = JdbcUtils.transactionManager(jdbcTemplate);

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


    public Teacher findById(int id){
        String sql = "select * from teacherInfo where id = ?";
        Teacher teacher = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Teacher.class), id);
        return teacher;

    }

    public void update(Teacher teacher){
        TransactionStatus transactionStatus = null;
        try {
             transactionStatus = JdbcUtils.beginTransaction(transactionManager);
            if (findById(teacher.getId())==null){
                throw new Exception();
            }
            String sql = "update teacherInfo set name =?,classId=? where id=?";
            jdbcTemplate.update(sql,teacher.getName(),teacher.getClassId(),teacher.getId());

            JdbcUtils.commitTransaction(transactionManager,transactionStatus);
        }catch (Exception e){
            System.out.println();
            System.err.println("不存在此人,更新失败");
            JdbcUtils.rollbackTransaction(transactionManager,transactionStatus);
        }



    }





}
