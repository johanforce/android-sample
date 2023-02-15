package com.jarvis.amlich.common.core

object HourGoodBadHelper {
    fun hourGoodBadStatus(chiDay: Int): Pair<List<String>, List<String>> {
        return when {
            (chiDay == ChiEnum.DAN.value || chiDay == ChiEnum.THAN.value) ->
                Pair(
                    listOf(
                        ChiEnum.TY.valueStr,
                        ChiEnum.SUU.valueStr,
                        ChiEnum.THIN.valueStr,
                        ChiEnum.TI.valueStr,
                        ChiEnum.MUI.valueStr,
                        ChiEnum.TUAT.valueStr
                    ),
                    listOf(
                        ChiEnum.DAN.valueStr,
                        ChiEnum.MAO.valueStr,
                        ChiEnum.THIN.valueStr,
                        ChiEnum.NGO.valueStr,
                        ChiEnum.THAN.valueStr,
                        ChiEnum.DAU.valueStr
                    )
                )

            (chiDay == ChiEnum.MAO.value || chiDay == ChiEnum.DAU.value) ->
                Pair(
                    listOf(
                        ChiEnum.TY.valueStr,
                        ChiEnum.DAN.valueStr,
                        ChiEnum.MAO.valueStr,
                        ChiEnum.NGO.valueStr,
                        ChiEnum.MUI.valueStr,
                        ChiEnum.DAU.valueStr
                    ),
                    listOf(
                        ChiEnum.SUU.valueStr,
                        ChiEnum.THIN.valueStr,
                        ChiEnum.TI.valueStr,
                        ChiEnum.THAN.valueStr,
                        ChiEnum.TUAT.valueStr,
                        ChiEnum.HOI.valueStr
                    )
                )
            (chiDay == ChiEnum.THIN.value || chiDay == ChiEnum.TUAT.value) -> Pair(
                listOf(
                    ChiEnum.THIN.valueStr,
                    ChiEnum.DAN.valueStr,
                    ChiEnum.TI.valueStr,
                    ChiEnum.THAN.valueStr,
                    ChiEnum.HOI.valueStr,
                    ChiEnum.DAU.valueStr,
                ),
                listOf(
                    ChiEnum.TY.valueStr,
                    ChiEnum.SUU.valueStr,
                    ChiEnum.MAO.valueStr,
                    ChiEnum.NGO.valueStr,
                    ChiEnum.MUI.valueStr,
                    ChiEnum.TUAT.valueStr,
                )
            )

            (chiDay == ChiEnum.TI.value || chiDay == ChiEnum.HOI.value) ->
                Pair(
                    listOf(
                        ChiEnum.SUU.valueStr,
                        ChiEnum.THIN.valueStr,
                        ChiEnum.NGO.valueStr,
                        ChiEnum.MUI.valueStr,
                        ChiEnum.TUAT.valueStr,
                        ChiEnum.HOI.valueStr
                    ), listOf(
                        ChiEnum.TY.valueStr,
                        ChiEnum.DAN.valueStr,
                        ChiEnum.MAO.valueStr,
                        ChiEnum.TI.valueStr,
                        ChiEnum.THAN.valueStr,
                        ChiEnum.DAU.valueStr
                    )
                )

            (chiDay == ChiEnum.TY.value || chiDay == ChiEnum.NGO.value) ->
                Pair(
                    listOf(
                        ChiEnum.TY.valueStr,
                        ChiEnum.SUU.valueStr,
                        ChiEnum.MAO.valueStr,
                        ChiEnum.NGO.valueStr,
                        ChiEnum.THAN.valueStr,
                        ChiEnum.DAU.valueStr,
                    ), listOf(
                        ChiEnum.DAN.valueStr,
                        ChiEnum.THIN.valueStr,
                        ChiEnum.TI.valueStr,
                        ChiEnum.HOI.valueStr,
                        ChiEnum.MUI.valueStr,
                        ChiEnum.TUAT.valueStr,
                    )
                )

            (chiDay == ChiEnum.SUU.value || chiDay == ChiEnum.MUI.value) ->
                Pair(
                    listOf(
                        ChiEnum.MAO.valueStr,
                        ChiEnum.DAN.valueStr,
                        ChiEnum.TI.valueStr,
                        ChiEnum.THAN.valueStr,
                        ChiEnum.HOI.valueStr,
                        ChiEnum.TUAT.valueStr,
                    ), listOf(
                        ChiEnum.TY.valueStr,
                        ChiEnum.MAO.valueStr,
                        ChiEnum.THIN.valueStr,
                        ChiEnum.NGO.valueStr,
                        ChiEnum.MUI.valueStr,
                        ChiEnum.DAU.valueStr,
                    )
                )
            else -> Pair(emptyList(), emptyList())
        }
    }

    fun getTaiHyPhuongHuong(canValueDay: String): Pair<String, String> {
        return when (canValueDay) {
            CanEnum.AT.valueStr -> Pair(PhuongHuong.DONG_NAM.valueStr, PhuongHuong.TAY_BAC.valueStr)
            CanEnum.GIAP.valueStr -> Pair(PhuongHuong.DONG_NAM.valueStr, PhuongHuong.DONG_BAC.valueStr)
            CanEnum.BINH.valueStr -> Pair(PhuongHuong.DONG.valueStr, PhuongHuong.TAY_NAM.valueStr)
            CanEnum.DINH.valueStr -> Pair(PhuongHuong.DONG.valueStr, PhuongHuong.NAM.valueStr)
            CanEnum.CANH.valueStr -> Pair(PhuongHuong.TAY_NAM.valueStr, PhuongHuong.TAY_BAC.valueStr)
            CanEnum.KY.valueStr -> Pair(PhuongHuong.NAM.valueStr, PhuongHuong.DONG_BAC.valueStr)
            CanEnum.TAN.valueStr -> Pair(PhuongHuong.TAY_NAM.valueStr, PhuongHuong.TAY_NAM.valueStr)
            CanEnum.NHAM.valueStr -> Pair(PhuongHuong.TAY.valueStr, PhuongHuong.NAM.valueStr)
            CanEnum.QUY.valueStr -> Pair(PhuongHuong.TAY_BAC.valueStr, PhuongHuong.DONG_NAM.valueStr)
            else -> Pair(PhuongHuong.BAC.valueStr, PhuongHuong.DONG_NAM.valueStr)
        }
    }

}