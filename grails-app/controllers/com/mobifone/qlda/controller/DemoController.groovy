package com.mobifone.qlda.controller

import com.mobifone.qlda.common.table.TableQueryParams
import com.mobifone.qlda.common.table.TableQueryResponse
import com.mobifone.qlda.service.ResultBean
import grails.converters.JSON

class DemoController {

    public static final List<LinkedHashMap<String, Serializable>> TABLE_DUMMY = [
            [id: 1, name: "Nguyen Quoc Huy", age: 29],
            [id: 1, name: "Nguyen Quoc Huy", age: 29],
    ]

    def getTableData() {

        def TableQueryParams tableQueryParams = bindData(new TableQueryParams(), this.request.JSON);

        println tableQueryParams.properties;

        render(new ResultBean(result: new TableQueryResponse(
                pageIndex: tableQueryParams.pageIndex, dataSize: 100, pageData: TABLE_DUMMY
        )) as JSON);
    }
}
