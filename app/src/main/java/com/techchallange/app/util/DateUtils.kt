package com.techchallange.app.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import android.widget.TextView
import androidx.databinding.BindingAdapter
import io.reactivex.annotations.NonNull

/**
 * This function returns integer month name to string month name.
 *
 * return long month name exp Haziran, Temmuz
 *
 * @author hasankucuk
 * @since 1.0
 */
class DateUtils {

    companion object{
    @SuppressLint("SimpleDateFormat")
    @JvmStatic
    fun toSimpleString(date: String): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MONTH, date.toInt())
        val format = SimpleDateFormat("MMMM")
        return format.format(calendar.time)
    }

    @JvmStatic
    @BindingAdapter("bindServerDate")
    fun bindServerDate(@NonNull textView: TextView, date: String) {
        textView.text = toSimpleString(date)
    }
    }
}