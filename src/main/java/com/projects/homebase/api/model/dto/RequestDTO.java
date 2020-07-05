package com.projects.homebase.api.model.dto;

import java.util.Map;

public class RequestDTO {
    private Map<String,Object> dataMap;

    public void setAttribute(String key, Object object){
        dataMap.put(key,object);
    }

    public Object getAttribute(String key){
        return dataMap.get(key);
    }

}
