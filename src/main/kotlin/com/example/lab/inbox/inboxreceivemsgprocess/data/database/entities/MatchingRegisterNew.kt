package com.example.lab.inbox.inboxreceivemsgprocess.data.database.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("MATCHING_REGISTER_NEW")
data class MatchingRegisterNew(
    @Id val id: String?,
    @Column("CUSTOMER_ID")
    val customerId: String,
    val matchingId: String,
    val type: String,
    val status: Boolean,
    val createDate: LocalDateTime,
    val createBy: String
)