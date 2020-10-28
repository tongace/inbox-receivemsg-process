package com.example.lab.inbox.inboxreceivemsgprocess.features.qualifications.model

data class FormDataModel(
    val customerId: String,
    val desc: String,
    val matchingId: String,
    val result: Boolean
)


data class FaceReflectModel(
    val customerId: String,
    val faceReflectsData: FaceReflectsData,
    val matchingId: String
)
data class FaceReflectsData(
    val code: String,
    val confidence: Int,
    val description: String,
    val result: Boolean,
    val source: String,
    val tencentCode: Int,
    val tencentDesc: String
)

data class FaceBasicModel(
    val customerId: String,
    val faceBasicsData: FaceBasicsData,
    val matchingId: String
)

data class FaceBasicsData(
    val code: String,
    val confidence: Int,
    val description: String,
    val result: Boolean,
    val source: String,
    val tencentCode: Int,
    val tencentDesc: String
)

data class DopaModel(
    val code: String,
    val customerId: String,
    val description: String,
    val dopaData: DopaData,
    val matchingId: String
)

data class DopaData(
    val code: Int,
    val status: String
)