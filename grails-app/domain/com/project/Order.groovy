package com.project

class Order {

    UUID productId;
    Long quantity;
    String code;

    String customerName;
    String customerPhone;
    String customerEmail;
    String customerAddress;

    String status;

    static constraints = {
    }
}
