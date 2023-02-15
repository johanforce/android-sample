package com.jarvis.amlich.presentation.ui.favorite

import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment :
    BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>(FragmentFavoriteBinding::inflate) {

    override val viewModel: FavoriteViewModel by viewModel()


    override fun setupViews() {

    }

    override fun initData() {
    }

    override fun observeData() {

    }
}
