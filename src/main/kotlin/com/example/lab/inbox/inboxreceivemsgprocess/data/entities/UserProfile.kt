package com.example.lab.inbox.inboxreceivemsgprocess.data.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Table("USER_PROFILE")
data class UserProfile(
    @Id var cifId: String,
    var consumerId: String,
    var consumerNameTh: String?,
    var consumerNameEn: String? = null,
    var consumerMobile: String,
    var identifier: String,
    var identifierType: String?,
    var customerHashId: String,
    var status: String,
    @Column("IS_ACTIVE")
    var active: String?,
    var createDate: LocalDateTime?,
    var createBy: String?,
    var updateDate: LocalDateTime?  = null,
    var updateBy: String?,
    var consumerLatitude: BigDecimal?,
    var consumerLongitude: BigDecimal?,
    var qrAliasName: String?  = null,
    var qrAmtLmtVerPin: BigDecimal?= null,
    var qrEnableAmtLmtVerPin: String?,
    var qrEnableAmtLmtPerDay: String?,
    var updateDesc: String?= null
)