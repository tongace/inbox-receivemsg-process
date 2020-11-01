package com.example.lab.inbox.inboxreceivemsgprocess.data.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.data.entities.UserProfile
import org.springframework.data.domain.Sort
import org.springframework.data.r2dbc.core.*
import org.springframework.data.relational.core.query.Criteria
import org.springframework.stereotype.Repository
import kotlin.reflect.full.instanceParameter

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
            .awaitFirstOrNull()
    suspend fun findByConsumerIdentifier(identifier: String) =
        databaseClient.select()
            .from<UserProfile>()
            .matching(
                Criteria.where(UserProfile::identifier.name).`is`(identifier)
            ).fetch()
            .awaitFirstOrNull()
    suspend fun findAllUserProfile() =
        databaseClient.select()
            .from<UserProfile>()
            .orderBy(
                Sort.Order.asc(UserProfile::createDate.name)
            )
            .fetch()
            .all()
    suspend fun updateUserProfile(userProfile: UserProfile) =
        databaseClient.update()
            .table<UserProfile>()
            .using(userProfile)
            .fetch()
            .awaitRowsUpdated()
    suspend fun insertUserProfile(userProfile: UserProfile) =
        databaseClient.insert()
            .into<UserProfile>()
            .using(userProfile)
            .await()

    suspend fun updateUserProfileByMobileNo(userProfile: UserProfile) =
        databaseClient.update()
            .table<UserProfile>()
            .using(userProfile)
            .matching(
                Criteria.where("CONSUMER_MOBILE").`is`(userProfile.consumerMobile)
            )
            .fetch()
            .awaitRowsUpdated()
}