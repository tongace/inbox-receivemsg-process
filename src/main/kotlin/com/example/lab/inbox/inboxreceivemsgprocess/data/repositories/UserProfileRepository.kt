package com.example.lab.inbox.inboxreceivemsgprocess.data.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.data.entities.UserProfile
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactive.awaitLast
import org.springframework.data.domain.Sort
import org.springframework.data.r2dbc.core.*
import org.springframework.data.relational.core.query.Criteria
import org.springframework.stereotype.Repository
import reactor.kotlin.core.publisher.toMono

@Repository
class UserProfileRepository(
    private val databaseClient:DatabaseClient
){
    suspend fun findByConsumerMobileNumber(mobile: String) =
        databaseClient.select()
            .from<UserProfile>()
            .matching(
                Criteria.where(UserProfile::consumerMobile.name).`is`(mobile)
            ).fetch()
            .awaitOne()
    suspend fun findAllUserProfile() =
        databaseClient.select()
            .from<UserProfile>()
            .orderBy(
                Sort.Order.asc(UserProfile::createDate.name)
            )
            .fetch()
            .all()
}