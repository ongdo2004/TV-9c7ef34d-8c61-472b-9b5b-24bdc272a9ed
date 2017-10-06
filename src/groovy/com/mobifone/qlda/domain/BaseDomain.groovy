package com.mobifone.qlda.domain

trait BaseDomain {

    UUID id;
    Date lastUpdateTime;
    String lastUpdateUser;
    Boolean isDeleted = false;
}
