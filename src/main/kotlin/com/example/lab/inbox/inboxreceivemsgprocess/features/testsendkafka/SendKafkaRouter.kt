package com.example.lab.inbox.inboxreceivemsgprocess.features.testsendkafka

import com.example.lab.inbox.inboxreceivemsgprocess.features.test.TestHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter


@Configuration
class SendKafkaRouter{
    @Bean
    fun testSendKafka(sendHandler: SendKafkaHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/new",sendHandler::sendRegisterNew)
            GET("/existing",sendHandler::sendRegisterExisting)
            GET("/change",sendHandler::sendChangeData)
            GET("/forgot",sendHandler::sendForgotPin)
        }
    }
}
