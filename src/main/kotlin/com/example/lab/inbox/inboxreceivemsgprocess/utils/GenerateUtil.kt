package com.example.lab.inbox.inboxreceivemsgprocess.utils

import net.logstash.logback.encoder.org.apache.commons.lang3.StringUtils
import java.security.SecureRandom
import java.time.Clock
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object GenerateUtil {
    fun generateSecretUniqueId() =
        System.currentTimeMillis().toString() +
                StringUtils.leftPad(
                    SecureRandom().nextInt(999999999).toString(),
                    9,
                    '0'
                )

    fun generateUUID() = UUID.randomUUID().toString()

    fun generateNowTimeStamp() = Clock.systemDefaultZone().millis()

    fun generateNowDateTimeWithFormat(format: String): String =
        LocalDateTime.now().format(DateTimeFormatter.ofPattern(format))

    fun generateStreamMsgRefId(refKey: String) = "$refKey::${generateNowTimeStamp()}"

    fun generateClientRequestId() =
        "PT-${UUID.randomUUID().toString().replace("-", "")}"
}