package com.techchallange.app.ui.activities.market

import android.app.AlertDialog
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.techchallange.app.R
import com.techchallange.app.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MarketActivity :
    BaseActivity<MarketViewModel, com.techchallange.app.databinding.ActivityMarketBinding>() {

    private val marketViewModel: MarketViewModel by viewModel()

    override fun getViewModel(): Class<MarketViewModel> {
        return MarketViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_market
    }

    override fun getProgressView(): View? {
        return binding.progressBar
    }

    override fun onCreateFinished() {
        viewModel = marketViewModel

        initView()
        clickListener()
    }

    private fun clickListener() {
        binding.btnMyOrder.setOnClickListener { viewModel.getMarketList() }

        binding.btnLogout.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle(getString(R.string.market_alert_dialog_title))
                .setMessage(getString(R.string.market_alert_dialog_desc))
                .setPositiveButton(getString(R.string.market_alert_positive_button)) { dialog, which ->
                    dialog.dismiss()
                    getPreferencesHelper().clear()
                    getNavigationHelper().navigateToLoginActivity(this)
                    finish()
                }
                .setNegativeButton(getString(R.string.market_alert_negative_button), null)
                .show()
        }
    }

    private fun initView() {
        val adapter = MarketRecyclerAdapter(this)

        binding.adapter = adapter
        binding.layoutManager = LinearLayoutManager(this)

        viewModel.getMarketList()
        viewModel.marketData.observe(this, Observer {
            binding.adapter?.update(it)
        })
    }


}
