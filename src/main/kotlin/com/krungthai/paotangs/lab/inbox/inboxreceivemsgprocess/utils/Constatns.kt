package com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.utils

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
}