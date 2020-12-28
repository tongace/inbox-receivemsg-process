package com.example.lab.inbox.inboxreceivemsgprocess.data.database.repositories

import com.example.lab.inbox.inboxreceivemsgprocess.data.database.entities.MatchingRegisterNew
import org.springframework.data.domain.Sort
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.await
import org.springframework.data.r2dbc.core.from
import org.springframework.data.r2dbc.core.into
import org.springframework.data.relational.core.query.Criteria
import org.springframework.stereotype.Repository

@Repository
class MatchingRegisterNewRepository(
    private val databaseClient: DatabaseClient
) {
    suspend fun insertMatchingRegisterNew(
        matchingRegisterNew: MatchingRegisterNew
    ) {
        databaseClient.insert()
            .into<MatchingRegisterNew>()
            .using(matchingRegisterNew)
            .await()
    }

    suspend fun findByCustomerIdAndMatchingId(customerId: String, matchingId: String) =
        databaseClient.select()
            .from<MatchingRegisterNew>()
            .matching(
                Criteria.where(MatchingRegisterNew::customerId.name).`is`(customerId)
                    .and(MatchingRegisterNew::matchingId.name).`is`(matchingId)
            )
            .orderBy(
                Sort.Order.asc(MatchingRegisterNew::createDate.name)
            )
            .fetch()
            .all()

}