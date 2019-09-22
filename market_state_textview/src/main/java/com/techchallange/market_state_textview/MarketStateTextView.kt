package com.techchallange.market_state_textview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.techchallange.market_state_textview.State.*

class MarketStateTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    def: Int = 0
) :
    RelativeLayout(context, attrs, def) {

    lateinit var view: View
    lateinit var tvState: TextView


    init {
        View.inflate(context, R.layout.market_state_textview, this)
        view = findViewById(R.id.view_state)
        tvState = findViewById(R.id.tv_state)

    }

    fun setText(text: String) {
        tvState.text = text


        when (State.getFromValue(text)) {
            SUCCESS -> {
                view.background =
                    ContextCompat.getDrawable(view.context, R.drawable.bg_status_on_the_road)
                tvState.setTextColor(Color.parseColor("#4CAF50"))

            }
            PENDING -> {
                view.background =
                    ContextCompat.getDrawable(view.context, R.drawable.bg_status_pending)
                tvState.setTextColor(Color.parseColor("#E53935"))
            }
            PREPARING -> {
                view.background =
                    ContextCompat.getDrawable(view.context, R.drawable.bg_status_preparing)
                tvState.setTextColor(Color.parseColor("#ffb300"))

            }
        }
    }

}