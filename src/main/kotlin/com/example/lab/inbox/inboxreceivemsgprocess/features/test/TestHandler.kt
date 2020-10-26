package com.example.lab.inbox.inboxreceivemsgprocess.features.test

import com.example.lab.inbox.inboxreceivemsgprocess.features.test.services.TestService
import com.example.lab.inbox.inboxreceivemsgprocess.utils.getLogger
import com.example.lab.inbox.inboxreceivemsgprocess.utils.transferResponseSuccess
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest

@Component
class TestHandler(
    private val service: TestService
) {
    private companion object {
        private val log = getLogger<TestHandler>()
    }
    suspend fun test(request: ServerRequest) = coroutineScope {
        transferResponseSuccess(
            service.test(request.hashCode())
        )
    }
    suspend fun findAll(request: ServerRequest) = coroutineScope {
        transferResponseSuccess(
            service.findAllUserProfile(request.pathVariable("identifier"))
        )
    }
    suspend fun update(request: ServerRequest) = coroutineScope {
        log.info("Request Id >>>>> ${request.hashCode()}")
        transferResponseSuccess(
            service.updateUserProfileMobileNumberWithIdentifier(
                request.pathVariable("identifier"),request.pathVariable("mobileNo"))
        )
    }
}