package com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.services

import com.example.lab.inbox.inboxreceivemsgprocess.data.database.entities.UserProfile
import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.repositories.SendUserProfileToOthersRepository
import com.example.lab.inbox.inboxreceivemsgprocess.data.database.repositories.UserProfileRepository
import com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.models.UserModel
import com.example.lab.inbox.inboxreceivemsgprocess.utils.LoggerDelegate
import org.springframework.stereotype.Service

@Service
class UserProfileService(
    private val userProfileRepository: UserProfileRepository,
    private val sendUserToOthersRepo: SendUserProfileToOthersRepository
) {
    private companion object {
        private val log by LoggerDelegate()
    }

    suspend fun findUserByMobileNo(mobileNo: String) =
        userProfileRepository.findByConsumerMobileNumber(mobileNo)

    suspend fun findUserData(mobileNo: String): UserProfile? {
        val userProfile = userProfileRepository.findByConsumerMobileNumber(mobileNo)
        userProfile?.let {
            val userModel = UserModel(it.consumerMobile, it.consumerNameEn)
            log.info("send user model >>>> $userModel")
            sendUserToOthersRepo.userProfileProducer(userModel)
        }
        return userProfile
    }
}