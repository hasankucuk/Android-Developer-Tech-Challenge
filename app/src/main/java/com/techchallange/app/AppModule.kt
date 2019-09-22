package com.techchallange.app

import com.techchallange.app.api.TechApi
import com.techchallange.app.di.createNetworkClient
import com.techchallange.app.ui.activities.login.LoginActivityViewModel
import com.techchallange.app.ui.activities.market.MarketViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    single { createNetworkClient(BuildConfig.BASE_URL) }

    single { (get() as Retrofit).create(TechApi::class.java) }

    viewModel { LoginActivityViewModel() }
    viewModel { MarketViewModel(get()) }

}