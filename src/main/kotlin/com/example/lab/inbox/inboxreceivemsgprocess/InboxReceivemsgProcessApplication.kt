package com.example.lab.inbox.inboxreceivemsgprocess

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class InboxReceivemsgProcessApplication

fun main(args: Array<String>) {
	runApplication<InboxReceivemsgProcessApplication>(*args)
}
