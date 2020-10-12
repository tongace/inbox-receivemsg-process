package com.example.lab.inbox.inboxreceivemsgprocess.data.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.models.UserModel
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations
import com.example.lab.inbox.inboxreceivemsgprocess.utils.getLogger
import com.example.lab.inbox.inboxreceivemsgprocess.utils.toMessagePayload
import org.springframework.stereotype.Repository

@Repository
class SendUserProfileToOthersRepository (
    private val messageStreamRepository: MessageStreamRepository
){
    private companion object {
        private val log = getLogger<SendUserProfileToOthersRepository>()
    }
    suspend fun userProfileProducer(payload: UserModel): Boolean=
        messageStreamRepository.produceUserProfileResult()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_TEST} -> payload: $payload")
            }
    suspend fun transformUserProfileProducer(payload: UserModel): Boolean=
        messageStreamRepository.produceTransFormedUserProfile()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_TEST2} -> payload: $payload")
            }

}