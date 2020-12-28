package com.example.lab.inbox.inboxreceivemsgprocess.features.testsendkafka.services

import com.example.lab.inbox.inboxreceivemsgprocess.data.repositories.SendRegisterNewRepository
import com.example.lab.inbox.inboxreceivemsgprocess.features.qualifications.model.*
import org.springframework.stereotype.Service

@Service
class SendNewRegisterService(
    private val sendRegisterNewRepository: SendRegisterNewRepository
) {
    suspend fun send() {
        kotlin.run {
            sendRegisterNewRepository.sendForm(
                FormDataModel(
                    matchingId = "1603861015436469385966",
                    desc = "New Registration Form is valid.",
                    customerId = "NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    result = true
                )
            )
        }
        kotlin.run {
            sendRegisterNewRepository.sendDopa(
                DopaModel(
                    customerId = "NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    matchingId = "1603861015436469385966",
                    description = "Success",
                    code = "0000",
                    dopaData = DopaData(
                        code = 0,
                        status = "ปกติ"
                    )
                )
            )
        }
        kotlin.run {
            sendRegisterNewRepository.sendFaceReflect(
                FaceReflectModel(
                    customerId = "NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    matchingId = "1603861015436469385966",
                    faceReflectsData = FaceReflectsData(
                        code = "0000",
                        confidence = 0,
                        description = "SUCCESS",
                        result = true,
                        source = "COMPAGE_IMAGE",
                        tencentCode = -1003,
                        tencentDesc = "aasd"
                    )
                )
            )
        }
        kotlin.run {
            sendRegisterNewRepository.sendFaceBasic(
                FaceBasicModel(
                    customerId = "NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    matchingId = "1603861015436469385966",
                    faceBasicsData = FaceBasicsData(
                        code = "0000",
                        confidence = 0,
                        description = "SUCCESS",
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