package com.example.lab.inbox.inboxreceivemsgprocess.common

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.example.lab.inbox.inboxreceivemsgprocess.utils.KafkaRetryAbleException
import com.example.lab.inbox.inboxreceivemsgprocess.utils.PaotangSystemException
import com.example.lab.inbox.inboxreceivemsgprocess.utils.getLogger
import kotlinx.coroutines.runBlocking

open class BaseConsumer {

    private companion object {
        private val log = getLogger<BaseConsumer>()
    }

    fun <T, R> processConsumer(
        topicNameBinder: String,
        payload: T,
        process: suspend (T) -> R
    ): R? {
        log.info("$topicNameBinder : ${jacksonObjectMapper().writeValueAsString(payload)}")
        return try {
            runBlocking {
                return@runBlocking process(payload)
            }
        } catch (ex: KafkaRetryAbleException) {
            log.error("KafkaRetryAbleException from $topicNameBinder caused: ${ex.statusDesc}")
            throw ex
        } catch (ex: PaotangSystemException) {
            log.error("PaotangSystemException from $topicNameBinder caused: ${ex.statusDesc}")
            return null
        } catch (ex: Exception) {
            log.error("Exception from $topicNameBinder caused: ${ex.message}")
            return null
        }
    }
}