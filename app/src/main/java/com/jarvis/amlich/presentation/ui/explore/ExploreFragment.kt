package com.jarvis.amlich.presentation.ui.explore

import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.databinding.FragmentExploreBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExploreFragment :
    BaseFragment<FragmentExploreBinding, ExploreViewModel>(FragmentExploreBinding::inflate) {

    override val viewModel: ExploreViewModel by viewModel()
}
