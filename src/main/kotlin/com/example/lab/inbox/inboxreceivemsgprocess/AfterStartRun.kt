package com.example.lab.inbox.inboxreceivemsgprocess

import com.example.lab.inbox.inboxreceivemsgprocess.features.test.services.POCService
import com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.models.MatchingRegisterNewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component


@Component
class AfterStartRun(
    private val pocService: POCService
) {

    @EventListener(ApplicationReadyEvent::class)
    fun doSomethingAfterStartup() =runBlocking{
        launch {
            pocService.process(
                MatchingRegisterNewModel(
                    matchingId = "2",
                    customerId = "1",
                    type = "DOPA",
                    status = true
                )
            )
        }
        launch {
            pocService.process(
                MatchingRegisterNewModel(
                    matchingId = "2",
                    customerId = "1",
                    type = "FORM",
                    status = true
                )
            )
        }
        launch {
            pocService.process(
                MatchingRegisterNewModel(
                    matchingId = "2",
                    customerId = "1",
                    type = "FACB",
                    status = true
                )
            )
        }
        launch {
            pocService.process(
                MatchingRegisterNewModel(
                    matchingId = "2",
                    customerId = "1",
                    type = "FACR",
                    status = true
                )
            )
        }
    }
}