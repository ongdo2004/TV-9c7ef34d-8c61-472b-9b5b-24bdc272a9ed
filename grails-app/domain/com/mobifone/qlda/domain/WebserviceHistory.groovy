package com.mobifone.qlda.domain

class WebserviceHistory {

    String apiCode;
    String url;
    String requestContent;
    String responseContent;
    String errorContent;
    Date requestDate;
    Long duration;
    Long commandId;

    static constraints = {
    }
}
