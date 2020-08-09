package com.projects.homebase.api.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

@Component("getDeviceResponse")

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
        "name",
        "type",
        "actions"


})
public class GetDevicesResponse {
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("actions")
    private Object[] actions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object[] getActions() {
        return actions;
    }

    public void setActions(Object[] actions) {
        this.actions = actions;
    }
}
