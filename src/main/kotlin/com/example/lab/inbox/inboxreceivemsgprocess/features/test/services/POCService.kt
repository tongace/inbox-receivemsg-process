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
        val insertedDatas = createMatchingData(model)
        val meetRequiredType = findMeetTypeRequired(model,insertedDatas)
        val index = findIndexOrderOfType(model,insertedDatas)
        log.info("index of insert of matching id = ${model.matchingId} : customer id = ${model.customerId} : type = ${model.type} >>>>> $index and meet required >>> $meetRequiredType" )
    }
    private suspend fun createMatchingData(model: MatchingRegisterNewModel): MutableList<MatchingRegisterNew>? {
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
        return matchingRegisterNewRepository.findByCustomerIdAndMatchingId(
            matchingId = model.matchingId,
            customerId = model.customerId
        ).collectList().awaitFirstOrNull()
    }
    private suspend fun findIndexOrderOfType(model: MatchingRegisterNewModel,insertedData: MutableList<MatchingRegisterNew>?)=
        insertedData
            ?.indexOfFirst { matchingRegisterNew ->
                (matchingRegisterNew.customerId == model.customerId
                        && matchingRegisterNew.matchingId == model.matchingId
                        && matchingRegisterNew.type == model.type) && matchingRegisterNew.status
            } ?: -1
    private suspend fun findMeetTypeRequired(model: MatchingRegisterNewModel,insertedData: MutableList<MatchingRegisterNew>?)=
        insertedData?.count {
            matchingRegisterNew -> matchingRegisterNew.type=="DOPA" || matchingRegisterNew.type=="FORM"
        }==2
}