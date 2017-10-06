package com.tvServer

import com.mobifone.qlda.common.table.TableQueryParams
import com.mobifone.qlda.service.ResultBean
import grails.converters.JSON

class ProductController {

    def productService;

    def getList() {

        TableQueryParams tableQueryParams = bindData(new TableQueryParams(), request.JSON);

        println tableQueryParams.properties;

        render(new ResultBean(result: productService.getList(tableQueryParams)) as JSON);
    }
}
