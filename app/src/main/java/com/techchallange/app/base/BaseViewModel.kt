package com.techchallange.app.base

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.*
import io.reactivex.disposables.CompositeDisposable

/**
 * This class is base view model
 *
 * @author hasankucuk
 * @since 1.0
 */
abstract class BaseViewModel : ViewModel(), Observable, LifecycleObserver {

    var loadingStatus = MutableLiveData<Boolean>()

    val errorString = MutableLiveData<String>()

    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()

    protected val compositeDisposable = CompositeDisposable()

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    fun changeLoadingStatus(status:Boolean){
        loadingStatus.value = status
        loadingStatus.value = loadingStatus.value
    }

    fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }


    fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unSubscribeViewModel() {
        compositeDisposable.dispose()
    }

}