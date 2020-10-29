package com.example.lab.inbox.inboxreceivemsgprocess.features.testsendkafka.services

import com.example.lab.inbox.inboxreceivemsgprocess.data.repositories.SendRegisterExistingRepository
import com.example.lab.inbox.inboxreceivemsgprocess.features.qualifications.model.*
import org.springframework.stereotype.Service

@Service
class SendExistingRegisterService (
    private val sendRegisterExistingRepository: SendRegisterExistingRepository
){
    suspend fun send() {
        kotlin.run {
            sendRegisterExistingRepository.sendForm(
                FormDataModel(
                    customerId= "1603861015436469385966",
                    desc = "New Registration Form is valid.",
                    matchingId="NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    result=true
                )
            )
        }
        kotlin.run {
            sendRegisterExistingRepository.sendFaceReflect(
                FaceReflectModel(
                    customerId= "1603861015436469385966",
                    matchingId="NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    faceReflectsData = FaceReflectsData(
                        code = "0000",
                        confidence= 0,
                        description= "SUCCESS",
                        result = true,
                        source = "COMPAGE_IMAGE",
                        tencentCode = -1003,
                        tencentDesc = "aasd"
                    )
                )
            )
        }
        kotlin.run {
            sendRegisterExistingRepository.sendFaceBasic(
                FaceBasicModel(
                    customerId= "1603861015436469385966",
                    matchingId="NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    faceBasicsData = FaceBasicsData(
                        code = "0000",
                        confidence= 0,
                        description= "SUCCESS",
                        result = true,
                        source = "COMPAGE_IMAGE",
                        tencentCode = -1003,
                        tencentDesc = "aasd"
                    )
                )
            )
        }
    }
}