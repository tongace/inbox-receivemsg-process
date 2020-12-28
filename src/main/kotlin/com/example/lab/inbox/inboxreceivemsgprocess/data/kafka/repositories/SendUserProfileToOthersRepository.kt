package com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.config.MessageStreamRepo
import com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.models.UserModel
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations
import com.example.lab.inbox.inboxreceivemsgprocess.utils.LoggerDelegate
import com.example.lab.inbox.inboxreceivemsgprocess.utils.toMessagePayload
import org.springframework.stereotype.Repository

@Repository
class SendUserProfileToOthersRepository(
    private val messageStreamRepo: MessageStreamRepo
) {
    private companion object {
        private val log by LoggerDelegate()
    }

    suspend fun userProfileProducer(payload: UserModel): Boolean =
        messageStreamRepo.produceUserProfileResult()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_TEST} -> payload: $payload")
            }

    suspend fun transformUserProfileProducer(payload: UserModel): Boolean =
        messageStreamRepo.produceTransFormedUserProfile()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_TEST2} -> payload: $payload")
            }

}