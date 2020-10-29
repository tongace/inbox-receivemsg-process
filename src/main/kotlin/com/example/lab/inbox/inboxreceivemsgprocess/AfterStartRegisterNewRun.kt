package com.example.lab.inbox.inboxreceivemsgprocess

import com.example.lab.inbox.inboxreceivemsgprocess.data.repositories.SendRegisterNewRepository
import com.example.lab.inbox.inboxreceivemsgprocess.features.qualifications.model.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class AfterStartRegisterNewRun(
    private val sendRegisterNewRepository: SendRegisterNewRepository
) {

    @EventListener(ApplicationReadyEvent::class)
    fun sendRegisterNewPass() = runBlocking {
        launch {
            sendRegisterNewRepository.sendNewRegisterForm(
                FormDataModel(
                    customerId= "1603861015436469385966",
                    desc = "New Registration Form is valid.",
                    matchingId="NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    result=true
                )
            )
        }
//        launch {
//            sendRegisterNewRepository.sendNewRegisterForm(
//                FormDataModel(
//                    customerId= "1603861015436469385967",
//                    desc = "New Registration Form is valid.",
//                    matchingId="NTc2bmd5dFZiVXXXXX1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
//                    result=true
//                )
//            )
//        }
        launch {
            sendRegisterNewRepository.sendNewRegisterDopa(
                DopaModel(
                    customerId= "1603861015436469385966",
                    matchingId="NTc2bmd5dFZiVDZZTW1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
                    description="Success",
                    code ="9999",
                    dopaData = DopaData(
                        code = 0,
                        status = "ปกติ"
                    )
                )
            )
        }
//        launch {
//            sendRegisterNewRepository.sendNewRegisterDopa(
//                DopaModel(
//                    customerId= "1603861015436469385967",
//                    matchingId="NTc2bmd5dFZiVXXXXX1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
//                    description="Success",
//                    code ="0000",
//                    dopaData = DopaData(
//                        code = 1,
//                        status = "ไม่ปกติ"
//                    )
//                )
//            )
//        }
        launch {
            sendRegisterNewRepository.sendNewRegisterFaceReflect(
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
//        launch {
//            sendRegisterNewRepository.sendNewRegisterFaceReflect(
//                FaceReflectModel(
//                    customerId= "1603861015436469385967",
//                    matchingId="NTc2bmd5dFZiVXXXXX1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
//                    faceReflectsData = FaceReflectsData(
//                        code = "9999",
//                        confidence= 0,
//                        description= "SUCCESS",
//                        result = true,
//                        source = "KTB_MAIN_VAULT",
//                        tencentCode = -1003,
//                        tencentDesc = "aasd"
//                    )
//                )
//            )
//        }

        launch {
            sendRegisterNewRepository.sendNewRegisterFaceBasic(
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
//        launch {
//            sendRegisterNewRepository.sendNewRegisterFaceBasic(
//                FaceBasicModel(
//                    customerId= "1603861015436469385967",
//                    matchingId="NTc2bmd5dFZiVXXXXX1xNkpYbGlOMlU0dXlTM1h3aWowMGFoV3FCa3Ayaz0=",
//                    faceBasicsData = FaceBasicsData(
//                        code = "0000",
//                        confidence= 0,
//                        description= "SUCCESS",
//                        result = true,
//                        source = "COMPAGE_IMAGE",
//                        tencentCode = -1003,
//                        tencentDesc = "aasd"
//                    )
//                )
//            )
//        }
    }
}