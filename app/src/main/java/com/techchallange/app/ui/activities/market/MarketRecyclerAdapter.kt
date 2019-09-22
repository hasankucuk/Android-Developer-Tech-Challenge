package com.techchallange.app.ui.activities.market

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.techchallange.app.R
import com.techchallange.app.base.BaseRecyclerAdapter
import com.techchallange.app.databinding.RowMarketItemBinding
import com.techchallange.app.model.ProductData

class MarketRecyclerAdapter(activity: AppCompatActivity) :
    BaseRecyclerAdapter<ProductData, MarketRecyclerItemViewModel, RowMarketItemBinding>(activity) {
    override fun onItemBinding(
        binding: RowMarketItemBinding,
        viewModel: MarketRecyclerItemViewModel,
        position: Int
    ) {

        binding.mainLayout.setOnClickListener {
            if (binding.linearOrderStatusLayout.isVisible) {
                binding.linearOrderStatusLayout.gone()
                binding.ivArrow.rotation = 0F
            } else {
                binding.linearOrderStatusLayout.visible()
                binding.ivArrow.rotation = 90F
            }
        }
    }

    private fun View.visible() {
        visibility = View.VISIBLE
    }

    private fun View.gone() {
        visibility = View.GONE
    }

    override fun getViewModel(): MarketRecyclerItemViewModel {
        return MarketRecyclerItemViewModel()
    }

    override fun getLayoutRes(): Int {
        return R.layout.row_market_item
    }
}