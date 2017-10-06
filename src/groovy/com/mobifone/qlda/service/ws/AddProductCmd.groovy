package com.mobifone.qlda.service.ws

import grails.plugins.rest.client.RestBuilder

class AddProductCmd extends SendOwlCmd {

    @Override
    String toJSON() {
        return null
    }

    @Override
    void sendRequest() {

        this.result = new RestBuilder(connectTimeout: 1000, readTimeout: 1000)
    }
}
