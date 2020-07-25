package com.projects.homebase.api.constant;

public interface HomeBaseCommonConstant {

    String DEVICE_TYPE = "device_type";
    String REQUEST_BODY = "REQUEST_BODY";

    String ARDUINO = "arduino";
    String PI = "pi";

    String QUERY = "query";
    String PATH = "path";


     enum  ActionClassType{
        QUERY("com.projects.homebase.api.model.action.QueryAction"),
        PATH("com.projects.homebase.api.model.action.PathAction"),
        REQUEST_BODY("com.projects.homebase.api.model.action.RequestBodyAction");

        public final String value;

         private ActionClassType(String value) {
             this.value = value;
         }
    }

}
