package com.techchallange.app.ui.activities.login

import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.techchallange.app.R
import com.techchallange.app.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity :
    BaseActivity<LoginActivityViewModel, com.techchallange.app.databinding.ActivityLoginBinding>() {

    companion object {
        const val USERNAME = "kariyer"
        const val PASSWORD = "2019ADev"
    }

    private val loginViewModel: LoginActivityViewModel by viewModel()

    override fun getViewModel(): Class<LoginActivityViewModel> {
        return LoginActivityViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_login
    }

    override fun onCreateFinished() {
        viewModel = loginViewModel

        initView()
    }

    private fun initView() {

        if (getPreferencesHelper().rememberMe) {
            getNavigationHelper().navigateToMarketActivity(this)
            finish()
            return
        }

        binding.edtPassword.setOnEditorActionListener { view, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    binding.btnLogin.performClick()

                }
            true
        }


        binding.btnLogin.setOnClickListener {
            checkLoginStatus()
        }

    }

    private fun checkLoginStatus() {
        if (binding.edtPassword.text.isNullOrEmpty() || binding.edtUsername.text.isNullOrEmpty()) {
            Toast.makeText(
                this,
                getString(R.string.error_login_pw_or_username_empty),
                Toast.LENGTH_LONG
            ).show()
            return
        }

        if (USERNAME == binding.edtUsername.text.toString() && PASSWORD == binding.edtPassword.text.toString()) {
            getPreferencesHelper().username = USERNAME
            getPreferencesHelper().password = PASSWORD

            if (binding.rememberMeSwitch.isChecked)
                getPreferencesHelper().rememberMe = true

            getNavigationHelper().navigateToMarketActivity(this)
            finish()

        } else {
            Toast.makeText(this, getString(R.string.error_login_pw_or_username), Toast.LENGTH_LONG).show()
        }


    }

}
