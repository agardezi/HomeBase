package com.projects.homebase.api.model.action;

import com.projects.homebase.api.model.ActionSummary;

public abstract class Action {
    private String name;
    private String endpoint; // part of api that is appended to base
    private String[] valueTypes;
    private String parameter;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    public void setValueTypes(String[] valueTypes) {
        this.valueTypes = valueTypes;
    }
    public String[] getValueTypes(){
        return valueTypes;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }


    /***
     * public generateRequest(payload)
     * TODO: Needs to be override in child classes as generateRequest logic is different
     */

}
