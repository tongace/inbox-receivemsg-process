package com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.config.MessageStreamRepo
import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.entities.FaceBasicModel
import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.entities.FaceReflectModel
import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.entities.FormDataModel
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations
import com.example.lab.inbox.inboxreceivemsgprocess.utils.LoggerDelegate
import com.example.lab.inbox.inboxreceivemsgprocess.utils.toMessagePayload
import org.springframework.stereotype.Repository

@Repository
class SendRegisterExistingRepository(
    private val messageStreamRepo: MessageStreamRepo
) {
    private companion object {
        private val log by LoggerDelegate()
    }

    suspend fun sendForm(payload: FormDataModel): Boolean =
        messageStreamRepo.produceExistingRegisterForm()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_EXISTING_REGISTER_FORM_BINDER} -> payload: $payload")
            }

    suspend fun sendFaceReflect(payload: FaceReflectModel): Boolean =
        messageStreamRepo.produceExistingRegisterFaceReflect()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_EXISTING_REGISTER_FACE_REFLECT_BINDER} -> payload: $payload")
            }

    suspend fun sendFaceBasic(payload: FaceBasicModel): Boolean =
        messageStreamRepo.produceExistingRegisterFaceBasic()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_EXISTING_REGISTER_FACE_BASIC_BINDER} -> payload: $payload")
            }
}