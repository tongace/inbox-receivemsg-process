package com.example.lab.inbox.inboxreceivemsgprocess.data.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.CONSUME_TEST
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.CONSUME_TEST2
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_NEW_REGISTER_DOPA_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_NEW_REGISTER_FACE_BASIC_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_NEW_REGISTER_FACE_REFLECT_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_NEW_REGISTER_FORM_BINDER
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_TEST
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaDestinations.PRODUCE_TEST2
import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.SubscribableChannel

interface MessageStreamRepository {
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

}