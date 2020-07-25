package com.projects.homebase.api.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
TODO: Add field to incorporate requestMethod ie GET, POST, PUT, DELETE
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
        "type",
        "name",
        "endpoint",
        "valueTypes",
        "parameter"

})
public class ActionSummary {

    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("endpoint")
    private String  endpoint;
    @JsonProperty("valueTypes")
    private String valueTypes;
    @JsonProperty("parameter")
    private String parameter;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getValueType() {
        return valueTypes;
    }

    public void setValueType(String valueType) {
        this.valueTypes = valueType;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}

