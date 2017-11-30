package com.appledevapp.learning.jdbctemplate.datalayer;

import com.appledevapp.learning.jdbctemplate.entity.MonthPayMent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MonthPayMentDaoImpl implements MonthPaymentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(MonthPayMent payMent) {
        //这种写法是可以获取到主键自增ID的
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement ps = con.prepareStatement("insert into month_payment(name, salary) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
            //这里要手动设置参数值，序列从1开始，暂时没想到好办法
            ps.setString(1, payMent.getName());
            ps.setBigDecimal(2, payMent.getSalary());
            return ps;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public int update(MonthPayMent payMent) {
        return jdbcTemplate.update("update month_payment set name = ?, salary = ? where id = ?",
                payMent.getName(), payMent.getSalary());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from month_payment where id = ?");
    }

    @Override
    public MonthPayMent findPaymentById(int id) {
        //这里有个坑，使用queryForObject是会报错，原因是只能映射基本java类型
        List<MonthPayMent> recordList = jdbcTemplate.query("select * from month_payment where id = ? LIMIT 1", new Object[]{id}, new BeanPropertyRowMapper(MonthPayMent.class));
        if (recordList != null && !recordList.isEmpty()) {
            return recordList.get(0);
        }
        return null;
    }

    @Override
    public List<MonthPayMent> findPaymentList() {
        //这里有个坑，使用queryForList是会报错的，原因是只能映射基本java类型
        return jdbcTemplate.query("select * from month_payment", new BeanPropertyRowMapper(MonthPayMent.class));
    }
}
