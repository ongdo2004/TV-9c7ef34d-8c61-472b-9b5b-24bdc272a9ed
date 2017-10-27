package com.project.service

import com.project.UserProfile
import com.project.common.table.TableQueryBuilder
import com.project.common.table.TableQueryParams
import com.project.common.table.TableQueryResponse
import com.project.view.UserProfileView
import grails.transaction.Transactional

@Transactional
class UserProfileService {

    def queryPagingService;

    UserProfile getUserProfile(String userToken) {

        return null;
    }

    UserProfileView getUserProfileView(UUID uuid) {

        return UserProfileView.get(uuid);
    }

    private void buildQuery(TableQueryParams queryParams, def builder) {

        println "buildQuery";

        println queryParams.properties;

        println builder.class;
    }

    def TableQueryResponse getList(TableQueryParams queryParams) {

        def UserProfileService this_ = this;

        def TableQueryBuilder queryBuilder = new TableQueryBuilder() {

            @Override
            void buildQuery(Object builder) {

                this_.buildQuery(queryParams, builder);
            }
        };

        return queryPagingService.query(queryBuilder, queryParams, UserProfileView);
    }
}
