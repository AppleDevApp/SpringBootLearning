package com.appledevapp.learning.jpatemplate.repository;

import com.appledevapp.learning.jpatemplate.entity.MonthPayMent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;

/**
 * //@Repository 这里不需要@Repository注解，是因为JpaRepository内部已经有注解
 */
//@Transactional
public interface MonthPayMentRepository extends JpaRepository<MonthPayMent, Integer> {

    /**
     * 更新和删除必须带事务，不然会异常
     * TransactionRequiredException: Executing an update/delete query
     * @param name
     * @param salary
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "update month_payment p set p.name = :name , p.salary = :salary where p.id = :id", nativeQuery = true)
    int updateById(@Param("name") String name, @Param("salary") BigDecimal salary, @Param("id") int id);

    /**
     * 使用问号作为参数的办法，参数顺序跟方法顺序一致
     * @param name
     * @param salary
     * @param id
     * @return
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update month_payment p set p.name = ?1 , p.salary = ?2 where p.id = ?3", nativeQuery = true)
    int updateByIdUsingIndex(String name, BigDecimal salary, int id);
}
