package com.appledevapp.learning.multidatasource.controller;

import com.appledevapp.learning.multidatasource.persistence.idcutdb.model.TsHelloWorldExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiDataController {

    @Autowired
    private com.appledevapp.learning.multidatasource.persistence.idcutdb.dao.TsHelloWorldMapper idcutMapper;

    @Autowired
    private com.appledevapp.learning.multidatasource.persistence.etemaldb.dao.TsHelloWorldMapper etemalMapper;

    @RequestMapping("/")
    public Object webIndex(String dbName) {
        switch (dbName) {
            case "idcut": {
                com.appledevapp.learning.multidatasource.persistence.idcutdb.model.TsHelloWorldExample dataFilter = new TsHelloWorldExample();
                return idcutMapper.selectByExample(dataFilter);
            }
            case "etemal": {
                com.appledevapp.learning.multidatasource.persistence.etemaldb.model.TsHelloWorldExample dataFilter = new com.appledevapp.learning.multidatasource.persistence.etemaldb.model.TsHelloWorldExample();
                return etemalMapper.selectByExample(dataFilter);
            }
            default: {
                return null;
            }
        }
    }


}
