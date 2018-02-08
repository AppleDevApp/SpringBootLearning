package com.appledevapp.learning.excelexport.util;

import com.appledevapp.learning.excelexport.entity.MultiTypeEntity;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataConvertorTest {

    @Test
    public void testToMapList() throws Exception {

        List<MultiTypeEntity> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MultiTypeEntity typeEntity = new MultiTypeEntity();
            typeEntity.setId((long) i);
            typeEntity.setAge(i + 1);
            typeEntity.setName("Hello" + i);
            typeEntity.setPayMoney(BigDecimal.valueOf(10.25 + i));
            dataList.add(typeEntity);
        }

        List<Map<Object, Object>> mapList = DataConvertor.toMapList(dataList);
        BigDecimal money = (BigDecimal) mapList.get(0).get("payMoney");
        Assert.assertNotEquals(mapList.size(), 0);

    }
}