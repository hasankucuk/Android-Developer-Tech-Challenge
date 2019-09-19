package com.techchallange.app.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer

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

    override fun getContext(): Context {
        return this
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutRes())

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


}