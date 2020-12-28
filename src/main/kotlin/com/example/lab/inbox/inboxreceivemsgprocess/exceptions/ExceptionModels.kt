package com.example.lab.inbox.inboxreceivemsgprocess.exceptions

import com.example.lab.inbox.inboxreceivemsgprocess.utils.ErrorCode.SYSTEM_ERROR


data class RetryKafkaMessageException(override var message: String) : RuntimeException()

data class NonRetryKafkaMessageException(override var message: String) : RuntimeException()

class ClientException : RuntimeException {
    var statusCd: String = ""
    var statusDesc: String = ""

    constructor() : super() {
        this.statusCd = SYSTEM_ERROR
        this.statusDesc = message.orEmpty()
    }

    constructor(statusDesc: String) : this() {
        this.statusCd = SYSTEM_ERROR
        this.statusDesc = statusDesc
    }

    constructor(statusCd: String, statusDesc: String) : this() {
        this.statusCd = statusCd
        this.statusDesc = statusDesc
    }
}

