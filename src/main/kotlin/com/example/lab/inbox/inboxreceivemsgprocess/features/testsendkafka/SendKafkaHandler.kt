package com.example.lab.inbox.inboxreceivemsgprocess.features.testsendkafka

import com.example.lab.inbox.inboxreceivemsgprocess.features.testsendkafka.services.SendChangeDataService
import com.example.lab.inbox.inboxreceivemsgprocess.features.testsendkafka.services.SendExistingRegisterService
import com.example.lab.inbox.inboxreceivemsgprocess.features.testsendkafka.services.SendForgotPinService
import com.example.lab.inbox.inboxreceivemsgprocess.features.testsendkafka.services.SendNewRegisterService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

@Component
class SendKafkaHandler (
    private val sendNewRegisterService: SendNewRegisterService,
    private val sendRegisterExistingService: SendExistingRegisterService,
    private val sendForgotPinService: SendForgotPinService,
    private val sendChangeDataService: SendChangeDataService
){
    suspend fun sendRegisterNew(request: ServerRequest) :ServerResponse{
        sendNewRegisterService.send()
        return ServerResponse
            .ok()
            .json()
            .bodyValueAndAwait(
                "Sent New !!!!"
            )
    }
    suspend fun sendRegisterExisting(request: ServerRequest) :ServerResponse{
        sendRegisterExistingService.send()
        return ServerResponse
            .ok()
            .json()
            .bodyValueAndAwait(
                "Sent Existing !!!!"
            )
    }
    suspend fun sendChangeData(request: ServerRequest) :ServerResponse{
        sendChangeDataService.send()
        return ServerResponse
            .ok()
            .json()
            .bodyValueAndAwait(
                "Sent Change Data !!!!"
            )
    }
    suspend fun sendForgotPin(request: ServerRequest) :ServerResponse{
        sendForgotPinService.send()
        return ServerResponse
            .ok()
            .json()
            .bodyValueAndAwait(
                "Sent Forgot Pin !!!!"
            )
    }
}