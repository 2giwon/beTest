package com.egiwon.benxtest.shop

import androidx.fragment.app.viewModels
import com.egiwon.benxtest.R
import com.egiwon.benxtest.base.BaseFragment
import com.egiwon.benxtest.databinding.FragmentShopBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding, ShopViewModel>(R.layout.fragment_shop) {

    override val viewModel: ShopViewModel by viewModels()
}

