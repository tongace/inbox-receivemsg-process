package com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class MatchingRegisterNewModel(
    val customerId: String,
    val matchingId: String,
    val type: String,
    val status: Boolean
)