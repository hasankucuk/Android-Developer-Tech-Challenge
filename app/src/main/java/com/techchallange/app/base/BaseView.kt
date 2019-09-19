package com.techchallange.app.base

import android.content.Context

/**
 * Base view any view must implement.
 *
 * @author hasankucuk
 * @since 1.0
 */
interface BaseView {

    /**
     * Returns the Context in which the application is running.
     * @return the Context in which the application is running.
     */
    fun getContext() : Context

    /**
     * Displays the loading indicator of the view.
     */
    fun showLoading()

    /**
     * Hides the loading indicator of the view.
     */
    fun hideLoading()

}