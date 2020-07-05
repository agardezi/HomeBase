package com.projects.homebase.api.model;

import com.fasterxml.jackson.annotation.*;


@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
        "type",
        "id",
        "name",
        "ip_addr",
        "action_summary"

})
public class DeviceDetails {

    @JsonProperty("device_type")
    private String deviceType;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id_addr")
    private String ipAddr;
    @JsonProperty("action_summary")
    private ActionSummary[] actionSummary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public ActionSummary[] getActionSummary() {
        return actionSummary;
    }

    public void setActionSummary(ActionSummary[] actionSummary) {
        this.actionSummary = actionSummary;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
