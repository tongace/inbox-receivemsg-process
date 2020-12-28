package com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.config

import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.CONSUME_TEST
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.CONSUME_TEST2
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_CHANGE_DATA_DOPA_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_CHANGE_DATA_FACE_BASIC_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_CHANGE_DATA_FACE_REFLECT_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_CHANGE_DATA_FORM_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_EXISTING_REGISTER_FACE_BASIC_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_EXISTING_REGISTER_FACE_REFLECT_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_EXISTING_REGISTER_FORM_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_FORGOT_PIN_DOPA_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_FORGOT_PIN_FACE_BASIC_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_FORGOT_PIN_FACE_REFLECT_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_FORGOT_PIN_FORM_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_NEW_REGISTER_DOPA_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_NEW_REGISTER_FACE_BASIC_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_NEW_REGISTER_FACE_REFLECT_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_NEW_REGISTER_FORM_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_TEST
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_TEST2
import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.SubscribableChannel

interface MessageStreamRepo {
    @Output(PRODUCE_TEST)
    fun produceUserProfileResult(): SubscribableChannel
    @Output(PRODUCE_TEST2)
    fun produceTransFormedUserProfile(): SubscribableChannel
    @Input(CONSUME_TEST)
    fun consumeUserProfileResult(): SubscribableChannel
    @Input(CONSUME_TEST2)
    fun consumeTransFormedUserProfile(): SubscribableChannel



    @Output(PRODUCE_NEW_REGISTER_FORM_BINDER)
    fun produceNewRegisterForm(): SubscribableChannel
    @Output(PRODUCE_NEW_REGISTER_DOPA_BINDER)
    fun produceNewRegisterDopa(): SubscribableChannel
    @Output(PRODUCE_NEW_REGISTER_FACE_REFLECT_BINDER)
    fun produceNewRegisterFaceReflect(): SubscribableChannel
    @Output(PRODUCE_NEW_REGISTER_FACE_BASIC_BINDER)
    fun produceNewRegisterFaceBasic(): SubscribableChannel

    @Output(PRODUCE_EXISTING_REGISTER_FORM_BINDER)
    fun produceExistingRegisterForm(): SubscribableChannel
    @Output(PRODUCE_EXISTING_REGISTER_FACE_REFLECT_BINDER)
    fun produceExistingRegisterFaceReflect(): SubscribableChannel
    @Output(PRODUCE_EXISTING_REGISTER_FACE_BASIC_BINDER)
    fun produceExistingRegisterFaceBasic(): SubscribableChannel

    @Output(PRODUCE_CHANGE_DATA_FORM_BINDER)
    fun produceChangeDataForm(): SubscribableChannel
    @Output(PRODUCE_CHANGE_DATA_DOPA_BINDER)
    fun produceChangeDataDopa(): SubscribableChannel
    @Output(PRODUCE_CHANGE_DATA_FACE_REFLECT_BINDER)
    fun produceChangeDataFaceReflect(): SubscribableChannel
    @Output(PRODUCE_CHANGE_DATA_FACE_BASIC_BINDER)
    fun produceChangeDataFaceBasic(): SubscribableChannel

    @Output(PRODUCE_FORGOT_PIN_FORM_BINDER)
    fun produceForgotPinForm(): SubscribableChannel
    @Output(PRODUCE_FORGOT_PIN_DOPA_BINDER)
    fun produceForgotPinDopa(): SubscribableChannel
    @Output(PRODUCE_FORGOT_PIN_FACE_REFLECT_BINDER)
    fun produceForgotPinFaceReflect(): SubscribableChannel
    @Output(PRODUCE_FORGOT_PIN_FACE_BASIC_BINDER)
    fun produceForgotPinFaceBasic(): SubscribableChannel
}