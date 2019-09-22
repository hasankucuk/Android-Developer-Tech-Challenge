package com.techchallange.app.util

import android.content.Context
import android.content.Intent
import com.techchallange.app.ui.activities.login.LoginActivity
import com.techchallange.app.ui.activities.market.MarketActivity


object NavigationHelper {
    private var instance: NavigationHelper? = null

    fun getInstance(): NavigationHelper {
        if (instance == null)
            instance = NavigationHelper
        return instance as NavigationHelper
    }


    fun navigateToMarketActivity(contex: Context) {
        val startMainActivity = Intent(contex, MarketActivity::class.java)
        contex.startActivity(startMainActivity)
    }

    fun navigateToLoginActivity(contex: Context) {
        contex.startActivity(Intent(contex, LoginActivity::class.java))
    }


}
