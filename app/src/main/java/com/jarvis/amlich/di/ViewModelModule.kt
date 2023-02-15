package com.jarvis.amlich.di

import com.jarvis.amlich.presentation.ui.calendar.DiaryViewModel
import com.jarvis.amlich.presentation.ui.detail.DetailViewModel
import com.jarvis.amlich.presentation.ui.explore.ExploreViewModel
import com.jarvis.amlich.presentation.ui.favorite.FavoriteViewModel
import com.jarvis.amlich.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { ExploreViewModel() }
    viewModel { FavoriteViewModel() }
    viewModel { DetailViewModel() }
    viewModel { DiaryViewModel() }
}
