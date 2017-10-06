package com.mobifone.qlda.domain

class Product implements BaseDomain {

    String sendOwlProductJson;
    String buyURL;
    String name;
    BigDecimal price;
    String currencyCode;
    String sendOwlProductId;
    int renewTime; //month;

    static constraints = {
    }
}
