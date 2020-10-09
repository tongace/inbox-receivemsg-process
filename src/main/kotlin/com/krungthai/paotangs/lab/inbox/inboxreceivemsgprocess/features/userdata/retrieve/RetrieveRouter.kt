package com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.features.userdata.retrieve

import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.features.userdata.services.UserProfileService
import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.utils.getLogger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RetrieveRouter {

    @Bean
    fun retrieveUserProfileRoutes(retrieveHandler: RetrieveHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            POST("/retrieveUserWithMobile", retrieveHandler::retrieveUserProfileByMobileNoByPost)
            GET("/retrieveUserWithMobile/{mobileNo}",retrieveHandler::retrieveUserProfileByMobileNoByGet)
        }

    }
}