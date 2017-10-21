package com.mobifone.qlda.service.ws

import com.mobifone.qlda.common.Error
import com.mobifone.qlda.common.ErrorCode

import grails.converters.JSON

abstract class BaseCommand implements CommandInterface {

    def result;

    Error error;

    private Long commandId;
    private Date requestDate;
    private Long duration;
    private WebserviceHistory history;

    @Override
    boolean execute() {

        try {

            this.commandId = (this.requestDate = new Date()).time;

            this.sendRequest();

        } catch (Exception ex) {

            this.duration = (new Date()).time - this.requestDate.time;

            this.error = new Error(errorCode: ErrorCode.WS_EXCEPTION, params: [commandId, ex.getMessage()]);

            println("Command Exception : commandId=${this.commandId}");

            ex.printStackTrace();

        } finally {

            this.duration = (new Date()).time - this.requestDate.time;

            this.storeHistory();
        }
    }

    private void storeHistory() {

        history = new WebserviceHistory(
                apiCode: this.apiCode, requestContent: this.toJSON(), responseContent: result ? (result as JSON) : null,
                errorContent: error ? (error as JSON) : null, requestDate: this.requestDate, duration: this.duration,
                commandId: this.commandId
        );

        history.save(flush: true, failOnError: true);
    }

    abstract String toJSON();

    abstract String getApiCode();

    abstract void sendRequest();
}
