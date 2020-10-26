package com.example.lab.inbox.inboxreceivemsgprocess.features.test.services

import com.example.lab.inbox.inboxreceivemsgprocess.data.entities.MatchingRegisterNew
import com.example.lab.inbox.inboxreceivemsgprocess.data.repositories.MatchingRegisterNewRepository
import com.example.lab.inbox.inboxreceivemsgprocess.features.test.TestHandler
import com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.models.MatchingRegisterNewModel
import com.example.lab.inbox.inboxreceivemsgprocess.utils.getLogger
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class POCService(
    private val matchingRegisterNewRepository: MatchingRegisterNewRepository
) {
    private companion object {
        private val log = getLogger<TestHandler>()
    }
    suspend fun process(model: MatchingRegisterNewModel){
        createMatchingData(model)
        val index = findIndexOrderOfType(model)
        log.info("index of insert of matching id = ${model.matchingId} : customer id = ${model.customerId} : type = ${model.type} ")
    }
    private suspend fun createMatchingData(model: MatchingRegisterNewModel) {
        matchingRegisterNewRepository.insertMatchingRegisterNew(
            MatchingRegisterNew(
                id = null,
                customerId = model.customerId,
                matchingId = model.matchingId,
                type = model.type,
                status = true,
                createDate = LocalDateTime.now(),
                createBy = "TEST"
            )
        )
    }
    private suspend fun findIndexOrderOfType(model: MatchingRegisterNewModel)=
        matchingRegisterNewRepository.findByCustomerIdAndMatchingId(
            matchingId = model.matchingId,
            customerId = model.customerId
        ).collectList()
            .awaitFirstOrNull()
            ?.indexOfFirst { matchingRegisterNew ->
                (matchingRegisterNew.customerId == model.customerId
                        && matchingRegisterNew.matchingId == model.matchingId
                        && matchingRegisterNew.type == model.type) && matchingRegisterNew.status
            } ?: -1
}