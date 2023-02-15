package com.jarvis.amlich.common.core

import com.jarvis.amlich.R
import com.jarvis.amlich.di.App

object SaoXauHelper {
    val thienCuong =
        listOf("Tỵ", "Tý", "Mùi", "Dần", "Dậu", "Thìn", "Hợi", "Ngọ", "Sửu", "Thân", "Mão", "Tuất")
    val thuTu =
        listOf("Tuất", "Thìn", "Hợi", "Tỵ", "Tý", "Ngọ", "Sửu", "Mùi", "Dần", "Thân", "Mão", "Dậu")
    val daiHao =
        listOf("Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ")
    val tuKhi =
        listOf("Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ")
    val quanPhu =
        listOf("Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ")
    val tieuHao =
        listOf("Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn")
    val satChu =
        listOf("Tý", "Tỵ", "Mùi", "Mão", "Thân", "Tuất", "Sửu", "Hợi", "Ngọ", "Dậu", "Dần", "Thìn")
    val thienHoa =
        listOf("Tý", "Mão", "Ngọ", "Dậu", "Tý", "Mão", "Ngọ", "Dậu", "Tý", "Mão", "Ngọ", "Dậu")
    val diaHoa =
        listOf("Tuất", "Dậu", "Thân", "Mùi", "Ngọ", "Tỵ", "Thìn", "Mão", "Dần", "Sửu", "Tý", "Hợi")
    val hoaTai =
        listOf("Sửu", "Mùi", "Dần", "Thân", "Mão", "Dậu", "Thìn", "Tuất", "Tỵ", "Hợi", "Tý", "Ngọ")
    val nguyetPha =
        listOf(
            "Thân",
            "Tuất",
            "Tuất",
            "Hợi",
            "Sửu",
            "Sửu",
            "Dần",
            "Thìn",
            "Thìn",
            "Tỵ",
            "Mùi",
            "Mùi"
        )
    val bangTieu =
        listOf("Tỵ", "Tý", "Sửu", "Thân", "Mão", "Tuất", "Hợi", "Ngọ", "Mùi", "Dần", "Dậu", "Thìn")
    val ngoaGiai =
        listOf("Tỵ", "Tý", "Sửu", "Thân", "Mão", "Tuất", "Hợi", "Ngọ", "Mùi", "Dần", "Dậu", "Thìn")
    val thoCam =
        listOf("Hợi", "Hợi", "Hợi", "Dần", "Dần", "Dần", "Tỵ", "Tỵ", "Tỵ", "Thân", "Thân", "Thân")
    val thoKy =
        listOf("Dần", "Tỵ", "Thân", "Hợi", "Mão", "Ngọ", "Dậu", "Tý", "Thìn", "Mùi", "Tuất", "Sửu")
    val vangVong =
        listOf("Dần", "Tỵ", "Thân", "Hợi", "Mão", "Ngọ", "Dậu", "Tý", "Thìn", "Mùi", "Tuất", "Sửu")
    val coThan =
        listOf("Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu")
    val quaTu =
        listOf("Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão")
    val trungTang =
        listOf("Giáp", "Ất", "Mậu", "Bính", "Đinh", "Kỷ", "Canh", "Tân", "Kỷ", "Nhâm", "Quý", "Mậu")
    val trungPhuc =
        listOf("Canh", "Tân", "Kỷ", "Nhâm", "Quý", "Mậu", "Giáp", "Ất", "Kỷ", "Bính", "Đinh", "Mậu")

    val khongPhong =
        listOf("Thìn", "Tỵ", "Tý", "Tuất", "Hợi", "Mùi", "Ngọ", "Mão", "Dần", "Dậu", "Thân", "Sửu")

    val thienTac =
        listOf("Thìn", "Dậu", "Dần", "Mùi", "Tý", "Tỵ", "Tuất", "Mão", "Thân", "Sửu", "Ngọ", "Hợi")
    val phuDauDat =
        listOf("Thìn", "Thìn", "Thìn", "Mùi", "Mùi", "Mùi", "Ngọ", "Ngọ", "Ngọ", "Tý", "Tý", "Tý")
    val tamTang = listOf(
        "Thìn",
        "Thìn",
        "Thìn",
        "Mùi",
        "Mùi",
        "Mùi",
        "Tuất",
        "Tuất",
        "Tuất",
        "Sửu",
        "Sửu",
        "Sửu"
    )
    val nguTu =
        listOf("Tý", "Dậu", "Sửu", "Thân", "Tý", "Thìn", "Hợi", "Mão", "Mùi", "Dần", "Ngọ", "Tuất")
    val tuThoi = listOf(
        "Ất Mùi",
        "Ất Mùi",
        "Ất Mùi",
        "Bính Tuất",
        "Bính Tuất",
        "Bính Tuất",
        "Tân Sửu",
        "Tân Sửu",
        "Tân Sửu",
        "Nhâm Thìn",
        "Nhâm Thìn",
        "Nhâm Thìn"
    )
    val lucBatThanh =
        listOf("Dần", "Ngọ", "Tuất", "Tỵ", "Dậu", "Sửu", "Thân", "Tý", "Thìn", "Hợi", "Mão", "Mùi")
    val hoangSa =
        listOf("Ngọ", "Dần", "Tý", "Ngọ", "Dần", "Tý", "Ngọ", "Dần", "Tý", "Ngọ", "Dần", "Tý")
    val nguyetHu = listOf(
        "Sửu",
        "Tuất",
        "Mùi",
        "Thìn",
        "Sửu",
        "Tuất",
        "Mùi",
        "Thìn",
        "Sửu",
        "Tuất",
        "Mùi",
        "Thìn"
    )
    val nguyetYem =
        listOf("Tuất", "Dậu", "Thân", "Mùi", "Ngọ", "Tỵ", "Thìn", "Mão", "Dần", "Sửu", "Tý", "Hợi")
    val nguyetHoa =
        listOf("Tỵ", "Thìn", "Mão", "Dần", "Sửu", "Tý", "Hợi", "Tuất", "Tỵ", "Hợi", "Ngọ", "Tý")
    val tieuHongSa = listOf("Tỵ", "", "", "", "", "", "", "", "", "", "", "")
    val cuaKhong =
        listOf("Thìn", "Sửu", "Tuất", "Mùi", "Mão", "Tý", "Dậu", "Ngọ", "Dần", "Hợi", "Thân", "Tý")
    val chuTuoc =
        listOf("Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu")
    val haKhoi =
        listOf("Hợi", "Ngọ", "Sửu", "Thân", "Mão", "Tuất", "Tỵ", "Tý", "Mùi", "Dần", "Dậu", "Thìn")
    val nguQuy =
        listOf("Ngọ", "Dần", "Thìn", "Dậu", "Mão", "Thân", "Sửu", "Tỵ", "Tý", "Hợi", "Mùi", "Tuất")
    val phiMaSat =
        listOf("Tý", "Dậu", "Ngọ", "Mão", "Tý", "Dậu", "Ngọ", "Mão", "Tý", "Dậu", "Ngọ", "Mão")
    val thanCach =
        listOf("Tỵ", "Mão", "Sửu", "Hợi", "Dậu", "Mùi", "Tỵ", "Mão", "Sửu", "Hợi", "Dậu", "Mùi")
    val nhanCach =
        listOf("Dậu", "Mùi", "Tỵ", "Mão", "Sửu", "Hợi", "Dậu", "Mùi", "Tỵ", "Mão", "Sửu", "Hợi")
    val diaTac =
        listOf("Sửu", "Tý", "Hợi", "Tuất", "Dậu", "Thân", "Mùi", "Ngọ", "Tỵ", "Thìn", "Mão", "Dần")
    val nguyetKien =
        listOf("Mão", "Mão", "Mão", "Ngọ", "Ngọ", "Ngọ", "Dậu", "Dậu", "Dậu", "Tý", "Tý", "Tý")
    val thienDia =
        listOf("Mão", "Mão", "Mão", "Ngọ", "Ngọ", "Ngọ", "Dậu", "Dậu", "Dậu", "Tý", "Tý", "Tý")
    val loBanSat =
        listOf("Tý", "Tý", "Tý", "Mão", "Mão", "Mão", "Ngọ", "Ngọ", "Ngọ", "Dậu", "Dậu", "Dậu")
    val nguyetHinh =
        listOf("Tỵ", "Tý", "Thìn", "Thân", "Ngọ", "Sửu", "Dần", "Dậu", "Mùi", "Hợi", "Mão", "Tuất")
    val toiChi =
        listOf("Ngọ", "Tý", "Mùi", "Sửu", "Thân", "Dần", "Dậu", "Mão", "Tuất", "Thìn", "Hợi", "Tỵ")

    val thienHinh = listOf(
        "Dần",
        "Thìn",
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn",
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý"
    )
    val thienLao = listOf(
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn",
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn",
        "Ngọ"
    )
    val cauTran =
        listOf("Hợi", "Sửu", "Mão", "Tị", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu")
    val satSu =
        listOf("Thìn", "Tuất", "Thìn", "Mão", "Mão", "Sửu", "Mùi", "Sửu", "Tý", "Ngọ", "Ngọ", "Tý")
    val bachHo = listOf(
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn",
        "Ngọ",
        "Thân",
        "Tuất",
        "Tý",
        "Dần",
        "Thìn"
    )
    val lySang =
        listOf("Dậu", "Dậu", "Dậu", "Dần", "Dần", "Dần", "Tuất", "Tuất", "Tuất", "Tỵ", "Tỵ", "Tỵ")
    val nguyenVu =
        listOf("Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi", "Dậu", "Hợi", "Sửu", "Mão", "Tỵ", "Mùi")
//    val thienOn = listOf("Mùi")
//    val thoOn = listOf("Thìn")
//    val hoangVu = listOf("Tỵ")
//    val duongThac = listOf("Tỵ")

    val listSaoXau =
        listOf(
            "Thiên Cương",
            "Thụ Tử",
            "Đại Hao",
            "Tử Khí",
            "Quan Phù",
            "Tiểu Hao",
            "Sát Chủ",
            "Thiên Hỏa",
            "Địa Hỏa",
            "Hỏa Tai",
            "Nguyệt Phá",
            "Băng Tiêu",
            "Ngọa Giải",
            "Thổ Cấm",
            "Thổ Kỵ",
            "Vãng Vong",
            "Cô Thần",
            "Quả Tú",
            "Trùng Tang",
            "Trùng Phục",
            "Không Phòng",
            "Thiên Tặc",
            "Phủ Đầu Sát",
            "Ngũ Quỷ",
            "Tứ Thời",
            "Lục Bất Thành",
            "Hoàng Sa",
            "Nguyệt Hư",
            "Nguyệt Yếm",
            "Nguyệt Hỏa",
            "Tiêu Hồng Sa",
            "Cửa Không",
            "Chu Tước",
            "Hà Khôi",
            "Ngũ Quỷ",
            "Phi Ma Sát",
            "Thần Cách",
            "Nhân Cách",
            "Địa Tặc",
            "Nguyệt Kiến",
            "Thiên Địa",
            "Lỗ Ban Sát",
            "Nguyệt Hình",
            "Tội Chỉ",
            "Tam Tang",
            "Thiên Hình",
            "Thiên Lao",
            "Câu Trần",
            "Sát Sư",
            "Bạch Hổ",
            "Ly Sàng",
            "Nguyên Vu"
        )

    val listListDay = listOf(
        thienCuong,
        thuTu,
        daiHao,
        tuKhi,
        quanPhu,
        tieuHao,
        satChu,
        thienHoa,
        diaHoa,
        hoaTai,
        nguyetPha,
        bangTieu,
        ngoaGiai,
        thoCam,
        thoKy,
        vangVong,
        coThan,
        quaTu,
        trungTang,
        trungPhuc,
        khongPhong,
        thienTac,
        phuDauDat,
        nguTu,
        tuThoi,
        lucBatThanh,
        hoangSa,
        nguyetHu,
        nguyetYem,
        nguyetHoa,
        tieuHongSa,
        cuaKhong,
        chuTuoc,
        haKhoi,
        nguQuy,
        phiMaSat,
        thanCach,
        nhanCach,
        diaTac,
        nguyetKien,
        thienDia,
        loBanSat,
        nguyetHinh,
        toiChi,
        tamTang,
        thienHinh,
        thienLao,
        cauTran,
        satSu,
        bachHo,
        lySang,
        nguyenVu
    )

    val listTitleDay = listOf(
        App.context.getString(R.string.des_thienCuong),
        App.context.getString(R.string.des_thuTu),
        App.context.getString(R.string.des_daiHao),
        App.context.getString(R.string.des_tuKhi),
        App.context.getString(R.string.des_quanPhu),
        App.context.getString(R.string.des_tieuHao),
        App.context.getString(R.string.des_satChu),
        App.context.getString(R.string.des_thienHoa),
        App.context.getString(R.string.des_diaHoa),
        App.context.getString(R.string.des_hoaTai),
        App.context.getString(R.string.des_nguyetPha),
        App.context.getString(R.string.des_bangTieu),
        App.context.getString(R.string.des_ngoaGiai),
        App.context.getString(R.string.des_thoCam),
        App.context.getString(R.string.des_thoKy),
        App.context.getString(R.string.des_vangVong),
        App.context.getString(R.string.des_coThan),
        App.context.getString(R.string.des_quaTu),
        App.context.getString(R.string.des_trungTang),
        App.context.getString(R.string.des_trungPhuc),
        App.context.getString(R.string.des_khongPhong),
        App.context.getString(R.string.des_thienTac),
        App.context.getString(R.string.des_phuDauDat),
        App.context.getString(R.string.des_nguTu),
        App.context.getString(R.string.des_tuThoi),
        App.context.getString(R.string.des_lucBatThanh),
        App.context.getString(R.string.des_hoangSa),
        App.context.getString(R.string.des_nguyetHu),
        App.context.getString(R.string.des_nguyetYem),
        App.context.getString(R.string.des_nguyetHoa),
        App.context.getString(R.string.des_tieuHongSa),
        App.context.getString(R.string.des_cuaKhong),
        App.context.getString(R.string.des_chuTuoc),
        App.context.getString(R.string.des_haKhoi),
        App.context.getString(R.string.des_nguQuy),
        App.context.getString(R.string.des_phiMaSat),
        App.context.getString(R.string.des_thanCach),
        App.context.getString(R.string.des_nhanCach),
        App.context.getString(R.string.des_diaTac),
        App.context.getString(R.string.des_nguyetKien),
        App.context.getString(R.string.des_thienDia),
        App.context.getString(R.string.des_loBanSat),
        App.context.getString(R.string.des_nguyetHinh),
        App.context.getString(R.string.des_toiChi),
        App.context.getString(R.string.des_tamTang),
        App.context.getString(R.string.des_thienHinh),
        App.context.getString(R.string.des_thienLao),
        App.context.getString(R.string.des_cauTran),
        App.context.getString(R.string.des_satSu),
        App.context.getString(R.string.des_bachHo),
        App.context.getString(R.string.des_lySang),
        App.context.getString(
            R.string.des_nguyenVu
        )
    )

    fun getSaoXau(canDay: String, chiDay: String, thang: Int): List<String> {
        val results = mutableListOf<String>()
        listListDay.mapIndexed { index, strings ->
            if (strings[thang - 1] == canDay || strings[thang - 1] == chiDay || strings[thang - 1] == "$canDay $chiDay") {
                results.add(listSaoXau[index] + ": " + listTitleDay[index])
            }
        }
        return results
    }
}