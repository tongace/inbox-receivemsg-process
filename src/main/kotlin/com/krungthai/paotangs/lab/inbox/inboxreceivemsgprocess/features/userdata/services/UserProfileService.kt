package com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.features.userdata.services

import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.data.repositories.UserProfileRepository
import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.utils.getLogger
import org.springframework.stereotype.Service

@Service
class UserProfileService(
    private val userProfileRepository: UserProfileRepository
){
    private companion object {
        private val log = getLogger<UserProfileService>()
    }
    suspend fun findUserByMobileNo(mobileNo: String) =
        userProfileRepository.findByConsumerMobileNumber(mobileNo)
}