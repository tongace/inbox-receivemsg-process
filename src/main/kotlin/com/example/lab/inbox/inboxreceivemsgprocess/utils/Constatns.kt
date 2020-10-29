package com.example.lab.inbox.inboxreceivemsgprocess.utils

object Constants {
    const val SCHEMA_SQL_PATH = "db/schema.sql"
    const val DATA_SQL_PATH = "db/data.sql"

    const val REGISTERED = "REGISTERED"
    const val STATE_REGISTERED = "PROCESSING:REGISTERED"
    const val STATE_CHANGE_DATA = "PROCESSING:SETUP_PIN_CHANGE_DATA"
    const val STATE_NO_REGISTER = "NO_REGISTER"
    const val EKYC_REQ_CHANNEL = "EKYC"
    const val EKYC_REGISTRATION_SOF_TYPE = "KYC"

    const val PDPA_STATUS_SUCCESS = "0000"
    const val DOPA_CODE_SUCCESS = 0
    const val FACE_CODE_SUCCESS = "0000"
    const val IS_SUCCESS = true

    const val IS_ACTIVE = "Y"
    const val TOKEN_ENABLE = "Y"
    const val DISABLE = "N"
}

object KafkaDestinations {
    const val CONSUME_TEST = "InboxReceiveMessageConsume"
    const val PRODUCE_TEST = "InboxReceiveMessageProduce"
    const val CONSUME_TEST2 = "InboxReceiveMessageTransFormConsume"
    const val PRODUCE_TEST2 = "InboxReceiveMessageTransformProduce"

    const val PRODUCE_NEW_REGISTER_FORM_BINDER = "NewRegisterFormProduce"
    const val PRODUCE_NEW_REGISTER_DOPA_BINDER = "NewRegisterDopaProduce"
    const val PRODUCE_NEW_REGISTER_FACE_REFLECT_BINDER = "NewRegisterFaceReflectProduce"
    const val PRODUCE_NEW_REGISTER_FACE_BASIC_BINDER = "NewRegisterFaceBasicProduce"

    const val PRODUCE_EXISTING_REGISTER_FORM_BINDER = "ExistingRegisterFormProduce"
    const val PRODUCE_EXISTING_REGISTER_FACE_REFLECT_BINDER = "ExistingRegisterFaceReflectProduce"
    const val PRODUCE_EXISTING_REGISTER_FACE_BASIC_BINDER = "ExistingRegisterFaceBasicProduce"

    const val PRODUCE_CHANGE_DATA_FORM_BINDER = "ChangeDataRegisterFormProduce"
    const val PRODUCE_CHANGE_DATA_DOPA_BINDER = "ChangeDataRegisterDopaProduce"
    const val PRODUCE_CHANGE_DATA_FACE_REFLECT_BINDER = "ChangeDataRegisterFaceReflectProduce"
    const val PRODUCE_CHANGE_DATA_FACE_BASIC_BINDER = "ChangeDataRegisterFaceBasicProduce"

    const val PRODUCE_FORGOT_PIN_FORM_BINDER = "ForgetPinFormProduce"
    const val PRODUCE_FORGOT_PIN_DOPA_BINDER = "ForgetPinDopaProduce"
    const val PRODUCE_FORGOT_PIN_FACE_REFLECT_BINDER = "ForgetPinFaceReflectProduce"
    const val PRODUCE_FORGOT_PIN_FACE_BASIC_BINDER = "ForgetPinFaceBasicProduce"
}