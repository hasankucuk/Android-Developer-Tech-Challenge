package com.techchallange.app

import com.techchallange.app.ui.activities.login.LoginActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { LoginActivityViewModel() }

}