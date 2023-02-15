package com.jarvis.amlich.presentation.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.children
import com.jarvis.amlich.R
import com.jarvis.amlich.common.utils.setTextColorRes
import com.jarvis.amlich.databinding.LayoutCalenderDayLegendBinding
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.*

class CalenderDayLegendView : FrameLayout {
    private var binding: LayoutCalenderDayLegendBinding? = null

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context)
    }

    private fun init(context: Context) {
        val systemService =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = LayoutCalenderDayLegendBinding.inflate(systemService, this, true)
        genDisplayDayName()
    }

    private fun genDisplayDayName() {
        binding!!.root.children.forEachIndexed { index, view ->
            (view as TextView).apply {
                text = DayOfWeek.values()[index].getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
                    .uppercase(
                        Locale.ENGLISH
                    )
                setTextColorRes(R.color.ink_3)
            }
        }
    }

}