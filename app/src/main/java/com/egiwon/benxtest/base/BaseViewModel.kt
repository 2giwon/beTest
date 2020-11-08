package com.egiwon.benxtest.base

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val compositeDisposable: CompositeDisposable by lazy(::CompositeDisposable)

    protected val toastMessageMutableLiveData = MutableLiveData<@StringRes Int>()
    val toastMessageLiveData: LiveData<Int> get() = toastMessageMutableLiveData

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}