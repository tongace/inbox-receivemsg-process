package com.example.lab.inbox.inboxreceivemsgprocess.data.redis.config

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.*
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.time.Duration

inline fun <reified T> ReactiveRedisConnectionFactory.buildReactiveRedisTemplate(): ReactiveRedisTemplate<String, T> =
    Jackson2JsonRedisSerializer(T::class.java).apply {
        setObjectMapper(
            jacksonObjectMapper()
                .registerModule(JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        )
    }.let {
        ReactiveRedisTemplate(
            this,
            RedisSerializationContext.newSerializationContext<String, T>(
                StringRedisSerializer()
            ).value(it).hashValue(it).build()
        )
    }

suspend inline fun <reified V> ReactiveRedisTemplate<String, V>.removeByKey(key: String) =
    this.opsForValue().delete(key).awaitFirstOrNull()

suspend inline fun <reified V : Any> ReactiveRedisTemplate<String, V>.getData(key: String) =
    this.opsForValue().getAndAwait(key)

suspend inline fun <reified V : Any> ReactiveRedisTemplate<String, V>.getMultiData(key: String) =
    this.opsForValue().multiGetAndAwait(key)

suspend inline fun <reified V : Any> ReactiveRedisTemplate<String, V>.putDataWithDuration(
    key: String,
    data: V,
    duration: Duration?
) = this.opsForValue().setAndAwait(key, data, duration ?: Duration.ofMinutes(1))

suspend inline fun <reified V : Any> ReactiveRedisTemplate<String, V>.putData(
    key: String,
    data: V
) = this.opsForValue().setAndAwait(key, data)

suspend inline fun <reified V : Any> ReactiveRedisTemplate<String, V>.putMultiData(mapMultiData: Map<String, V>) =
    this.opsForValue().multiSetAndAwait(mapMultiData)

inline fun <reified V : Any> ReactiveRedisTemplate<String, V>.scanKey(
    key: String,
    count: Long = 1000L
) = this.scanAsFlow(
    ScanOptions.ScanOptionsBuilder()
        .count(count)
        .match(key)
        .build()
)

suspend inline fun <reified V : Any> ReactiveRedisTemplate<String, V>.increment(key: String) =
    this.opsForValue().incrementAndAwait(key)

suspend inline fun <reified V : Any> ReactiveRedisTemplate<String, V>.decrement(key: String) =
    this.opsForValue().decrementAndAwait(key)

suspend inline fun <reified RedisObjType : Any, reified HashValueType : Any> ReactiveRedisTemplate<String, RedisObjType>.incrementHashKey(
    redisKey: String,
    hashKey: String,
    increaseValue: Long
) = this.opsForHash<String, HashValueType>().incrementAndAwait(redisKey, hashKey, increaseValue)

suspend inline fun <reified RedisObjType : Any, reified HashValueType : Any> ReactiveRedisTemplate<String, RedisObjType>.getHashData(
    redisKey: String,
    hashKey: String
) = this.opsForHash<String, HashValueType>().getAndAwait(redisKey, hashKey)

suspend inline fun <reified RedisObjType : Any, reified HashValueType : Any> ReactiveRedisTemplate<String, RedisObjType>.putAllHashData(
    redisKey: String,
    hashMapValue: Map<String, HashValueType>
) = this.opsForHash<String, HashValueType>().putAllAndAwait(redisKey, hashMapValue)

suspend inline fun <reified RedisObjType : Any, reified HashValueType : Any> ReactiveRedisTemplate<String, RedisObjType>.putHashData(
    redisKey: String,
    hashKey: String,
    hashValue: HashValueType
) = this.opsForHash<String, HashValueType>().putAndAwait(redisKey, hashKey, hashValue)

suspend inline fun <reified RedisObjType : Any, reified HashValueType : Any> ReactiveRedisTemplate<String, RedisObjType>.getHashSize(
    redisKey: String
) = this.opsForHash<String, HashValueType>().sizeAndAwait(redisKey)