package com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserModel(
    val consumerMobile: String,
    val consumerNameEn: String?
)