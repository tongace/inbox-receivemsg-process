package com.example.lab.inbox.inboxreceivemsgprocess.data.entities

import jdk.jfr.Name
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Table("USER_PROFILE")
data class UserProfile(
    @Id val cifId: String,
    val consumerId: String,
    val consumerNameTh: String?,
    val consumerNameEn: String? = null,
    val consumerMobile: String,
    val identifier: String,
    val identifierType: String?,
    val customerHashId: String,
    val status: String,
    @Column("IS_ACTIVE")
    val active: String?,
    val createDate: LocalDateTime?,
    val createBy: String?,
    val updateDate: LocalDateTime?  = null,
    val updateBy: String?,
    val consumerLatitude: BigDecimal?,
    val consumerLongitude: BigDecimal?,
    val qrAliasName: String?  = null,
    val qrAmtLmtVerPin: BigDecimal?= null,
    val qrEnableAmtLmtVerPin: String?,
    val qrEnableAmtLmtPerDay: String?,
    val updateDesc: String?= null
)