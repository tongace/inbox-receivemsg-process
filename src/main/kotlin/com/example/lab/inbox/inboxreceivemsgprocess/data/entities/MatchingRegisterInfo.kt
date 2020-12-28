package com.example.lab.inbox.inboxreceivemsgprocess.data.entities

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.time.LocalDateTime

data class MatchingRegisterInfo(
    val customerId: String,
    val matchingId: String,
    var type: String,
    val result: Boolean,
    val status: String,
    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    @JsonSerialize(using = LocalDateTimeSerializer::class)
    val createDate: LocalDateTime = LocalDateTime.now()
)