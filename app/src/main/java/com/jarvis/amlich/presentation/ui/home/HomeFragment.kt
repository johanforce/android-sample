package com.jarvis.amlich.presentation.ui.home

import android.content.Intent
import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.databinding.FragmentHomeBinding
import com.jarvis.amlich.databinding.ItemQueBinding
import com.jarvis.amlich.domain.model.QueModel
import com.jarvis.amlich.presentation.ui.calendar.DiaryActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {

    override val viewModel: HomeViewModel by viewModel()

    private val listQueAdapter by lazy {
        SimpleBDAdapter<ItemQueBinding, QueModel>(ItemQueBinding::inflate) { itemBD, item, _ ->
            itemBD.tvQue.text = item.tenQUe
            itemBD.tvSoQue.text = item.stt.toString()
        }
    }

    override fun setupViews() {
        viewBD.recyclerQue.adapter = listQueAdapter.apply {
            onItemClick = { _, item, _ ->
//                val bundle = DetailFragmentArgs(item.stt.toString()).toBundle()
//                navigate(R.id.detailFragment, bundle)
                val intent = Intent(context, DiaryActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun initData() {
        viewModel.getAllQueData()
    }

    override fun observeData() {
        viewModel.listQueLiveData.observe(viewLifecycleOwner) { movies ->
            listQueAdapter.submitList(movies.sortedBy { it.stt })
        }
    }
}
