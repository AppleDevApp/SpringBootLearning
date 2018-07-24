package com.rfchina.community.persistence.mapper;

import com.rfchina.community.persistence.model.ActivityLottery;
import com.rfchina.community.persistence.model.ActivityLotteryExample;
import java.io.Serializable;
import java.util.List;
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

public interface ActivityLotteryMapper extends Serializable {
    @SelectProvider(type=ActivityLotterySqlProvider.class, method="countByExample")
    long countByExample(ActivityLotteryExample example);

    @DeleteProvider(type=ActivityLotterySqlProvider.class, method="deleteByExample")
    int deleteByExample(ActivityLotteryExample example);

    @Delete({
        "delete from activity_lottery",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into activity_lottery (activity_id, uid, ",
        "name, phone, is_win, ",
        "prize_id, prize_name, ",
        "prize_type, ele_codes, ",
        "ele_end_time, send_status, ",
        "create_time, is_confirm, ",
        "confirm_time, package_type)",
        "values (#{activityId,jdbcType=BIGINT}, #{uid,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{isWin,jdbcType=TINYINT}, ",
        "#{prizeId,jdbcType=BIGINT}, #{prizeName,jdbcType=VARCHAR}, ",
        "#{prizeType,jdbcType=TINYINT}, #{eleCodes,jdbcType=VARCHAR}, ",
        "#{eleEndTime,jdbcType=VARCHAR}, #{sendStatus,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{isConfirm,jdbcType=BIT}, ",
        "#{confirmTime,jdbcType=TIMESTAMP}, #{packageType,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ActivityLottery record);

    @InsertProvider(type=ActivityLotterySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ActivityLottery record);

    @SelectProvider(type=ActivityLotterySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_win", property="isWin", jdbcType=JdbcType.TINYINT),
        @Result(column="prize_id", property="prizeId", jdbcType=JdbcType.BIGINT),
        @Result(column="prize_name", property="prizeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="prize_type", property="prizeType", jdbcType=JdbcType.TINYINT),
        @Result(column="ele_codes", property="eleCodes", jdbcType=JdbcType.VARCHAR),
        @Result(column="ele_end_time", property="eleEndTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="send_status", property="sendStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_confirm", property="isConfirm", jdbcType=JdbcType.BIT),
        @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="package_type", property="packageType", jdbcType=JdbcType.INTEGER)
    })
    List<ActivityLottery> selectByExampleWithRowbounds(ActivityLotteryExample example, RowBounds rowBounds);

    @SelectProvider(type=ActivityLotterySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_win", property="isWin", jdbcType=JdbcType.TINYINT),
        @Result(column="prize_id", property="prizeId", jdbcType=JdbcType.BIGINT),
        @Result(column="prize_name", property="prizeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="prize_type", property="prizeType", jdbcType=JdbcType.TINYINT),
        @Result(column="ele_codes", property="eleCodes", jdbcType=JdbcType.VARCHAR),
        @Result(column="ele_end_time", property="eleEndTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="send_status", property="sendStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_confirm", property="isConfirm", jdbcType=JdbcType.BIT),
        @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="package_type", property="packageType", jdbcType=JdbcType.INTEGER)
    })
    List<ActivityLottery> selectByExample(ActivityLotteryExample example);

    @Select({
        "select",
        "id, activity_id, uid, name, phone, is_win, prize_id, prize_name, prize_type, ",
        "ele_codes, ele_end_time, send_status, create_time, is_confirm, confirm_time, ",
        "package_type",
        "from activity_lottery",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.BIGINT),
        @Result(column="uid", property="uid", jdbcType=JdbcType.BIGINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_win", property="isWin", jdbcType=JdbcType.TINYINT),
        @Result(column="prize_id", property="prizeId", jdbcType=JdbcType.BIGINT),
        @Result(column="prize_name", property="prizeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="prize_type", property="prizeType", jdbcType=JdbcType.TINYINT),
        @Result(column="ele_codes", property="eleCodes", jdbcType=JdbcType.VARCHAR),
        @Result(column="ele_end_time", property="eleEndTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="send_status", property="sendStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_confirm", property="isConfirm", jdbcType=JdbcType.BIT),
        @Result(column="confirm_time", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="package_type", property="packageType", jdbcType=JdbcType.INTEGER)
    })
    ActivityLottery selectByPrimaryKey(Long id);

    @UpdateProvider(type=ActivityLotterySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ActivityLottery record, @Param("example") ActivityLotteryExample example);

    @UpdateProvider(type=ActivityLotterySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ActivityLottery record, @Param("example") ActivityLotteryExample example);

    @UpdateProvider(type=ActivityLotterySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ActivityLottery record);

    @Update({
        "update activity_lottery",
        "set activity_id = #{activityId,jdbcType=BIGINT},",
          "uid = #{uid,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "is_win = #{isWin,jdbcType=TINYINT},",
          "prize_id = #{prizeId,jdbcType=BIGINT},",
          "prize_name = #{prizeName,jdbcType=VARCHAR},",
          "prize_type = #{prizeType,jdbcType=TINYINT},",
          "ele_codes = #{eleCodes,jdbcType=VARCHAR},",
          "ele_end_time = #{eleEndTime,jdbcType=VARCHAR},",
          "send_status = #{sendStatus,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "is_confirm = #{isConfirm,jdbcType=BIT},",
          "confirm_time = #{confirmTime,jdbcType=TIMESTAMP},",
          "package_type = #{packageType,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ActivityLottery record);
}