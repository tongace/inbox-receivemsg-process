package com.example.lab.inbox.inboxreceivemsgprocess.features.testsendkafka.services

import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.entities.*
import com.example.lab.inbox.inboxreceivemsgprocess.data.kafka.repositories.SendForgotPinRepository
import org.springframework.stereotype.Service

@Service
class SendForgotPinService (
    private val sendForgotPinRepository: SendForgotPinRepository
){
    suspend fun send() {
        kotlin.run {
            sendForgotPinRepository.sendForm(
                FormDataModel(
                    customerId= "NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    desc = "New Registration Form is valid.",
                    matchingId="1603861015436469385966",
                    result=true
                )
            )
        }
        kotlin.run {
            sendForgotPinRepository.sendDopa(
                DopaModel(
                    customerId= "NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    matchingId="1603861015436469385966",
                    description="Success",
                    code ="0000",
                    dopaData = DopaData(
                        code = 0,
                        status = "ปกติ"
                    )
                )
            )
        }
        kotlin.run {
            sendForgotPinRepository.sendFaceReflect(
                FaceReflectModel(
                    customerId= "NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    matchingId="1603861015436469385966",
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
            sendForgotPinRepository.sendFaceBasic(
                FaceBasicModel(
                    customerId= "NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    matchingId="1603861015436469385966",
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