package com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.config

import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.config.ListenerContainerCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.listener.AbstractMessageListenerContainer
import org.springframework.kafka.listener.SeekToCurrentErrorHandler

@EnableBinding(MessageStreamRepo::class)
@Configuration
internal class MessageStreamConfig {
    @Bean
    fun listenerContainerCustomizer() =
        ListenerContainerCustomizer<AbstractMessageListenerContainer<*, *>> { container, _, _ ->
            container.setErrorHandler(
                SeekToCurrentErrorHandler().apply {
                    isAckAfterHandle = false
                }
            )
        }
}