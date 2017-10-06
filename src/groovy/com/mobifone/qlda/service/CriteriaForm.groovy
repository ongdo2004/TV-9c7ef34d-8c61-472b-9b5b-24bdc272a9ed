package com.mobifone.qlda.service

import grails.validation.Validateable

@Validateable
class CriteriaForm {

    String name;
    String description;
    String type; // optional | mandatory

    static constraints = {
    }
}
