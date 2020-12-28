package com.example.lab.inbox.inboxreceivemsgprocess.data.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.data.config.*
import com.example.lab.inbox.inboxreceivemsgprocess.data.entities.MatchingRegisterInfo
import com.example.lab.inbox.inboxreceivemsgprocess.properties.RedisConfigProperty
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.stereotype.Repository

@Repository
class MatchingRegisterRepository(
    redisFactory: ReactiveRedisConnectionFactory,
    private val redisConfigProperty: RedisConfigProperty
) {
    private val matchingRegsiterInfoTemplate = redisFactory.buildReactiveRedisTemplate<MatchingRegisterInfo>()

    suspend fun getMatchingRegisterInfos(
        flowType: String,
        matchingId: String,
        customerId: String
    ): List<MatchingRegisterInfo> {
        val matchingRegisterInfoList = mutableListOf<MatchingRegisterInfo>()
        matchingRegsiterInfoTemplate.getData(
            RedisKeyBuilder.buildRegisterQualifyMatchingKey(
                flowType,
                matchingId
            )
        )?.run {
            matchingRegisterInfoList.add(this)
        }
        matchingRegsiterInfoTemplate.getData(
            RedisKeyBuilder.buildRegisterQualifyMatchingKey(
                flowType,
                matchingId
            )
        )?.run {
            matchingRegisterInfoList.add(this)
        }
        matchingRegsiterInfoTemplate.getData(
            RedisKeyBuilder.buildRegisterQualifyMatchingKey(
                flowType,
                matchingId
            )
        )?.run {
            matchingRegisterInfoList.add(this)
        }
        matchingRegsiterInfoTemplate.getData(
            RedisKeyBuilder.buildRegisterQualifyMatchingKey(
                flowType,
                matchingId
            )
        )?.run {
            matchingRegisterInfoList.add(this)
        }
        return matchingRegisterInfoList.sortedWith(compareBy({ it.createDate }, { it.type }))
    }

    suspend fun putMatchingRegisterInfo(
        flowType: String,
        matchingId: String,
        customerId: String,
        matchingType: String,
        matchingRegisterInfo: MatchingRegisterInfo
    ) {
        matchingRegsiterInfoTemplate.putDataWithDuration(
            RedisKeyBuilder.buildRegisterQualifyMatchingKey(
                flowType,
                matchingId
            ),
            matchingRegisterInfo,
            redisConfigProperty.expireTimes.qualificationMatching
        )
    }

    suspend fun deleteMatchingRegisterInfos(
        flowType: String,
        matchingId: String,
        customerId: String
    ) {
        matchingRegsiterInfoTemplate.removeByKey(
            RedisKeyBuilder.buildRegisterQualifyMatchingKey(
                flowType,
                matchingId
            )
        )
        matchingRegsiterInfoTemplate.removeByKey(
            RedisKeyBuilder.buildRegisterQualifyMatchingKey(
                flowType,
                matchingId
            )
        )
        matchingRegsiterInfoTemplate.removeByKey(
            RedisKeyBuilder.buildRegisterQualifyMatchingKey(
                flowType,
                matchingId,
            )
        )
        matchingRegsiterInfoTemplate.removeByKey(
            RedisKeyBuilder.buildRegisterQualifyMatchingKey(
                flowType,
                matchingId
            )
        )
    }
}