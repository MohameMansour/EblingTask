package com.dro.eblingtask.baseApp

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract fun initListeners()

    abstract fun initObservers()

}