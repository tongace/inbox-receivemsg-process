package com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.retrieve

import com.example.lab.inbox.inboxreceivemsgprocess.data.entities.UserProfile
import com.example.lab.inbox.inboxreceivemsgprocess.dto.TransferRequest
import com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.models.UserModel
import com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.services.UserProfileService
import com.example.lab.inbox.inboxreceivemsgprocess.utils.getLogger
import com.example.lab.inbox.inboxreceivemsgprocess.utils.transferResponseSuccess
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class RetrieveHandler(
    private val userProfileService: UserProfileService
){
    suspend fun retrieveUserProfileByMobileNoByPost(request: ServerRequest) =
        request.awaitBody<TransferRequest<UserModel>>().let {
            transferResponseSuccess(
                userProfileService.findUserByMobileNo(it.content.consumerMobile)
            )}
    suspend fun retrieveUserProfileByMobileNoByGet(request: ServerRequest)=
        request.pathVariable("mobileNo").let{
            transferResponseSuccess(
                userProfileService.findUserData(it)
            )}
}