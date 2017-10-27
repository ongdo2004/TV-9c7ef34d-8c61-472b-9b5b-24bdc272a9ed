package com.project.domain

trait BaseDomain {

    UUID id;
    Date lastUpdateTime;
    String lastUpdateUser;
    Boolean isDeleted;
}
