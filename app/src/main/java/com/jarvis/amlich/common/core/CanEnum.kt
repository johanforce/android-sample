package com.jarvis.amlich.common.core

enum class CanEnum(var valueStr: String, val value: Int) {
    // action card not DONE
    GIAP("Giáp", 0),
    AT("Ất", 1),
    BINH("Bính", 2),
    DINH("Đinh", 3),
    MAU("Mậu", 4),
    KY("Kỷ", 5),
    CANH("Canh", 6),
    TAN("Tân", 7),
    NHAM("Nhâm", 8),
    QUY("Quý", 9),
}

enum class ChiEnum(var valueStr: String, val value: Int) {
    // action card not DONE
    TY("Tý", 0),
    SUU("Sửu", 1),
    DAN("Dần", 2),
    MAO("Mão", 3),
    THIN("Thìn", 4),
    TI("Tỵ", 5),
    NGO("Ngọ", 6),
    MUI("Mùi", 7),
    THAN("Thân", 8),
    DAU("Dậu", 9),
    TUAT("Tuất", 10),
    HOI("Hợi", 11),
}

enum class StatusDay(var valueStr: String, val value: Int) {
    HOANG_DAO("Hoàng Đạo", 0),
    HAC_DAO("Hắc Đạo", 1),
}

enum class PhuongHuong(var valueStr: String, val value: Int) {
    BAC("Bắc", 0),
    DONG_BAC("Đông Bắc", 1),
    DONG("Đông", 1),
    DONG_NAM("Đông Nam", 1),
    NAM("Nam", 1),
    TAY_NAM("Tây Nam", 1),
    TAY("Tây", 1),
    TAY_BAC("Tây Bắc", 1),
}