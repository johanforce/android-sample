package com.jarvis.amlich.presentation.ui.calendar

import android.annotation.SuppressLint
import android.view.View
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.common.core.LunarCoreHelper
import com.jarvis.amlich.common.utils.FileUtils
import com.jarvis.amlich.common.utils.setTextColorRes
import com.jarvis.amlich.databinding.ExampleCalendarDayBinding
import com.jarvis.amlich.databinding.FragmentDiaryWeekBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.util.*


class DiaryWeekFragment : BaseFragment<FragmentDiaryWeekBinding, DiaryViewModel>(
    FragmentDiaryWeekBinding::inflate
) {
    private var lastDayOfSelectedWeek: LocalDate? = null
    private var firstDayOfSelectedWeek: LocalDate? = null
    private var selectedDate: CalendarDay? = null
    private val today = LocalDate.now()
    private var diaryActivity: DiaryActivity? = null

    override val viewModel: DiaryViewModel by viewModel()

    override fun initData() {
        this.diaryActivity = activity as DiaryActivity
        if (diaryActivity == null) {
            return
        }
        initCalender()
        executeTitleCalendar()
        executePreviousWeek()
        executeNextWeek()
    }


    private fun initCalender() {
        val daysOfWeek = DayOfWeek.values()
        val currentMonth = YearMonth.now()
        viewBD.cvWeek.setup(
            currentMonth.minusYears(15),
            currentMonth.plusYears(1500),
            daysOfWeek.first()
        )
        viewBD.cvWeek.scrollToDate(today)
        viewBD.cvWeek.notifyCalendarChanged()
        @SuppressLint("SetTextI18n")
        class DayViewContainer(view: View) : ViewContainer(view) {
            // Will be set when this container is bound. See the dayBinder.
            lateinit var day: CalendarDay
            val exSonarDay = ExampleCalendarDayBinding.bind(view).exSonarDay
            val exLunarDay = ExampleCalendarDayBinding.bind(view).exLunarDay
            val bgDay = ExampleCalendarDayBinding.bind(view).bgDay

            init {
                view.setOnClickListener {
                    if (selectedDate?.date == day.date) {
                        selectedDate = null
                        viewBD.cvWeek.notifyDayChanged(day)
                    } else {
                        val oldDate = selectedDate
                        selectedDate = day
                        viewBD.cvWeek.notifyDateChanged(day.date)
                        oldDate?.let { viewBD.cvWeek.notifyDateChanged(oldDate.date) }
                    }
                    viewBD.cvWeek.notifyDayChanged(day)
                    val dayData = day.date
                    viewBD.viewLunar.tvTitle.text =
                        "Ngày: " + viewModel.getNameLunarDay(dayData) + "\n" +
                                "Giờ hoàng đạo: " + viewModel.getListHourHoangDao(dayData)
                            .toString() + "\n" +
                                "Ngày: " + viewModel.getStatusDay(dayData) + "\n" +
                                "Hướng tài thần: " + viewModel.getHuongTaiHy(dayData).first + "\n" +
                                "Hướng hỷ thần: " + viewModel.getHuongTaiHy(dayData).second
                }

            }
        }

        viewBD.cvWeek.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View) = DayViewContainer(view)

            @SuppressLint("SetTextI18n")
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.day = day
                val textView = container.exSonarDay
                val exLunarDay = container.exLunarDay
                val bgDay = container.bgDay
                textView.text = day.date.dayOfMonth.toString()

                val dayData = day.date
                val lunarDay = LunarCoreHelper.convertSolar2Lunar(
                    dayData.dayOfMonth,
                    dayData.monthValue,
                    dayData.year,
                    7.00
                )
                exLunarDay.text = lunarDay[0].toString() + "/" + lunarDay[1].toString()

                when (day.date) {
                    selectedDate?.date -> {
                        bgDay.setBackgroundResource(R.drawable.bg_boder_pri_3)
                    }
                    today -> {
                        textView.setTextColorRes(R.color.pri_4)
                        bgDay.setBackgroundResource(R.color.transparent)
                    }
                    else -> {
                        bgDay.setBackgroundResource(R.color.transparent)
                        textView.background = null
                    }
                }
            }
        }
    }

    private fun executeTitleCalendar() {
        val headerDateFormatter = FileUtils.getFormatShortMonthDay()
        viewBD.cvWeek.monthScrollListener = { month ->
            firstDayOfSelectedWeek = month.weekDays.first().first().date
            lastDayOfSelectedWeek = month.weekDays.first().last().date
            val firstDay = headerDateFormatter?.format(firstDayOfSelectedWeek)
            val lastDay = headerDateFormatter?.format(lastDayOfSelectedWeek)
            val title = "$firstDay - $lastDay"
            viewBD.layoutTitle.tvCalendar.text = title
            clearSelected()
        }
    }

    private fun executePreviousWeek() {
        viewBD.layoutTitle.btCalendarBack.setOnClickListener {
            viewBD.cvWeek.findFirstVisibleDay()?.let {
                viewBD.cvWeek.smoothScrollToDate(it.date.minusWeeks(1))
            }
        }
    }

    private fun executeNextWeek() {
        viewBD.layoutTitle.btCalendarNext.setOnClickListener {
            viewBD.cvWeek.findFirstVisibleDay()?.let {
                viewBD.cvWeek.smoothScrollToDate(it.date.plusWeeks(1))
            }
        }
    }

    private fun clearSelected() {
        val tempoSelectedDate = selectedDate
        selectedDate = null
        tempoSelectedDate?.let { _ -> viewBD.cvWeek.notifyDayChanged(tempoSelectedDate) }
    }
}