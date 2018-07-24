package com.appledevapp.learning.multidatasource.persistence.idcutdb.dao;

import com.appledevapp.learning.multidatasource.persistence.idcutdb.model.TsHelloWorld;
import com.appledevapp.learning.multidatasource.persistence.idcutdb.model.TsHelloWorldExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.List;

public interface TsHelloWorldMapper extends Serializable {
    @SelectProvider(type=TsHelloWorldSqlProvider.class, method="countByExample")
    long countByExample(TsHelloWorldExample example);

    @DeleteProvider(type=TsHelloWorldSqlProvider.class, method="deleteByExample")
    int deleteByExample(TsHelloWorldExample example);

    @Delete({
        "delete from ts_hello_world",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ts_hello_world (name)",
        "values (#{name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TsHelloWorld record);

    @InsertProvider(type=TsHelloWorldSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TsHelloWorld record);

    @SelectProvider(type=TsHelloWorldSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<TsHelloWorld> selectByExampleWithRowbounds(TsHelloWorldExample example, RowBounds rowBounds);

    @SelectProvider(type=TsHelloWorldSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<TsHelloWorld> selectByExample(TsHelloWorldExample example);

    @Select({
        "select",
        "id, name",
        "from ts_hello_world",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    TsHelloWorld selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TsHelloWorldSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TsHelloWorld record, @Param("example") TsHelloWorldExample example);

    @UpdateProvider(type=TsHelloWorldSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TsHelloWorld record, @Param("example") TsHelloWorldExample example);

    @UpdateProvider(type=TsHelloWorldSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TsHelloWorld record);

    @Update({
        "update ts_hello_world",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TsHelloWorld record);
}