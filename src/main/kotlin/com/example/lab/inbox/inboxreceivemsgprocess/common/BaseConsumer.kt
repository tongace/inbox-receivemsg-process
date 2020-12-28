package com.example.lab.inbox.inboxreceivemsgprocess.common

import com.example.lab.inbox.inboxreceivemsgprocess.exceptions.NonRetryKafkaMessageException
import com.example.lab.inbox.inboxreceivemsgprocess.exceptions.RetryKafkaMessageException
import com.example.lab.inbox.inboxreceivemsgprocess.utils.GenerateUtil.generateStreamMsgRefId
import com.example.lab.inbox.inboxreceivemsgprocess.utils.GenerateUtil.generateUUID
import com.example.lab.inbox.inboxreceivemsgprocess.utils.LoggerDelegate
import kotlinx.coroutines.runBlocking

open class BaseConsumer {

    private companion object {
        private val log by LoggerDelegate()
    }

    fun <T> processConsumer(
        topicNameBinder: String,
        payload: T,
        referenceProcessId: String? = null,
        process: suspend (T) -> Unit
    ) {
        val refId = generateStreamMsgRefId(referenceProcessId ?: generateUUID())
        log.info("$topicNameBinder : $payload RefProcessId: $refId")
        try {
            runBlocking {
                process(payload)
                log.info("$topicNameBinder : RefProcessId: $refId Process done and committed")
            }
        } catch (ex: NonRetryKafkaMessageException) {
            log.warn("NonRetryKafkaMessageException from $topicNameBinder caused: ${ex.message} | RefProcessId: $refId is committed")
        } catch (ex: RetryKafkaMessageException) {
            log.error("RetryKafkaMessageException from $topicNameBinder caused: ${ex.message} | RefProcessId: $refId uncommitted")
            throw ex
        } catch (ex: Exception) {
            log.error("Exception from $topicNameBinder caused: ${ex.message} | RefProcessId: $refId")
            throw ex
        }
    }
}