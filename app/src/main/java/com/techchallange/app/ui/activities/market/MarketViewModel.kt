package com.techchallange.app.ui.activities.market

import androidx.lifecycle.MutableLiveData
import com.techchallange.app.api.TechApi
import com.techchallange.app.base.BaseViewModel
import com.techchallange.app.model.ProductData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MarketViewModel(private val api: TechApi) : BaseViewModel() {

     val marketData = MutableLiveData<List<ProductData>>()

    fun getMarketList() {
        compositeDisposable.add(
            api.marketApi("")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { loadingStatus.value = true }
                .doAfterTerminate { loadingStatus.value = false }
                .subscribe({
                    if (it != null) {
                        marketData.value = it
                    }
                }, {})
        )
    }
}