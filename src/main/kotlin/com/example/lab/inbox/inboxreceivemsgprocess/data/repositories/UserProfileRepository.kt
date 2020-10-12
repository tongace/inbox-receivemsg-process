package com.example.lab.inbox.inboxreceivemsgprocess.data.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.data.entities.UserProfile
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.awaitFirstOrNull
import org.springframework.data.r2dbc.core.awaitOne
import org.springframework.data.r2dbc.core.from
import org.springframework.data.relational.core.query.Criteria
import org.springframework.stereotype.Repository

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
}