package com.example.lab.inbox.inboxreceivemsgprocess.features.userdata.services

import com.example.lab.inbox.inboxreceivemsgprocess.data.repositories.UserProfileRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("dev")
internal class UserProfileServiceTest(
    @Autowired private val userProfileRepository: UserProfileRepository
){
    @Test
    fun `test find user by mobile no 0812345678`()= runBlocking{
        val returnUserData = userProfileRepository.findByConsumerMobileNumber("0812345678")
        assertNotNull(returnUserData)
        assertEquals("Other",returnUserData?.consumerNameEn)
    }
    @Test
    fun `test find user by mobile no 0922755678`()= runBlocking{
        val returnUserData = userProfileRepository.findByConsumerMobileNumber("0922755678")
        assertNotNull(returnUserData)
        assertEquals("Chairat",returnUserData?.consumerNameEn)
    }
}