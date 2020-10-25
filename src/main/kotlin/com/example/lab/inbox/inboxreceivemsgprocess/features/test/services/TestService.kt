package com.example.lab.inbox.inboxreceivemsgprocess.features.test.services

import com.example.lab.inbox.inboxreceivemsgprocess.data.entities.UserProfile
import com.example.lab.inbox.inboxreceivemsgprocess.data.repositories.UserProfileRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.reactive.awaitFirstOrElse
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration

@Service
class TestService(
    private val userProfileRepository: UserProfileRepository
) {
    suspend fun test(requestUID: Int) {
        testPrint1(requestUID);
        testPrint2(requestUID);
    }

    private suspend fun testPrint1(requestUID: Int) {
        for (ii in 0..10) {
            delay(500)
            println("print in testPrint1 of $requestUID >>>>  $ii")
        }
    }

    private suspend fun testPrint2(requestUID: Int) {
        for (ii in 0..10) {
            delay(1000)
            println("print in testPrint2 of $requestUID >>>>  $ii")
        }
    }

    suspend fun findAllUserProfile(identifier: String) =
        userProfileRepository.findAllUserProfile()
            .collectList()
            .awaitFirstOrNull()
            ?.indexOfFirst { userProfile -> userProfile.identifier==identifier  }?:-1


}