package com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.retrieve

import com.example.lab.inbox.inboxreceivemsgprocess.dto.TransferRequest
import com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.models.UserModel
import com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.services.UserProfileService
import com.example.lab.inbox.inboxreceivemsgprocess.utils.transferResponseSuccess
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.awaitBody

@Component
class RetrieveHandler(
    private val userProfileService: UserProfileService
){
    suspend fun retrieveUserProfileByMobileNoByPost(request: ServerRequest) =
        transferResponseSuccess(
            userProfileService.findUserByMobileNo(request.awaitBody<TransferRequest<UserModel>>().content.consumerMobile)
        )
    suspend fun retrieveUserProfileByMobileNoByGet(request: ServerRequest)=
        transferResponseSuccess(
            userProfileService.findUserData(request.pathVariable("mobileNo"))
        )
}