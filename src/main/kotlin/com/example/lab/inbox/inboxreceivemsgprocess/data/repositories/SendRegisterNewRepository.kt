package com.example.lab.inbox.inboxreceivemsgprocess.data.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.features.qualifications.model.DopaModel
import com.example.lab.inbox.inboxreceivemsgprocess.features.qualifications.model.FaceBasicModel
import com.example.lab.inbox.inboxreceivemsgprocess.features.qualifications.model.FaceReflectModel
import com.example.lab.inbox.inboxreceivemsgprocess.features.qualifications.model.FormDataModel
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations
import com.example.lab.inbox.inboxreceivemsgprocess.utils.getLogger
import com.example.lab.inbox.inboxreceivemsgprocess.utils.toMessagePayload
import org.springframework.stereotype.Repository

@Repository
class SendRegisterNewRepository(
    private val messageStreamRepository: MessageStreamRepository
){
    private companion object {
        private val log = getLogger<SendRegisterNewRepository>()
    }
    suspend fun sendNewRegisterForm(payload: FormDataModel): Boolean=
        messageStreamRepository.produceNewRegisterForm()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_NEW_REGISTER_FORM_BINDER} -> payload: $payload")
            }
    suspend fun sendNewRegisterDopa(payload: DopaModel): Boolean=
        messageStreamRepository.produceNewRegisterDopa()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_NEW_REGISTER_DOPA_BINDER} -> payload: $payload")
            }
    suspend fun sendNewRegisterFaceReflect(payload: FaceReflectModel): Boolean=
        messageStreamRepository.produceNewRegisterFaceReflect()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_NEW_REGISTER_FACE_REFLECT_BINDER} -> payload: $payload")
            }
    suspend fun sendNewRegisterFaceBasic(payload: FaceBasicModel): Boolean=
        messageStreamRepository.produceNewRegisterFaceBasic()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_NEW_REGISTER_FACE_BASIC_BINDER} -> payload: $payload")
            }
}