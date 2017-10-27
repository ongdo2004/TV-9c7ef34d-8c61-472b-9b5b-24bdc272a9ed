package com.project.adword

import com.project.domain.BaseDomain

class AdWordInfo implements BaseDomain {

    String url;
    String type;
    String redirectURL;

    static constraints = {

        url(nullable: false, size: 0..300);
        type(nullable: true, size: 0..50);
        redirectURL(nullable: true, size: 0..300);
    }

    static mapping = {

        url(type: "string", length: 300);
        type(type: "string", length: 50);
        redirectURL(type: "string", length: 300);
    }
}
