package com.example.lab.inbox.inboxreceivemsgprocess.features.test

import com.example.lab.inbox.inboxreceivemsgprocess.features.test.services.TestService
import com.example.lab.inbox.inboxreceivemsgprocess.utils.transferResponseSuccess
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.reactive.asFlow
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class TestHandler(
    private val service: TestService
) {
    suspend fun test(request: ServerRequest) = coroutineScope {
        request.pathVariable("identifier").let {
            transferResponseSuccess(
                service.findAllUserProfile(it)
            )
        }
    }
}