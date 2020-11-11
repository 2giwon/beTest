package com.egiwon.benxtest.shop

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.egiwon.benxtest.BR
import com.egiwon.benxtest.R
import com.egiwon.benxtest.base.BaseAdapter
import com.egiwon.benxtest.base.BaseFragment
import com.egiwon.benxtest.databinding.FragmentShopBinding
import com.egiwon.benxtest.shop.artist.ARTIST
import com.egiwon.benxtest.shop.artist.ArtistBottomFragment
import com.egiwon.benxtest.shop.banner.BannerAdapter
import com.egiwon.benxtest.shop.model.Artist
import com.egiwon.benxtest.shop.model.Notice
import com.egiwon.benxtest.shop.model.SaleItem
import com.egiwon.benxtest.shop.model.ShopItem
import com.egiwon.benxtest.shop.product.ProductFragment
import com.egiwon.benxtest.shop.product.tab.ProductCategoryAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding, ShopViewModel>(R.layout.fragment_shop),
    ArtistBottomFragment.OnArtistClickActionListener {

    override val viewModel: ShopViewModel by viewModels()

    private lateinit var dialog: ArtistBottomFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            vm = viewModel
            initAdapter()
            setClickScrollToTop()
            swipeContainer.setOnRefreshListener { viewModel.loadShopInfo() }
            tvToolbarTitle.setOnClickListener {
                viewModel.getArtists()
            }
        }
        viewModel.loadShopInfo()
    }

    private fun FragmentShopBinding.initAdapter() {
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvBanner)
        rvBanner.adapter = BannerAdapter(R.layout.item_banner, BR.banner)
        rvBanner.setHasFixedSize(true)

        rvRecentlySales.adapter = object : BaseAdapter<SaleItem>(
            R.layout.item_recently_sale,
            BR.saleItem
        ) {}
        rvRecentlySales.setHasFixedSize(true)

        rvNotices.adapter = object : BaseAdapter<Notice>(
            R.layout.item_notice,
            BR.notice
        ) {}
        rvNotices.setHasFixedSize(true)
    }

    private fun initViewPager(saleItems: List<ShopItem>) {
        val fragments = mutableListOf<ProductFragment>()
        for (i in saleItems.indices) {
            fragments.add(ProductFragment.newInstance(saleItems[i].category.id))
        }

        with(binding) {
            vpShops.adapter = ProductCategoryAdapter(this@ShopFragment, fragments)
            TabLayoutMediator(tlShops, vpShops) { tab, position ->
                tab.text = saleItems[position].category.name
            }.attach()
        }

    }

    override fun onArtistClick(artist: Artist) {
        dialog.dismiss()
        viewModel.loadShopInfo(artistId = artist.id)
    }

    override fun setupObserve() {
        super.setupObserve()

        viewModel.artistId.observe(viewLifecycleOwner, Observer {
            binding.tvToolbarTitle.text = when (it) {
                ARTIST.BTS.value -> getString(R.string.BTS)
                else -> getString(R.string.TXT)
            }
        })

        viewModel.shopItems.observe(viewLifecycleOwner, Observer {
            initViewPager(it)
        })

        viewModel.loadingBar.observe(viewLifecycleOwner, Observer {
            binding.swipeContainer.isRefreshing = it
        })

        viewModel.artists.observe(viewLifecycleOwner, Observer {
            dialog = ArtistBottomFragment.newInstance(it)
            dialog.setTargetFragment(this@ShopFragment, 0)
            dialog.show(parentFragmentManager, ArtistBottomFragment::javaClass.name)
        })
    }

    private fun FragmentShopBinding.setClickScrollToTop() {
        ivUpward.setOnClickListener {
            scrollView.post {
                scrollView.smoothScrollTo(0, 0)
            }
        }
    }
}

