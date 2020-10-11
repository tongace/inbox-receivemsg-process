package com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.features.userdata

import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.common.BaseConsumer
import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.data.repositories.SendUserProfileToOthersRepository
import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.features.userdata.models.UserModel
import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.CONSUME_TEST
import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.CONSUME_TEST2
import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.utils.getLogger
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class ReceiveUserProfileFromOthersListener(
    private val messageStreamRepository: SendUserProfileToOthersRepository
):BaseConsumer(){
    private companion object {
        private val log = getLogger<ReceiveUserProfileFromOthersListener>()
    }
    @StreamListener(CONSUME_TEST)
    fun consumeUserDataFrom(@Payload payload: UserModel) {
        processConsumer(
            topicNameBinder = CONSUME_TEST,
            payload = payload
        ) {
            log.info("user model = $payload")
            val current = LocalDateTime.now()

            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
            val formatted = current.format(formatter)
            val transFormUser = UserModel(payload.consumerMobile,"${payload.consumerNameEn}  - $formatted")
            messageStreamRepository.transformUserProfileProducer(transFormUser)
        }
    }
    @StreamListener(CONSUME_TEST2)
    fun consumeTransformedserDataFrom(@Payload payload: UserModel) {
        processConsumer(
            topicNameBinder = CONSUME_TEST2,
            payload = payload
        ) {
            log.info("trasformed user model = $payload")
        }
    }
}