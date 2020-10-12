package com.example.lab.inbox.inboxreceivemsgprocess.utils

import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.example.lab.inbox.inboxreceivemsgprocess.dto.HeaderRequest
import com.example.lab.inbox.inboxreceivemsgprocess.dto.HeaderResponse
import com.example.lab.inbox.inboxreceivemsgprocess.dto.ResponseStatus
import com.example.lab.inbox.inboxreceivemsgprocess.dto.TransferResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json
import java.math.BigDecimal
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

inline fun <reified T : Any> getLogger(): Logger = LoggerFactory.getLogger(T::class.java)

inline fun <T : Any> T?.ifNull(func: () -> Unit) {
    if (this == null) func()
}

inline fun Boolean.ifIsFalse(func: () -> Unit) {
    if (!this) func()
}

inline fun Boolean.ifIsTrue(func: () -> Unit) {
    if (this) func()
}

fun Map<*, *>?.getStringOrDefault(key: String, defaultValue: String) =
    this?.getOrDefault(key, defaultValue)?.toString() ?: defaultValue

fun String?.stringDefault(defaultValue: String): String =
    if (this.isNullOrEmpty()) defaultValue else this

inline fun String?.ifNotNullAndNotEmpty(block: (String) -> Unit) {
    val notNull = this ?: ""
    if (notNull.isNotEmpty()) {
        block(notNull)
    }
}

fun String?.isNotNullAndNotBlank() = !this.isNullOrBlank()

inline fun <reified T : Any> String?.mapJsonStringTo(crossinline block: (T) -> Unit): T {
    val clazz = jacksonObjectMapper().readValue(this, T::class.java)
    block(clazz)
    return clazz
}

fun BigDecimal?.orZero(): BigDecimal = this ?: BigDecimal.ZERO

inline fun <T : Any> ObjectNode.mapObjectNodeTo(mapper: (ObjectNode) -> T): T = mapper(this)

inline fun CharSequence?.whenNullOrBlank(block: () -> Unit) {
    if (this.isNullOrBlank()) block()
}

inline fun anyStringNullOrBlank(vararg elements: String?, block: () -> Unit) {
    if (elements.any { it.isNullOrBlank() }) {
        block()
    }
}

fun Any.toJsonString(): String = jacksonObjectMapper().writeValueAsString(this)

suspend inline fun <T> transferResponseSuccess(response: T) =
    ServerResponse
        .ok()
        .json()
        .bodyValueAndAwait(
            TransferResponse(
                response
            )
        )

suspend inline fun <T> transferResponseSuccess(headerResponse: HeaderResponse, response: T) =
    ServerResponse
        .ok()
        .json()
        .bodyValueAndAwait(
            TransferResponse(
                response
            )
        )

fun buildHeaderResponse(
    headerRequest: HeaderRequest,
    responseStatus: ResponseStatus = ResponseStatus.SUCCESS
) = HeaderResponse(
    reqDtm = headerRequest.reqDtm.orEmpty(),
    reqID = headerRequest.reqID.orEmpty(),
    service = headerRequest.service.orEmpty(),
    statusCd = responseStatus.code,
    statusDesc = responseStatus.desc,
    txnRefID = headerRequest.txnRefID.orEmpty()
)

fun Long.parseTimeStampToLocalDateTime(): LocalDateTime =
    LocalDateTime.ofInstant(
        Instant.ofEpochMilli(this),
        TimeZone.getDefault().toZoneId()
    )

suspend inline fun responseSuccess(response: Any) =
    ServerResponse
        .ok()
        .json()
        .bodyValueAndAwait(response)

fun <T : Any> T.toMessagePayload() = this.let {
    MessageBuilder
        .createMessage(
            it,
            MessageHeaders(
                Collections.singletonMap<String, Any>(
                    MessageHeaders.CONTENT_TYPE,
                    MediaType.APPLICATION_JSON_VALUE
                )
            )
        )
}

data class PaotangSystemException(var statusDesc: String) : RuntimeException()

data class KafkaRetryAbleException(var statusDesc: String) : RuntimeException()