package com.jarvis.amlich.presentation.ui.detail

import com.jarvis.amlich.base.BaseViewModel
import com.jarvis.amlich.common.utils.SingleLiveData
import com.jarvis.amlich.domain.model.DetailModel
import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.domain.usecase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class DetailViewModel : BaseViewModel() {
    private val buonBanUseCase: BuonBanUseCase by inject()
    private val lucSucUseCase: LucSucUseCase by inject()
    private val giaDaoUseCase: GiaDaoUseCase by inject()
    private val honNhanUseCase: HonNhanUseCase by inject()
    private val kienTungUseCase: KienTungUseCase by inject()
    private val muuVOngUseCase: MuuVOngUseCase by inject()
    private val nguoiDiUseCase: NguoiDiUseCase by inject()
    private val thatVatUseCase: ThatVatUseCase by inject()
    private val tuoiMangUseCase: TuoiMangUseCase by inject()
    private val queIdModel: QueIdUseCase by inject()
    private val doanBenhUseCase: DoanBenhUseCase by inject()

    val details = SingleLiveData<List<DetailModel>>()
    val queModel = SingleLiveData<QueModel>()

    fun getDataDetailQue(idQue: Int) {
        executeTask(onExecute = {
            mLoading.value = true
            val buonBan = withContext(Dispatchers.IO) {
                buonBanUseCase.invoke(idQue)
            }.toModel()

            val lucSuc = withContext(Dispatchers.IO) {
                lucSucUseCase.invoke(idQue)
            }.toModel()

            val giaDao = withContext(Dispatchers.IO) {
                giaDaoUseCase.invoke(idQue)
            }.toModel()

            val honNhan = withContext(Dispatchers.IO) {
                honNhanUseCase.invoke(idQue)
            }.toModel()

            val kienTung = withContext(Dispatchers.IO) {
                kienTungUseCase.invoke(idQue)
            }.toModel()

            val nguoiDi = withContext(Dispatchers.IO) {
                nguoiDiUseCase.invoke(idQue)
            }.toModel()

            val thatVat = withContext(Dispatchers.IO) {
                thatVatUseCase.invoke(idQue)
            }.toModel()

            val muuVOng = withContext(Dispatchers.IO) {
                muuVOngUseCase.invoke(idQue)
            }.toModel()

            val tuoiMang = withContext(Dispatchers.IO) {
                tuoiMangUseCase.invoke(idQue)
            }.toModel()

            val doanBenh = withContext(Dispatchers.IO) {
                doanBenhUseCase.invoke(idQue)
            }.toModel()

            val que = withContext(Dispatchers.IO) {
                queIdModel.invoke(idQue)
            }

            details.value = listOf(
                giaDao,
                tuoiMang,
                buonBan,
                muuVOng,
                lucSuc,
                nguoiDi,
                honNhan,
                kienTung,
                thatVat,
                doanBenh
            )
            queModel.value = que

            mLoading.value = false
        })
    }
}
