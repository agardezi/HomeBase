package com.projects.homebase.api.model;

import com.projects.homebase.api.factory.ActionFactory;
import com.projects.homebase.api.factory.DeviceFactory;
import com.projects.homebase.api.model.action.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("device")
public abstract class Device {

    private ActionFactory actionFactory = new ActionFactory();
    private String type;
    private String name;
    private String ipAddr;
    private List<Action> actions = new ArrayList<Action>();;

    public void addAction(ActionSummary actionSummary){

        Action action = actionFactory.create(actionSummary.getType());
        action.setName(actionSummary.getName());
        action.setEndpoint(actionSummary.getEndpoint());
        action.setValueTypes(actionSummary.getValueType());
        action.setParameter(actionSummary.getParameter());
        actions.add(action);

    }


    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getAction(String actionName){
        try{
            for(Action action: actions){
                if(action.getName().equals(actionName))
                    return action;
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public String toString(){
        String deviceString = "";

        return deviceString;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
