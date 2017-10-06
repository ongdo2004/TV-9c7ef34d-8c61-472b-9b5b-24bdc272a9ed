package com.tvServer

import com.mobifone.qlda.domain.UserProfile
import grails.transaction.Transactional

@Transactional
class NotifyRenewService {

    private void sendRenewEmail(UserProfile userProfile) {
    }

    def scanForSendingRenewEmail() {

        Date now = new Date();

        Date scanDate = now - 5;

        UserProfile.findAllByExpireDate(scanDate).each {

            this.sendRenewEmail(it);
        }
    }
}
