package com.example.hcmfootballfields_asm1_tranchannam_s3804825.models

data class Field(
    val image: String,
    val name: String,
    val phone: String,
    val address: String,
    val rate: Double,
    val shortDescription: String,
    val fullDescription: String,
    val type: FieldType
)

enum class FieldType {
    A_SIDE_11,
    A_SIDE_7,
    FUTSAL
}
