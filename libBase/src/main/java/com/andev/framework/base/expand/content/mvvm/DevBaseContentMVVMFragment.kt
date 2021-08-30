package com.andev.framework.base.expand.content.mvvm

import android.app.Application
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andev.framework.base.able.mvvm.IDevBaseViewModel
import com.andev.framework.base.utils.assist.DevBaseViewModelAssist

/**
 * detail: Content Fragment MVVM 基类
 * @author Ttt
 */
abstract class DevBaseContentMVVMFragment<VDB : ViewDataBinding, VM : ViewModel> :
    DevBaseContentViewDataBindingFragment<VDB>(),
    IDevBaseViewModel<VM> {

    lateinit var viewModel: VM

    @JvmField // DevBase ViewModel 辅助类
    protected var viewModelAssist = DevBaseViewModelAssist()

    // =====================
    // = IDevBaseViewModel =
    // =====================

    // =====================
    // = Activity Provider =
    // =====================

    override fun <T : ViewModel?> getActivityViewModel(modelClass: Class<T>): T? {
        return viewModelAssist.getActivityViewModelCache(activity, modelClass)
    }

    // =====================
    // = Fragment Provider =
    // =====================

    override fun <T : ViewModel?> getFragmentViewModel(modelClass: Class<T>): T? {
        return viewModelAssist.getFragmentViewModelCache(this, modelClass)
    }

    override fun <T : ViewModel?> getFragmentViewModel(
        fragment: Fragment?,
        modelClass: Class<T>
    ): T? {
        return viewModelAssist.getFragmentViewModel(fragment, modelClass)
    }

    // ========================
    // = Application Provider =
    // ========================

    override fun <T : ViewModel?> getAppViewModel(
        application: Application?,
        modelClass: Class<T>
    ): T? {
        return viewModelAssist.getAppViewModel(application, modelClass)
    }

    override fun getAppViewModelProvider(application: Application?): ViewModelProvider? {
        return viewModelAssist.getAppViewModelProvider(application)
    }

    override fun getAppFactory(application: Application?): ViewModelProvider.Factory? {
        return viewModelAssist.getAppFactory(application)
    }
}