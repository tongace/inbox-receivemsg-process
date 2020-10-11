package com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.config

import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfiguration {
    @Bean
    fun redisObjectNodeTemplate(factory: ReactiveRedisConnectionFactory) =
        createReactiveRedisTemplate<ObjectNode>(factory)


    private inline fun <reified T> createReactiveRedisTemplate(factory: ReactiveRedisConnectionFactory) =
        ReactiveRedisTemplate(
            factory,
            RedisSerializationContext.newSerializationContext<String, T>(
                StringRedisSerializer()
            ).value(
                Jackson2JsonRedisSerializer(T::class.java).apply {
                    setObjectMapper(jacksonObjectMapper())
                }
            ).build()
        )
}