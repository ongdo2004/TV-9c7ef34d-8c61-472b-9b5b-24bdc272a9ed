package com.project.service.common

import com.project.common.table.TableQueryBuilder
import com.project.common.table.TableQueryParams
import com.project.common.table.TableQueryResponse

import grails.transaction.Transactional

@Transactional
class QueryPagingService {

    def TableQueryResponse query(TableQueryBuilder queryBuilder, TableQueryParams queryParams, Class domainClass) {

        TableQueryResponse result = new TableQueryResponse();

        int count = result.dataSize = domainClass.createCriteria().count(
                { queryBuilder.buildQuery(queryParams, delegate); }
        ) ?: 0;

        if (!count) {

            result.pageData = [];

            return result;
        }

        int pageIndex = queryParams.pageIndex;
        int maxPageSize = queryParams.maxPageSize;
        int offset = pageIndex * maxPageSize;

        while (offset >= count) (offset = (--pageIndex) * maxPageSize);

        def pagingParams = [sort: queryParams.sortField, order: queryParams.sortOrder, max: maxPageSize, offset: offset];

        result.pageData = domainClass.createCriteria().list(pagingParams, {
            queryBuilder.buildQuery(queryParams, delegate);
        });

        return result;
    }
}
