package com.tvServer

import com.mobifone.qlda.common.table.TableQueryBuilder
import com.mobifone.qlda.common.table.TableQueryParams
import com.mobifone.qlda.common.table.TableQueryResponse

import grails.transaction.Transactional

@Transactional
class ProductService {

    def queryPagingService;

    private void buildQuery(TableQueryParams queryParams, def builder) {

        println "buildQuery";

        println queryParams.properties;

        println builder.class;
    }

    def TableQueryResponse getList(TableQueryParams queryParams) {

        def ProductService this_ = this;

        def TableQueryBuilder queryBuilder = new TableQueryBuilder() {

            @Override
            void buildQuery(Object builder) {

                this_.buildQuery(queryParams, builder);
            }
        };

        return queryPagingService.query(queryBuilder, queryParams, ProductView);
    }

    Product getDefaultProduct() {

        return null;
    }
}
