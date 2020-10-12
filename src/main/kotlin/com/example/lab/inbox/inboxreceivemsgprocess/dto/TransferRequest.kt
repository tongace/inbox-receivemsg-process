package com.example.lab.inbox.inboxreceivemsgprocess.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
data class TransferRequest<T>(
    val content: T
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class HeaderRequest(
    val reqID: String? = "",
    val reqChannel: String? = "",
    val reqDtm: String? = "",
    val reqBy: String? = "",
    val service: String? = "",
    val sofType: String? = "",
    val cardNo: String? = "",
    val ip: String? = "",
    val txnRefID: String? = ""
)

abstract class BaseRequestModel(
    open val appId: String = "",
    open val uuId: String = "",
    open val userId: String = ""
)