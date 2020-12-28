package com.example.lab.inbox.inboxreceivemsgprocess

import com.example.lab.inbox.inboxreceivemsgprocess.data.database.repositories.UserProfileRepository
import com.example.lab.inbox.inboxreceivemsgprocess.utils.LoggerDelegate
import kotlinx.coroutines.runBlocking


//@Component
class AfterStartPOCRun(
    private val userProfileRepository: UserProfileRepository
) {
    private companion object {
        private val log by LoggerDelegate()
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