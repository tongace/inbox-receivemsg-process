package com.example.lab.inbox.inboxreceivemsgprocess.data.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("MATCHING_REGISTER_NEW")
data class MatchingRegisterNew(
    @Id val id: String?,
    val customerId: String,
    val matchingId: String,
    val type: String,
    val status: Boolean,
    val createDate: LocalDateTime,
    val createBy: String
)