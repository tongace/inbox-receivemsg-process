package com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.config.MessageStreamRepo
import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.entities.DopaModel
import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.entities.FaceBasicModel
import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.entities.FaceReflectModel
import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.entities.FormDataModel
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations
import com.example.lab.inbox.inboxreceivemsgprocess.utils.LoggerDelegate
import com.example.lab.inbox.inboxreceivemsgprocess.utils.toMessagePayload
import org.springframework.stereotype.Repository

@Repository
class SendRegisterNewRepository(
    private val messageStreamRepo: MessageStreamRepo
) {
    private companion object {
        private val log by LoggerDelegate()
    }

    suspend fun sendForm(payload: FormDataModel): Boolean =
        messageStreamRepo.produceNewRegisterForm()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_NEW_REGISTER_FORM_BINDER} -> payload: $payload")
            }

    suspend fun sendDopa(payload: DopaModel): Boolean =
        messageStreamRepo.produceNewRegisterDopa()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_NEW_REGISTER_DOPA_BINDER} -> payload: $payload")
            }

    suspend fun sendFaceReflect(payload: FaceReflectModel): Boolean =
        messageStreamRepo.produceNewRegisterFaceReflect()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_NEW_REGISTER_FACE_REFLECT_BINDER} -> payload: $payload")
            }

    suspend fun sendFaceBasic(payload: FaceBasicModel): Boolean =
        messageStreamRepo.produceNewRegisterFaceBasic()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_NEW_REGISTER_FACE_BASIC_BINDER} -> payload: $payload")
            }
}