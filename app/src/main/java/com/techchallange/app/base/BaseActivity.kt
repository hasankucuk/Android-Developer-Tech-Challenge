package com.techchallange.app.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.techchallange.app.util.NavigationHelper
import com.techchallange.app.util.PreferencesHelper

/**
 * This class is base activity class.
 * The basic features to be used in the activities in this project will be here.
 *
 * @author hasankucuk
 * @since 1.0
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseView,
    AppCompatActivity() {

    protected lateinit var viewModel: VM

    lateinit var binding: DB

    protected abstract fun getViewModel(): Class<VM>

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun onCreateFinished()

    protected open fun getProgressView(): View? {
        return null
    }


    override fun getContext(): Context {
        return this
    }

    override fun showLoading() {
        getProgressView()?.let { it.visibility = View.VISIBLE }
    }


    override fun hideLoading() {
        getProgressView()?.let { it.visibility = View.GONE }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutRes())

        onCreateFinished()
        showHideLoading()
        showError()
    }

    open fun showError() {
        viewModel.errorString.observe(this, Observer<String> {

            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    open fun showHideLoading() {
        viewModel.loadingStatus.observe(this, Observer<Boolean> {

            if (it!!) showLoading() else hideLoading()
        })
    }

    protected fun getNavigationHelper(): NavigationHelper {
        return NavigationHelper.getInstance()
    }

    protected fun getPreferencesHelper(): PreferencesHelper {
        return PreferencesHelper.getInstance(this)
    }


}