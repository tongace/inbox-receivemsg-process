package com.example.lab.inbox.inboxreceivemsgprocess.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TransferResponse<T>(
    val content: T
)

data class HeaderResponse(
    var reqID: String,
    var reqDtm: String,
    var txnRefID: String? = null,
    var service: String,
    var statusCd: String,
    var statusDesc: String
)