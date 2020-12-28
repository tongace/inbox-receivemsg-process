package com.example.lab.inbox.inboxreceivemsgprocess.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.time.Duration

@ConstructorBinding
@ConfigurationProperties(prefix = "redis-config")
data class RedisConfigProperty(
    val expireTimes: ExpireTimes
) {
    data class ExpireTimes(
        val qualificationMatching: Duration
    )
}