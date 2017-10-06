package com.mobifone.qlda.controller

import com.mobifone.qlda.common.table.TableQueryParams
import com.mobifone.qlda.service.CriteriaForm
import com.mobifone.qlda.service.ResultBean
import grails.converters.JSON

class CriteriaController {

    static scope = "request";

    def criteriaService;
    def criteriaAddService;

    def getList() {

        TableQueryParams tableQueryParams = bindData(new TableQueryParams(), request.JSON);

        println tableQueryParams.properties;

        render(new ResultBean(result: criteriaService.getList(tableQueryParams)) as JSON);
    }

    def create() {

        def CriteriaForm form = bindData(new CriteriaForm(), this.request.JSON);

        println form.properties;

        criteriaAddService.create(form);

        render(criteriaAddService.resultBean as JSON);
    }
}
