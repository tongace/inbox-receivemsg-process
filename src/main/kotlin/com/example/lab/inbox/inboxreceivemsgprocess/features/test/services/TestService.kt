package com.example.lab.inbox.inboxreceivemsgprocess.features.test.services

import com.example.lab.inbox.inboxreceivemsgprocess.data.database.entities.UserProfile
import com.example.lab.inbox.inboxreceivemsgprocess.data.database.repositories.UserProfileRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.reactive.TransactionalOperator
import org.springframework.transaction.reactive.executeAndAwait
import java.time.LocalDateTime

@Service
class TestService(
    private val userProfileRepository: UserProfileRepository,
    private val transactionalOperator: TransactionalOperator
) {
    suspend fun test(requestUID: Int) {
        testPrint1(requestUID)
        testPrint2(requestUID)
    }

    private suspend fun testPrint1(requestUID: Int) {
//        coroutineScope {
//            for (ii in 0..10) {
//                delay(200)
//                println("print in testPrint1 of $requestUID >>>>  $ii")
//            }
//        }
        for (ii in 0..10) {
            delay(200)
            println("print in testPrint1 of $requestUID >>>>  $ii")
        }
    }

    private suspend fun testPrint2(requestUID: Int) {
//        coroutineScope {
//            for (ii in 0..10) {
//                delay(300)
//                println("print in testPrint2 of $requestUID >>>>  $ii")
//            }
//        }
        for (ii in 0..10) {
            delay(300)
            println("print in testPrint2 of $requestUID >>>>  $ii")
        }
    }

    suspend fun findAllUserProfile(identifier: String) =
        userProfileRepository.findAllUserProfile()
            .collectList()
            .awaitFirstOrNull()
            ?.indexOfFirst { userProfile -> userProfile.identifier == identifier } ?: -1

    suspend fun updateUserProfileMobileNumberWithIdentifier(identifier: String, mobileNo: String) =
        transactionalOperator.executeAndAwait {
            userProfileRepository.findByConsumerIdentifier(identifier)?.let {
//                userProfileRepository.insertUserProfile(
//                    it.transformForUpdate(mobileNo)
//                )
                userProfileRepository.updateUserProfile(
                    it.transformForUpdate(mobileNo)
                )
            }
        }


    private suspend fun UserProfile.transformForUpdate(mobileNo: String) = copy (
        consumerMobile = mobileNo,
        updateDate= LocalDateTime.now()
    )
}