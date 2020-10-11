package com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.config

import com.krungthai.paotangs.lab.inbox.inboxreceivemsgprocess.data.repositories.MessageStreamRepository
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.context.annotation.Configuration

@EnableBinding(MessageStreamRepository::class)
@Configuration
internal class MessageStreamConfig