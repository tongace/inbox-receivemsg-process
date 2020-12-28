package com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.retrieve

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RetrieveRouter {

    @Bean
    fun retrieveUserProfileRoutes(retrieveHandler: RetrieveHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            POST("/user/profile/", retrieveHandler::retrieveUserProfileByMobileNoByPost)
            GET("/user/profile/{mobileNo}", retrieveHandler::retrieveUserProfileByMobileNoByGet)
        }

    }
}