package com.mobifone.qlda.domain

class UserProfileView {

    String email;
    String username;
    Date expireDate;
    UUID productId;
    String buyURL;
    String productName;
    BigDecimal productPrice;
    String currencyCode;

    static constraints = {
    }
}
