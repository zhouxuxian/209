package com.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JdbcUtils {
    private static DataSource dataSource;
    private static JdbcTemplate jdbcTemplate;

    static {
        try {
            Properties properties = new Properties();
            InputStream is = JdbcUtils.class.getResourceAsStream("/druid.properties");
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    public static DataSourceTransactionManager transactionManager(JdbcTemplate jdbcTemplate) {
        return new DataSourceTransactionManager(jdbcTemplate.getDataSource());
    }


    /**
     * 开启事务
     */
    public static TransactionStatus beginTransaction(DataSourceTransactionManager transactionManager) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();//事务定义类
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);// 返回事务对象
        return status;
    }

    /**
     * 提交事务
     */
    public static void commitTransaction(DataSourceTransactionManager transactionManager, TransactionStatus status) {
        transactionManager.commit(status);
    }

    /**
     * 事务回滚
     */
    public static void rollbackTransaction(DataSourceTransactionManager transactionManager, TransactionStatus status) {
        transactionManager.rollback(status);
    }
}
