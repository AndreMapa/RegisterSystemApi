package com.andremapa.RegisterSystem.Models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    private final String title;
    private final Integer status;
    private final List<Field> fieldList;

    public Error(String title, int status, List<Field> fieldList) {
        this.title = title;
        this.status = status;
        this.fieldList = fieldList;
    }

    public String getTitle() {
        return title;
    }

    public Integer getStatus() {
        return status;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public static class Field{

        private final String name;
        private final String message;

        public Field(String name, String message){
            this.name = name;
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public String getMessage() {
            return message;
        }
    }
}
