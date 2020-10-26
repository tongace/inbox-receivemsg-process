package com.example.lab.inbox.inboxreceivemsgprocess.features.test

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class TestRouter {
    @Bean
    fun test(testHandler: TestHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/test",testHandler::test)
            GET("/find/{identifier}",testHandler::findAll)
            GET("/update/{identifier}/{mobileNo}",testHandler::update)
            POST("/matching",testHandler::createMatching)
        }
    }
}
