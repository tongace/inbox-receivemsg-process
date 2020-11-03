package com.example.lab.inbox.inboxreceivemsgprocess.features.testsendkafka.services

import com.example.lab.inbox.inboxreceivemsgprocess.data.repositories.SendForgotPinRepository
import com.example.lab.inbox.inboxreceivemsgprocess.data.repositories.SendRegisterNewRepository
import com.example.lab.inbox.inboxreceivemsgprocess.features.qualifications.model.*
import org.springframework.stereotype.Service

@Service
class SendForgotPinService (
    private val sendForgotPinRepository: SendForgotPinRepository
){
    suspend fun send() {
        kotlin.run {
            sendForgotPinRepository.sendForm(
                FormDataModel(
                    customerId= "1603861015436469385966",
                    desc = "New Registration Form is valid.",
                    matchingId="NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    result=true
                )
            )
        }
        kotlin.run {
            sendForgotPinRepository.sendDopa(
                DopaModel(
                    customerId= "1603861015436469385966",
                    matchingId="NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
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
            sendForgotPinRepository.sendFaceBasic(
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