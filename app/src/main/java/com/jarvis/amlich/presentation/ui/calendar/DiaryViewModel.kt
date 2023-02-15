package com.jarvis.amlich.presentation.ui.calendar

import com.jarvis.amlich.base.BaseViewModel
import com.jarvis.amlich.common.core.HourGoodBadHelper
import com.jarvis.amlich.common.core.LunarCoreHelper
import com.jarvis.amlich.common.core.SaoXauHelper
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DiaryViewModel : BaseViewModel() {
    fun getLunarDay(dayData: LocalDate): IntArray {
        return LunarCoreHelper.convertSolar2Lunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year,
            7.00
        )
    }

    fun getNameLunarDay(dayData: LocalDate): String {
        return (LunarCoreHelper.getCanDayLunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year
        ) + " "
                + LunarCoreHelper.getChiDayLunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year
        ))

    }

    private fun getChiDay(dayData: LocalDate): String {
        return LunarCoreHelper.getChiDayLunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year
        )
    }

    private fun getCanDay(dayData: LocalDate): String {
        return LunarCoreHelper.getCanDayLunar(
            dayData.dayOfMonth,
            dayData.monthValue,
            dayData.year
        )
    }

    fun getListHourHoangDao(dayData: LocalDate): List<String> {
        val hourHoangDao = HourGoodBadHelper.hourGoodBadStatus(
            LunarCoreHelper.getChiDayLunarEnum(
                dayData.dayOfMonth,
                dayData.monthValue,
                dayData.year
            )
        )
        val instant: Instant =
            dayData.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()
        val res = Date.from(instant)

        return LunarCoreHelper.getCanChiHourInDay(res.time, hourHoangDao.first)
    }

    fun getSaoXau(dayData: LocalDate): List<String> {
        val chiDay = getChiDay(dayData)
        val canDay = getCanDay(dayData)
        val thangLunar = getLunarDay(dayData)[1]
        return SaoXauHelper.getSaoXau(canDay, chiDay, thangLunar)
    }

    fun getStatusDay(dayData: LocalDate): String {
        val chiDay = getChiDay(dayData)
        val lunarDay = getLunarDay(dayData)
        return LunarCoreHelper.rateDay(chiDay, lunarDay[1])
    }

    fun getHuongTaiHy(dayData: LocalDate): Pair<String, String> {
        val canDay = getCanDay(dayData)
        return HourGoodBadHelper.getTaiHyPhuongHuong(canDay)
    }
}