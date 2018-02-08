package com.appledevapp.learning.excelexport.entity;

import java.io.Serializable;

public class InnerTypeEntity implements Serializable {

    private Long typeId;
    private String typeName;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
