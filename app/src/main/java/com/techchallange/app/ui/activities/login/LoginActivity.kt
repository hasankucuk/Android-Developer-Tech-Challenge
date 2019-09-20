package com.techchallange.app.ui.activities.login

import com.techchallange.app.R
import com.techchallange.app.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity :
    BaseActivity<LoginActivityViewModel, com.techchallange.app.databinding.ActivityLoginBinding>() {

   private val loginViewModel: LoginActivityViewModel by viewModel()

    override fun getViewModel(): Class<LoginActivityViewModel> {
        return LoginActivityViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_login
    }

    override fun onCreateFinished() {
        viewModel=loginViewModel

    }

}
