package com.example.lab.inbox.inboxreceivemsgprocess

import com.example.lab.inbox.inboxreceivemsgprocess.data.entities.UserProfile
import com.example.lab.inbox.inboxreceivemsgprocess.data.repositories.UserProfileRepository
import com.example.lab.inbox.inboxreceivemsgprocess.utils.getLogger
import kotlinx.coroutines.runBlocking
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.data.relational.core.mapping.Column
import org.springframework.stereotype.Component
import kotlin.reflect.full.findAnnotation


//@Component
class AfterStartPOCRun(
//    private val pocService: POCService
    private val userProfileRepository: UserProfileRepository
) {
    private companion object {
        private val log = getLogger<AfterStartPOCRun>()
    }
//    @EventListener(ApplicationReadyEvent::class)
    fun doSomethingAfterStartup() = runBlocking {
        userProfileRepository.findByConsumerMobileNumber("0872276122")
            ?.let {
                userProfileRepository.updateUserProfileByMobileNo(
                    it.copy(
                        consumerNameTh = "แขรัศมิ์"
                    )
                )
            }
//        launch {
//            pocService.process(
//                MatchingRegisterNewModel(
//                    matchingId = "2",
//                    customerId = "1",
//                    type = "DOPA",
//                    status = true
//                )
//            )
//        }
//        launch {
//            pocService.process(
//                MatchingRegisterNewModel(
//                    matchingId = "2",
//                    customerId = "1",
//                    type = "FORM",
//                    status = true
//                )
//            )
//        }
//        launch {
//            pocService.process(
//                MatchingRegisterNewModel(
//                    matchingId = "2",
//                    customerId = "1",
//                    type = "FACB",
//                    status = true
//                )
//            )
//        }
//        launch {
//            pocService.process(
//                MatchingRegisterNewModel(
//                    matchingId = "2",
//                    customerId = "1",
//                    type = "FACR",
//                    status = true
//                )
//            )
//        }

    }
}