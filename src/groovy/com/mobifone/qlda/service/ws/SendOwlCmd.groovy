package com.mobifone.qlda.service.ws

/**
 * example https://KEY:SECRET@www.sendowl.com/api/v1/products;
 */
abstract class SendOwlCmd extends BaseCommand {

    String key; //1bb64c3c97ba28f
    String secret; //f5063c5ab2de815425d2
    String sendOwlURL; //www.sendowl.com/api
    String serviceURL; //v1/products
    String url;

    @Override
    void sendRequest() {

        this.buildURL();

        super.sendRequest();
    }

    protected void buildURL() {

        this.url = "https://${this.key}:${this.secret}@${this.sendOwlURL}/${this.serviceURL}";
    }

    @Override
    String getApiCode() {

        return this.class.name;
    }
}
