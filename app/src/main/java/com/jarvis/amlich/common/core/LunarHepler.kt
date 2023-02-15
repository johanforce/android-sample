package com.jarvis.amlich.common.core

import java.text.Normalizer
import java.util.*
import java.util.regex.Pattern
import kotlin.math.floor
import kotlin.math.sin

object LunarCoreHelper {
    private const val PI = Math.PI
    private const val TAG = "LunarCoreHelper"

    //Time Giap Ty base
    private const val BASE_TIME = 1672502400000
    private const val MILLISECONDS_IN_DAY = 1000 * 60 * 60 * 24

    /**
     * In China, Vietnam and other East Asian countries,
     * we use the sexagenary cycle, also known as the Stems-and-Branches.
     * It appears as a means of recording days in the first Chinese written texts.
     * We have 10 Heavenly Stems and 12 Earthly Branches which make 60 Stem-Branch pairs.
     * From those pairs, we can "guess" which day is good, which day is not, based on some traditional rules.
     * For more info: https://en.wikipedia.org/wiki/Sexagenary_cycle
     *
     * Yin Yang name will be added later
     */
    // 10 Heavenly Stems
    // Vietnamese Heavenly Stems (or "Thiên Can")
    private val CAN = arrayOf(
        "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh",
        "Tân", "Nhâm", "Quý"
    )

    private val canEnum = arrayOf(
        CanEnum.GIAP.value,
        CanEnum.AT.value,
        CanEnum.BINH.value,
        CanEnum.DINH.value,
        CanEnum.MAU.value,
        CanEnum.KY.value,
        CanEnum.CANH.value,
        CanEnum.TAN.value,
        CanEnum.NHAM.value,
        CanEnum.QUY.value,
    )

    // Chinese Heavenly Stems (or "天干")
    private val STEMS = arrayOf(
        "甲", "乙", "丙", "丁", "戊", "己", "庚",
        "辛", "壬", "癸"
    )

    // 12 Earthly Branches
    // Vietnamese Earthly Branches (or "Địa Chi")
    private val CHI = arrayOf(
        "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ",
        "Mùi", "Thân", "Dậu", "Tuất", "Hợi"
    )

    private val chiEnum = listOf(
        ChiEnum.TY.value,
        ChiEnum.SUU.value,
        ChiEnum.DAN.value,
        ChiEnum.MAO.value,
        ChiEnum.THIN.value,
        ChiEnum.TI.value,
        ChiEnum.NGO.value,
        ChiEnum.MUI.value,
        ChiEnum.THAN.value,
        ChiEnum.DAU.value,
        ChiEnum.TUAT.value,
        ChiEnum.HOI.value,
    )

    // Chinese Earthly Branches (or "地支")
    private val BRANCHES = arrayOf(
        "子", "丑", "寅", "卯", "辰", "巳", "午",
        "未", "申", "酉", "戌", "亥"
    )

    /**
     * Based on some traditional rules (again!), on each month,
     * we have 4 Chi(s)/Branches which is called "good", and 4 Chi(s)/Branches which called "bad".
     * The next 2-dimensional arrays are the lists of "good days" and "bad days".
     * We Vietnamese actually have other terms for those two. But we haven't found any English word for that.
     * So let's just call them "good days" and "bad days".
     * Reference will be added later.
     *
     * We use Chi/Branch with unaccented syllables to make it easy when comparing string.
     */
    private val goodDays = arrayOf(
        arrayOf("tys", "suu", "tyj", "mui"),
        arrayOf("dan", "mao", "mui", "dau"),
        arrayOf("thin", "tyj", "dau", "hoi"),
        arrayOf("ngo", "mui", "suu", "dau"),
        arrayOf("than", "dau", "suu", "mao"),
        arrayOf("tuat", "hoi", "mao", "tyj"),
        arrayOf("tys", "suu", "tyj", "mui"),
        arrayOf("dan", "mao", "mui", "dau"),
        arrayOf("thin", "tyj", "dau", "hoi"),
        arrayOf("ngo", "mui", "suu", "dau"),
        arrayOf("than", "dau", "suu", "mao"),
        arrayOf("tuat", "hoi", "mao", "tyj")
    )
    private val badDays = arrayOf(
        arrayOf("ngo", "mao", "hoi", "dau"),
        arrayOf("than", "tyj", "suu", "hoi"),
        arrayOf("tuat", "mui", "suu", "hoi"),
        arrayOf("tys", "dau", "tyj", "mao"),
        arrayOf("dan", "hoi", "mui", "tyj"),
        arrayOf("thin", "suu", "dau", "mui"),
        arrayOf("ngo", "mao", "hoi", "dau"),
        arrayOf("than", "tyj", "suu", "hoi"),
        arrayOf("tuat", "mui", "suu", "hoi"),
        arrayOf("tys", "dau", "tyj", "mao"),
        arrayOf("dan", "hoi", "mui", "tyj"),
        arrayOf("thin", "suu", "dau", "mui")
    )

    private fun isGoodDay(chiDay: String, lunarMonth: Int): Boolean {
        val data = goodDays[lunarMonth - 1]
        val tmp = data.size
        for (i in 0 until tmp) {
            if (data[i].equals(chiDay, ignoreCase = true)) {
                return true
            }
        }
        return false
    }

    private fun isBadDay(chiDay: String, lunarMonth: Int): Boolean {
        if (isGoodDay(chiDay, lunarMonth)) return false
        val data = badDays[lunarMonth - 1]
        for (aData in data) {
            if (aData.equals(chiDay, ignoreCase = true)) {
                return true
            }
        }
        return false
    }

    /**
     *
     * @param solarDay
     * @param solarMonth
     * @param solarYear
     * @return days between March 1st 1996 and the input date. Why March 1st 1996, see the "processDayLunar" method below.
     */
    private fun getDateDurationBetweenInputAndPivotDate(
        solarDay: Int,
        solarMonth: Int,
        solarYear: Int
    ): Int {
        val currentCalendar: Calendar = GregorianCalendar()
        currentCalendar.set(solarYear, solarMonth - 1, solarDay, 0, 0, 0)
        val checkCalendar: Calendar = GregorianCalendar()
        checkCalendar.set(1996, 2, 1, 0, 0, 0)
        return ((currentCalendar.timeInMillis / 1000L - checkCalendar
            .timeInMillis / 1000L) / (60 * 60 * 24)).toInt()
    }

    /**
     *
     * @param solarDay
     * @param solarMonth
     * @param solarYear
     * @return Can-Chi (or Stem-Branch) number of the input date.
     * We make March 1st 1996 a "pivot" date, and start counting Can-Chi from that date.
     * You can see we set iCan = 3, iChi = 9 means the "pivot" day is Đinh Dậu (or 丁酉, or Yin Fire Rooster).
     * So yeah, it's not a special date. Just a "pivot", a starting point to count. You can choose another day, which has another iCan and iChi.
     */
    private fun processDayLunar(solarDay: Int, solarMonth: Int, solarYear: Int): IntArray {
        var iCan = 3
        var iChi = 9
        val numDays = getDateDurationBetweenInputAndPivotDate(solarDay, solarMonth, solarYear)
        if (numDays < 0) {
            iCan = (iCan + numDays % 10 + 10) % 10
            iChi = (iChi + numDays % 12 + 12) % 12
        } else if (numDays > 0) {
            iCan = (iCan + numDays % 10) % 10
            iChi = (iChi + numDays % 12) % 12
        }
        return intArrayOf(iCan, iChi)
    }

    fun getCanDayLunar(solarDay: Int, solarMonth: Int, solarYear: Int): String {
        val tmp = processDayLunar(solarDay, solarMonth, solarYear)
        return CAN[tmp[0]]
    }

    fun getCanDayLunarEnum(solarDay: Int, solarMonth: Int, solarYear: Int): Int {
        val tmp = processDayLunar(solarDay, solarMonth, solarYear)
        return canEnum[tmp[0]]
    }

    fun getChiDayLunar(solarDay: Int, solarMonth: Int, solarYear: Int): String {
        val tmp = processDayLunar(solarDay, solarMonth, solarYear)
        return CHI[tmp[1]]
    }

    fun getChiDayLunarEnum(solarDay: Int, solarMonth: Int, solarYear: Int): Int {
        val tmp = processDayLunar(solarDay, solarMonth, solarYear)
        return chiEnum[tmp[1]]
    }

    fun getChineseCanDayLunar(solarDay: Int, solarMonth: Int, solarYear: Int): String {
        val tmp = processDayLunar(solarDay, solarMonth, solarYear)
        return STEMS[tmp[0]]
    }

    fun getChineseChiDayLunar(solarDay: Int, solarMonth: Int, solarYear: Int): String {
        val tmp = processDayLunar(solarDay, solarMonth, solarYear)
        return BRANCHES[tmp[1]]
    }

    /**
     *
     * @param s
     * @return words unaccented syllables, with an exception of "Đ/đ"
     */
    private fun unAccent(s: String): String {
        val temp: String = Normalizer.normalize(s, Normalizer.Form.NFD)
        val pattern: Pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
        return pattern.matcher(temp).replaceAll("").replace("Đ", "D").replace("đ", "d")
    }

    /**
     *
     * @param canchi
     * @return Can-Chi with unaccented syllables, with an exception of "Tý" and "Tỵ" which has the same result when unaccented.
     */
    private fun getUnAccentCanChi(canchi: String): String {
        var rs = unAccent(canchi)
        if (canchi.equals("tý", ignoreCase = true)) {
            rs += "s"
        } else if (canchi.equals("tỵ", ignoreCase = true)) {
            rs += "j"
        }
        return rs.lowercase(Locale.getDefault())
    }

    /**
     *
     * @param chiDay
     * @param lunarMonth
     * @return the string showing the input day is good or not
     * We use Can-Chi string with unaccented syllables to compare.
     * And yeah, "rateDay" is not a really good name for this method!
     */
    fun rateDay(chiDay: String, lunarMonth: Int): String {
        var chiDay = chiDay
        chiDay = getUnAccentCanChi(chiDay)
        return if (isGoodDay(chiDay, lunarMonth)) {
            "Thanh Long Hoàng Đạo"
        } else if (isBadDay(chiDay, lunarMonth)) {
            "Hắc Đạo"
        } else {
            "Hoàng Đạo"
        }
    }

    /**
     *
     * @param dd
     * @param mm
     * @param yy
     * @return the number of days since 1 January 4713 BC (Julian calendar)
     */
    private fun jdFromDate(dd: Int, mm: Int, yy: Int): Int {
        val a = (14 - mm) / 12
        val y = yy + 4800 - a
        val m = mm + 12 * a - 3
        var jd = (dd + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400
                - 32045)
        if (jd < 2299161) {
            jd = dd + (153 * m + 2) / 5 + 365 * y + y / 4 - 32083
        }
        // jd = jd - 1721425;
        return jd
    }

    /**
     * http://www.tondering.dk/claus/calendar.html Section: Is there a formula
     * for calculating the Julian day number?
     *
     * @param jd
     * - the number of days since 1 January 4713 BC (Julian calendar)
     * @return
     */
    private fun jdToDate(jd: Int): IntArray {
        val a: Int
        val b: Int
        val c: Int
        if (jd > 2299160) { // After 5/10/1582, Gregorian calendar
            a = jd + 32044
            b = (4 * a + 3) / 146097
            c = a - b * 146097 / 4
        } else {
            b = 0
            c = jd + 32082
        }
        val d = (4 * c + 3) / 1461
        val e = c - 1461 * d / 4
        val m = (5 * e + 2) / 153
        val day = e - (153 * m + 2) / 5 + 1
        val month = m + 3 - 12 * (m / 10)
        val year = b * 100 + d - 4800 + m / 10
        return intArrayOf(day, month, year)
    }

    /**
     * Solar longitude in degrees Algorithm from: Astronomical Algorithms, by
     * Jean Meeus, 1998
     *
     * @param jdn
     * - number of days since noon UTC on 1 January 4713 BC
     * @return
     */
    private fun sunLongitude(jdn: Double): Double {
        // return CC2K.sunLongitude(jdn);
        return sunLongitudeAA98(jdn)
    }

    private fun sunLongitudeAA98(jdn: Double): Double {
        val t = (jdn - 2415021.0) / 36525 // Time in Julian centuries from
        // 2000-01-01 12:00:00 GMT
        val t2 = t * t
        val dr = PI / 180 // degree to radian
        val m = 357.52910 + 35999.05030 * t - 0.0001559 * t2 - (0.00000048
                * t * t2) // mean anomaly, degree
        val l0 = 280.46645 + 36000.76983 * t + 0.0003032 * t2 // mean
        // longitude,
        // degree
        var dL = ((1.914600 - 0.004817 * t - 0.000014 * t2)
                * sin(dr * m))
        dL += (0.019993 - 0.000101 * t) * sin(dr * 2 * m) + (0.000290
                * sin(dr * 3 * m))
        var l = l0 + dL // true longitude, degree
        l -= 360 * iNT(l / 360) // Normalize to (0, 360)
        return l
    }

    private fun newMoon(k: Int): Double {
        // return CC2K.newMoonTime(k);
        return newMoonAA98(k)
    }

    /**
     * Julian day number of the kth new moon after (or before) the New Moon of
     * 1900-01-01 13:51 GMT. Accuracy: 2 minutes Algorithm from: Astronomical
     * Algorithms, by Jean Meeus, 1998
     *
     * @param k
     * @return the Julian date number (number of days since noon UTC on 1
     * January 4713 BC) of the New Moon
     */
    private fun newMoonAA98(k: Int): Double {
        val t = k / 1236.85 // Time in Julian centuries from 1900 January
        // 0.5
        val t2 = t * t
        val t3 = t2 * t
        val dr = PI / 180
        var jd1 = (2415020.75933 + 29.53058868 * k + 0.0001178 * t2
                - 0.000000155 * t3)
        jd1 += 0.00033 * sin((166.56 + 132.87 * t - 0.009173 * t2) * dr) // Mean
        // new
        // moon
        val m = 359.2242 + 29.10535608 * k - 0.0000333 * t2 - (0.00000347
                * t3) // Sun's mean anomaly
        val mpr = 306.0253 + 385.81691806 * k + 0.0107306 * t2 + (0.00001236
                * t3) // Moon's mean anomaly
        val f = 21.2964 + 390.67050646 * k - 0.0016528 * t2 - (0.00000239
                * t3) // Moon's argument of latitude
        var c1 = (0.1734 - 0.000393 * t) * sin(m * dr) + 0.0021 * sin(2 * dr * m)
        c1 = c1 - 0.4068 * sin(mpr * dr) + 0.0161 * sin(dr * 2 * mpr)
        c1 -= 0.0004 * sin(dr * 3 * mpr)
        c1 = c1 + 0.0104 * sin(dr * 2 * f) - 0.0051 * sin(dr * (m + mpr))
        c1 = c1 - 0.0074 * sin(dr * (m - mpr)) + 0.0004 * sin(dr * (2 * f + m))
        c1 = c1 - 0.0004 * sin(dr * (2 * f - m)) - (0.0006
                * sin(dr * (2 * f + mpr)))
        c1 += 0.0010 * sin(dr * (2 * f - mpr)) + (0.0005
                * sin(dr * (2 * mpr + m)))
        val deltat: Double = if (t < -11) {
            0.001 + 0.000839 * t + 0.0002261 * t2 - 0.00000845 * t3 - 0.000000081 * t * t3
        } else {
            -0.000278 + 0.000265 * t + 0.000262 * t2
        }
        return jd1 + c1 - deltat
    }

    private fun iNT(d: Double): Int {
        return floor(d).toInt()
    }

    private fun getSunLongitude(dayNumber: Int, timeZone: Double): Double {
        return sunLongitude(dayNumber - 0.5 - timeZone / 24)
    }

    private fun getNewMoonDay(k: Int, timeZone: Double): Int {
        val jd = newMoon(k)
        return iNT(jd + 0.5 + timeZone / 24)
    }

    private fun getLunarMonth11(yy: Int, timeZone: Double): Int {
        val off = jdFromDate(31, 12, yy) - 2415021.076998695
        val k = iNT(off / 29.530588853)
        var nm = getNewMoonDay(k, timeZone)
        val sunLong = iNT(getSunLongitude(nm, timeZone) / 30)
        if (sunLong >= 9) {
            nm = getNewMoonDay(k - 1, timeZone)
        }
        return nm
    }

    private fun getLeapMonthOffset(a11: Int, timeZone: Double): Int {
        val k = iNT(0.5 + (a11 - 2415021.076998695) / 29.530588853)
        var last: Int // Month 11 contains point of sun longutide 3*PI/2 (December
        // solstice)
        var i = 1 // We start with the month following lunar month 11
        var arc = iNT(getSunLongitude(getNewMoonDay(k + i, timeZone), timeZone) / 30)
        //		int arc = INT(getSunLongitude(getNewMoonDay(k + i, timeZone), timeZone) );
        do {
            last = arc
            i++
            arc = iNT(getSunLongitude(getNewMoonDay(k + i, timeZone), timeZone) / 30)
            //			arc = INT(getSunLongitude(getNewMoonDay(k + i, timeZone), timeZone));
        } while (arc != last && i < 14)
        return i - 1
    }

    /**
     *
     * @param solarDay
     * @param solarMonth
     * @param solarYear
     * @param timeZone
     * @return array of [lunarDay, lunarMonth, lunarYear, leapOrNot]
     */
    fun convertSolar2Lunar(
        solarDay: Int, solarMonth: Int, solarYear: Int,
        timeZone: Double
    ): IntArray {
        val lunarDay: Int
        var lunarMonth: Int
        var lunarYear: Int
        var lunarLeap: Int
        val dayNumber = jdFromDate(solarDay, solarMonth, solarYear)
        val k = iNT((dayNumber - 2415021.076998695) / 29.530588853)
        var monthStart = getNewMoonDay(k + 1, timeZone)
        if (monthStart > dayNumber) {
            monthStart = getNewMoonDay(k, timeZone)
        }
        var a11 = getLunarMonth11(solarYear, timeZone)
        var b11 = a11
        if (a11 >= monthStart) {
            lunarYear = solarYear
            a11 = getLunarMonth11(solarYear - 1, timeZone)
        } else {
            lunarYear = solarYear + 1
            b11 = getLunarMonth11(solarYear + 1, timeZone)
        }
        lunarDay = dayNumber - monthStart + 1
        val diff = iNT(((monthStart - a11) / 29).toDouble())
        lunarLeap = 0
        lunarMonth = diff + 11
        if (b11 - a11 > 365) {
            val leapMonthDiff = getLeapMonthOffset(a11, timeZone)
            if (diff >= leapMonthDiff) {
                lunarMonth = diff + 10
                if (diff == leapMonthDiff) {
                    lunarLeap = 1
                }
            }
        }
        if (lunarMonth > 12) {
            lunarMonth -= 12
        }
        if (lunarMonth >= 11 && diff < 4) {
            lunarYear -= 1
        }
        return intArrayOf(lunarDay, lunarMonth, lunarYear, lunarLeap)
    }

    fun convertLunar2Solar(
        lunarDay: Int, lunarMonth: Int,
        lunarYear: Int, lunarLeap: Int, timeZone: Double
    ): IntArray {
        val a11: Int
        val b11: Int
        if (lunarMonth < 11) {
            a11 = getLunarMonth11(lunarYear - 1, timeZone)
            b11 = getLunarMonth11(lunarYear, timeZone)
        } else {
            a11 = getLunarMonth11(lunarYear, timeZone)
            b11 = getLunarMonth11(lunarYear + 1, timeZone)
        }
        val k = iNT(0.5 + (a11 - 2415021.076998695) / 29.530588853)
        var off = lunarMonth - 11
        if (off < 0) {
            off += 12
        }
        if (b11 - a11 > 365) {
            val leapOff = getLeapMonthOffset(a11, timeZone)
            var leapMonth = leapOff - 2
            if (leapMonth < 0) {
                leapMonth += 12
            }
            if (lunarLeap != 0 && lunarMonth != leapMonth) {
                return intArrayOf(0, 0, 0)
            } else if (lunarLeap != 0 || off >= leapOff) {
                off += 1
            }
        }
        val monthStart = getNewMoonDay(k + off, timeZone)
        return jdToDate(monthStart + lunarDay - 1)
    }


    fun firstTimeInDay(time: Long): Long {
        val cal = Calendar.getInstance()
        cal.timeInMillis = time
        cal.set(Calendar.MILLISECOND, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.HOUR, 0)
        cal.add(Calendar.HOUR, -1)
        return cal.timeInMillis
    }

    fun getPositionInCan(time: Long): Int {
        return if (time >= BASE_TIME) {
            (((time - BASE_TIME) / MILLISECONDS_IN_DAY) % 5).toInt()
        } else {
            val process = 5 - (((BASE_TIME - time) / MILLISECONDS_IN_DAY) % 5).toInt()
            if (process == 5) return 0
            else return process
        }
    }

    fun getCanChiHourInDay(time: Long, listHour: List<String>): List<String> {
        val position = getPositionInCan(firstTimeInDay(time))
        val listResult = mutableListOf<String>()
        listHour.map { hour ->
            val s = listCanChi.first { hour == it.first }
            listResult.add(s.second[position] + " " + hour)
        }
        return listResult
    }

    val listCanChi: List<Pair<String, List<String>>>
        get() = listOf(
            Pair("Tý", listCanForTy),
            Pair("Sửu", listCanForSuu),
            Pair("Dần", listCanForDan),
            Pair("Mão", listCanForMao),
            Pair("Thìn", listCanForThin),
            Pair("Tỵ", listCanForTi),
            Pair("Ngọ", listCanForNgo),
            Pair("Mùi", listCanForMui),
            Pair("Thân", listCanForThan),
            Pair("Dậu", listCanForDau),
            Pair("Tuất", listCanForTuat),
            Pair("Hợi", listCanForHoi),
        )
    private val listCanForTy = listOf("Giáp", "Bính", "Mậu", "Canh", "Nhâm")
    private val listCanForDan = listOf("Bính", "Mậu", "Canh", "Nhâm", "Giáp")
    private val listCanForThin = listOf("Mậu", "Canh", "Nhâm", "Giáp", "Bính")
    private val listCanForNgo = listOf("Canh", "Nhâm", "Giáp", "Bính", "Mậu")
    private val listCanForThan = listOf("Nhâm", "Giáp", "Bính", "Mậu", "Canh")
    private val listCanForTuat = listOf("Giáp", "Bính", "Mậu", "Canh", "Nhâm")
    private val listCanForSuu = listOf("Ất", "Đinh", "Kỷ", "Tân", "Quý")
    private val listCanForMao = listOf("Đinh", "Kỷ", "Tân", "Quý", "Ất")
    private val listCanForTi = listOf("Kỷ", "Tân", "Quý", "Ất", "Đinh")
    private val listCanForMui = listOf("Tân", "Quý", "Ất", "Đinh", "Kỷ")
    private val listCanForDau = listOf("Quý", "Ất", "Đinh", "Kỷ", "Tân")
    private val listCanForHoi = listOf("Ất", "Đinh", "Kỷ", "Tân", "Quý")
}