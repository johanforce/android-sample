package com.jarvis.amlich.presentation.ui.detail

import androidx.navigation.fragment.navArgs
import com.jarvis.amlich.R
import com.jarvis.amlich.base.BaseFragment
import com.jarvis.amlich.base.recyclerview.SimpleBDAdapter
import com.jarvis.amlich.databinding.FragmentDetailBinding
import com.jarvis.amlich.databinding.ItemDanhMucBinding
import com.jarvis.amlich.domain.model.DetailModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(FragmentDetailBinding::inflate) {

    override val viewModel: DetailViewModel by viewModel()

    private val args by navArgs<DetailFragmentArgs>()

    private val listDetailQueAdapter by lazy {
        SimpleBDAdapter<ItemDanhMucBinding, DetailModel>(ItemDanhMucBinding::inflate) { itemBD, item, _ ->
            itemBD.tvHonNhan.text = item.title
            itemBD.tvHonNhanTho.text = item.thoDich.toString()
            itemBD.tvHonNhanBan.text = item.banLuan.toString()
        }
    }

    override fun setupViews() {
        viewBD.recyclerTopRatedMovies.adapter = listDetailQueAdapter
    }

    override fun initData() {
        viewModel.getDataDetailQue(args.idQue.toInt())
    }

    override fun observeData() {
        viewModel.details.observe(viewLifecycleOwner) {
            listDetailQueAdapter.submitList(it)
        }
        viewModel.queModel.observe(viewLifecycleOwner) {
            viewBD.tvTich.text = it.tichXua
            viewBD.tvTitle.text = getString(R.string.so_que_title, it.stt, it.tenQUe)
            viewBD.tvStatus.text = it.status
        }
    }
}
