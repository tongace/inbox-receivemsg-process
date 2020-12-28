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
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.companionObject

class LoggerDelegate<in R : Any> : ReadOnlyProperty<R, Logger> {
    override fun getValue(thisRef: R, property: KProperty<*>): Logger =
        LoggerFactory.getLogger(getClassForLogging(thisRef.javaClass))
}

fun <T : Any> getClassForLogging(javaClass: Class<T>): Class<*> {
    return javaClass.enclosingClass?.takeIf {
        it.kotlin.companionObject?.java == javaClass
    } ?: javaClass
}




inline fun <reified T : Any> String?.mapJsonStringTo(crossinline block: (T) -> Unit): T {
    val clazz = jacksonObjectMapper().readValue(this, T::class.java)
    block(clazz)
    return clazz
}

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

data class ExampleSystemException(var statusDesc: String) : RuntimeException()
