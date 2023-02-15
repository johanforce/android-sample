package com.jarvis.amlich.presentation.ui.calendar

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.CalendarMonth
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import com.kizitonwose.calendarview.utils.Size
import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.common.utils.dpToPx
import com.jarvis.amlich.databinding.FragmentDiaryYearBinding
import com.jarvis.amlich.databinding.ItemDayInYearCalendarBinding
import com.jarvis.amlich.databinding.MonthHeaderCalendarBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

class DiaryYearFragment :
    BaseFragment<FragmentDiaryYearBinding, DiaryViewModel>(FragmentDiaryYearBinding::inflate) {
    private var horizontalMargin = 0
    private var dayHeight = 0
    private var dayWidth = 0
    private var monthWidth = 0
    private var diaryActivity: DiaryActivity? = null
    private var displayYear = YearMonth.now().year
    private val currentYear = YearMonth.now().year
    private val currentMonth = YearMonth.now().month
    private var lastDayOfYear: LocalDate? = YearMonth.of(currentYear, Month.DECEMBER).atDay(31)
    private var firstDayOfYear: LocalDate? = YearMonth.of(currentYear, Month.JANUARY).atDay(1)

    override val viewModel: DiaryViewModel by viewModel()

    override fun initData() {
        super.initData()
        this.diaryActivity = activity as DiaryActivity
        if (diaryActivity == null) {
            return
        }
        val dm = DisplayMetrics()
        val wm = requireContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.defaultDisplay.getMetrics(dm)

        monthWidth = (dm.widthPixels * 0.29).toInt()
        dayWidth = monthWidth / 7
        dayHeight = (dayWidth * 1.3).toInt()
        horizontalMargin = dpToPx(6, requireContext())
        executeTitleCalendar()
    }


    private fun initCalendar() {
        if (displayYear == currentYear) {
            if (currentMonth.value <= Month.MARCH.value) {
                initYearLine1(true)
                viewBD.cvYear2.visibility = View.GONE
                viewBD.cvYear3.visibility = View.GONE
                viewBD.cvYear4.visibility = View.GONE
            } else if (currentMonth.value <= Month.JUNE.value) {
                initYearLine1(false)
                initYearLine2(true)
                viewBD.cvYear3.visibility = View.GONE
                viewBD.cvYear4.visibility = View.GONE
            } else if (currentMonth.value <= Month.SEPTEMBER.value) {
                initYearLine1(false)
                initYearLine2(false)
                initYearLine3(true)
                viewBD.cvYear4.visibility = View.GONE
            } else {
                initYearLine1(false)
                initYearLine2(false)
                initYearLine3(false)
                initYearLine4(true)
            }
        } else {
            initYearLine1(false)
            initYearLine2(false)
            initYearLine3(false)
            initYearLine4(false)
        }
    }

    private fun initYearLine1(hasCurrentMonth: Boolean) {
        viewBD.cvYear1.visibility = View.VISIBLE
        viewBD.cvYear1.apply {
            daySize = Size(dayWidth, dayHeight)

            setMonthMargins(start = horizontalMargin, end = horizontalMargin, top = 0, bottom = 0)

            class DayViewContainer(view: View) : ViewContainer(view) {
                lateinit var day: CalendarDay
                val dotView = ItemDayInYearCalendarBinding.bind(view).ivDotDay

                init {
                    view.setOnClickListener {
                    }
                }
            }

            viewBD.cvYear1.dayBinder = object : DayBinder<DayViewContainer> {
                override fun create(view: View) = DayViewContainer(view)
                override fun bind(container: DayViewContainer, day: CalendarDay) {

                }
            }

            val daysOfWeek = DayOfWeek.values()
            if (hasCurrentMonth) {
                viewBD.cvYear1.setup(
                    YearMonth.of(displayYear, Month.JANUARY),
                    YearMonth.of(displayYear, currentMonth),
                    daysOfWeek.first()
                )
            } else {
                viewBD.cvYear1.setup(
                    YearMonth.of(displayYear, Month.JANUARY),
                    YearMonth.of(displayYear, Month.MARCH),
                    daysOfWeek.first()
                )
            }

            class MonthViewContainer(view: View) : ViewContainer(view) {
                val bindingMonth = MonthHeaderCalendarBinding.bind(view)
                val textView = bindingMonth.tvMonthTitle
                lateinit var month: CalendarMonth

                init {
                    view.setOnClickListener {

                    }
                }
            }

            viewBD.cvYear1.monthHeaderBinder = object :
                MonthHeaderFooterBinder<MonthViewContainer> {
                override fun create(view: View) = MonthViewContainer(view)
                override fun bind(container: MonthViewContainer, month: CalendarMonth) {
                    container.month = month
                    container.textView.text =
                        month.yearMonth.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
                            .uppercase(Locale.getDefault())
                }
            }
        }
    }

    private fun initYearLine2(hasCurrentMonth: Boolean) {
        viewBD.cvYear2.visibility = View.VISIBLE
        viewBD.cvYear2.apply {
            daySize = Size(dayWidth, dayHeight)

            setMonthMargins(start = horizontalMargin, end = horizontalMargin, top = 0, bottom = 0)

            class DayViewContainer(view: View) : ViewContainer(view) {
                lateinit var day: CalendarDay
                val dotView = ItemDayInYearCalendarBinding.bind(view).ivDotDay
            }

            viewBD.cvYear2.dayBinder = object : DayBinder<DayViewContainer> {
                override fun create(view: View) = DayViewContainer(view)
                override fun bind(container: DayViewContainer, day: CalendarDay) {
                    container.day = day

                }
            }

            val daysOfWeek = DayOfWeek.values()
            if (hasCurrentMonth) {
                viewBD.cvYear2.setup(
                    YearMonth.of(displayYear, Month.APRIL),
                    YearMonth.of(displayYear, currentMonth),
                    daysOfWeek.first()
                )
            } else {
                viewBD.cvYear2.setup(
                    YearMonth.of(displayYear, Month.APRIL),
                    YearMonth.of(displayYear, Month.JUNE),
                    daysOfWeek.first()
                )
            }

            class MonthViewContainer(view: View) : ViewContainer(view) {
                val binding = MonthHeaderCalendarBinding.bind(view)
                val textView = binding.tvMonthTitle
                lateinit var month: CalendarMonth

                init {
                    view.setOnClickListener {

                    }
                }
            }

            viewBD.cvYear2.monthHeaderBinder = object :
                MonthHeaderFooterBinder<MonthViewContainer> {
                override fun create(view: View) = MonthViewContainer(view)
                override fun bind(container: MonthViewContainer, month: CalendarMonth) {
                    container.month = month
                    container.textView.text =
                        month.yearMonth.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
                            .uppercase(Locale.getDefault())
                }
            }
        }
    }

    private fun initYearLine3(hasCurrentMonth: Boolean) {
        viewBD.cvYear3.visibility = View.VISIBLE
        viewBD.cvYear3.apply {
            daySize = Size(dayWidth, dayHeight)

            setMonthMargins(start = horizontalMargin, end = horizontalMargin, top = 0, bottom = 0)

            class DayViewContainer(view: View) : ViewContainer(view) {
                lateinit var day: CalendarDay
                val dotView = ItemDayInYearCalendarBinding.bind(view).ivDotDay
            }

            viewBD.cvYear3.dayBinder = object : DayBinder<DayViewContainer> {
                override fun create(view: View) = DayViewContainer(view)
                override fun bind(container: DayViewContainer, day: CalendarDay) {
                    container.day = day

                }
            }

            val daysOfWeek = DayOfWeek.values()
            if (hasCurrentMonth) {
                viewBD.cvYear3.setup(
                    YearMonth.of(displayYear, Month.JULY),
                    YearMonth.of(displayYear, currentMonth),
                    daysOfWeek.first()
                )
            } else {
                viewBD.cvYear3.setup(
                    YearMonth.of(displayYear, Month.JULY),
                    YearMonth.of(displayYear, Month.SEPTEMBER),
                    daysOfWeek.first()
                )
            }

            class MonthViewContainer(view: View) : ViewContainer(view) {
                val binding = MonthHeaderCalendarBinding.bind(view)
                val textView = binding.tvMonthTitle
                lateinit var month: CalendarMonth

                init {
                    view.setOnClickListener {

                    }
                }
            }

            viewBD.cvYear3.monthHeaderBinder = object :
                MonthHeaderFooterBinder<MonthViewContainer> {
                override fun create(view: View) = MonthViewContainer(view)
                override fun bind(container: MonthViewContainer, month: CalendarMonth) {
                    container.month = month
                    container.textView.text =
                        month.yearMonth.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
                            .uppercase(Locale.getDefault())
                }
            }
        }
    }

    private fun initYearLine4(hasCurrentMonth: Boolean) {
        viewBD.cvYear4.visibility = View.VISIBLE
        viewBD.cvYear4.apply {
            daySize = Size(dayWidth, dayHeight)

            setMonthMargins(start = horizontalMargin, end = horizontalMargin, top = 0, bottom = 0)

            class DayViewContainer(view: View) : ViewContainer(view) {
                lateinit var day: CalendarDay
                val dotView = ItemDayInYearCalendarBinding.bind(view).ivDotDay
            }

            viewBD.cvYear4.dayBinder = object : DayBinder<DayViewContainer> {
                override fun create(view: View) = DayViewContainer(view)
                override fun bind(container: DayViewContainer, day: CalendarDay) {
                    container.day = day

                }
            }

            val daysOfWeek = DayOfWeek.values()
            if (hasCurrentMonth) {
                viewBD.cvYear4.setup(
                    YearMonth.of(displayYear, Month.OCTOBER),
                    YearMonth.of(displayYear, currentMonth),
                    daysOfWeek.first()
                )
            } else {
                viewBD.cvYear4.setup(
                    YearMonth.of(displayYear, Month.OCTOBER),
                    YearMonth.of(displayYear, Month.DECEMBER),
                    daysOfWeek.first()
                )
            }

            class MonthViewContainer(view: View) : ViewContainer(view) {
                val binding = MonthHeaderCalendarBinding.bind(view)
                val textView = binding.tvMonthTitle
                lateinit var month: CalendarMonth

                init {
                    view.setOnClickListener {

                    }
                }
            }

            viewBD.cvYear4.monthHeaderBinder = object :
                MonthHeaderFooterBinder<MonthViewContainer> {
                override fun create(view: View) = MonthViewContainer(view)
                override fun bind(container: MonthViewContainer, month: CalendarMonth) {
                    container.month = month
                    container.textView.text =
                        month.yearMonth.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
                            .uppercase(Locale.getDefault())
                }
            }
        }
    }

    private fun executeTitleCalendar() {
        viewBD.layoutTitle.tvCalendar.text = displayYear.toString()
        viewBD.layoutTitle.btCalendarNext.isEnabled =
            displayYear < YearMonth.now().year

        viewBD.layoutTitle.btCalendarBack.setOnClickListener(View.OnClickListener {
            displayYear--
            firstDayOfYear = YearMonth.of(displayYear, Month.JANUARY).atDay(1)
            lastDayOfYear = YearMonth.of(displayYear, Month.DECEMBER).atDay(31)
            viewBD.layoutTitle.btCalendarNext.isEnabled = displayYear < currentYear
            viewBD.layoutTitle.tvCalendar.text = displayYear.toString()
        })

        viewBD.layoutTitle.btCalendarNext.setOnClickListener(View.OnClickListener {
            displayYear++
            firstDayOfYear = YearMonth.of(displayYear, Month.JANUARY).atDay(1)
            lastDayOfYear = YearMonth.of(displayYear, Month.DECEMBER).atDay(31)
            viewBD.layoutTitle.btCalendarNext.isEnabled = displayYear < currentYear
            initCalendar()
            viewBD.layoutTitle.tvCalendar.text = displayYear.toString()
        })
    }


    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)
    }
}

// We assign this class to the `monthViewClass` attribute in XML.
// See usage in example_6_fragment.xml
class Example6MonthView(context: Context) : CardView(context) {
    init {
        setCardBackgroundColor(ContextCompat.getColor(context, R.color.pri_1))
        radius = dpToPx(8, context).toFloat()
        elevation = 8f
    }
}