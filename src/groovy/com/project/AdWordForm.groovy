package com.project

import grails.validation.Validateable

@Validateable
class AdWordForm {

    String id;
    String url;
    String type;
    String redirectURL;

    static constraints = {

        id(nullable: true);
        url(nullable: false, size: 0..300);
        type(nullable: true, size: 0..50);
        redirectURL(nullable: true, size: 0..300);
    }
}
