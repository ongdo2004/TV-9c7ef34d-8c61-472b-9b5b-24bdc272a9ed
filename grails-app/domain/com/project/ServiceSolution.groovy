package com.project

import com.project.domain.BaseDomain

class ServiceSolution implements BaseDomain {

    String title;
    String htmlContent;

    static constraints = {

        title(nullable: false, size: 0..200);
        htmlContent(nullable: false);
    }

    static mapping = {

        title(type: "string", length: 200);
        htmlContent(sqlType: "text");
    }
}
