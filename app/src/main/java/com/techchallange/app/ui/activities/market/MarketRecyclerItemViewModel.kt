package com.techchallange.app.ui.activities.market

import com.techchallange.app.base.BaseRecyclerItemViewModel
import com.techchallange.app.model.ProductData

class MarketRecyclerItemViewModel : BaseRecyclerItemViewModel<ProductData>() {
    var data: ProductData? = null

    override fun setValues() {
        data = model
    }
}