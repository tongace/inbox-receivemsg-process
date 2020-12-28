package com.example.lab.inbox.inboxreceivemsgprocess.data.redis.config

object RedisKeyBuilder {

    fun buildRegisterQualifyMatchingKey(
        flow: String,
        matchingId: String
    ) = "EKYC::REGISTRATION::QUALIFY::$flow::$matchingId"
}