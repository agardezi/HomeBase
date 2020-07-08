package com.projects.homebase.api.factory;

import com.projects.homebase.api.model.action.Action;
import com.projects.homebase.api.constant.HomeBaseCommonConstant;
import com.projects.homebase.api.model.action.PathAction;
import com.projects.homebase.api.model.action.QueryAction;
import com.projects.homebase.api.model.action.RequestBodyAction;
import org.springframework.stereotype.Component;

@Component
public class ActionFactory {

    public Action create(String actionType){
        switch(actionType){
            case HomeBaseCommonConstant.QUERY:
                return new QueryAction();
            case HomeBaseCommonConstant.PATH:
                return new PathAction();
            case HomeBaseCommonConstant.REQUEST_BODY:
                return new RequestBodyAction();
        }
        //TODO: Exception handling SHOULD NEVER RETURN NULL
        return null;
    }
}
