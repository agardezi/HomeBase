package com.projects.homebase.api.model;

import com.projects.homebase.api.factory.ActionFactory;
import com.projects.homebase.api.factory.DeviceFactory;
import com.projects.homebase.api.model.action.Action;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public abstract class Device {

    private ActionFactory actionFactory = new ActionFactory();
    private String name;
    private String ipAddr;
    private List<Action> actions = new ArrayList<Action>();;

    public void addAction(ActionSummary actionSummary){

        Action action = actionFactory.create(actionSummary.getType());
        action.setName(actionSummary.getName());
        action.setEndpoint(actionSummary.getEndpoint());
        actions.add(action);


    }

    /**
     * For invoke request
     * @param AcionName
     * @param payload
     */
    public void triggerAction(String AcionName, Object payload){}

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
}
