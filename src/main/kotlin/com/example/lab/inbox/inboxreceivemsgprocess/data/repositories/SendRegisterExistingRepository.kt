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
class SendRegisterExistingRepository (
    private val messageStreamRepository: MessageStreamRepository
){
    private companion object {
        private val log = getLogger<SendRegisterNewRepository>()
    }
    suspend fun sendForm(payload: FormDataModel): Boolean=
        messageStreamRepository.produceExistingRegisterForm()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_EXISTING_REGISTER_FORM_BINDER} -> payload: $payload")
            }
    suspend fun sendFaceReflect(payload: FaceReflectModel): Boolean=
        messageStreamRepository.produceExistingRegisterFaceReflect()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_EXISTING_REGISTER_FACE_REFLECT_BINDER} -> payload: $payload")
            }
    suspend fun sendFaceBasic(payload: FaceBasicModel): Boolean=
        messageStreamRepository.produceExistingRegisterFaceBasic()
            .send(payload.toMessagePayload())
            .also {
                log.info("Produce: ${KafkaDestinations.PRODUCE_EXISTING_REGISTER_FACE_BASIC_BINDER} -> payload: $payload")
            }
}