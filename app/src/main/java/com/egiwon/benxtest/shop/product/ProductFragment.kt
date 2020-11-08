package com.egiwon.benxtest.shop.product

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.egiwon.benxtest.BR
import com.egiwon.benxtest.R
import com.egiwon.benxtest.base.BaseAdapter
import com.egiwon.benxtest.base.BaseFragment
import com.egiwon.benxtest.databinding.FragmentSalesBinding
import com.egiwon.benxtest.shop.ShopViewModel
import com.egiwon.benxtest.shop.model.SaleItem

class ProductFragment : BaseFragment<FragmentSalesBinding, ShopViewModel>(
    R.layout.fragment_sales
) {
    override val viewModel: ShopViewModel by viewModels({ requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            vm = viewModel
            rvProducts.adapter = object : BaseAdapter<SaleItem>(
                R.layout.item_product,
                BR.saleItem
            ) {}
            rvProducts.setHasFixedSize(true)
        }

        arguments?.getInt(KEY_CATEGORY_ID)?.let {
            viewModel.getShopItems(it)
        }
    }

    companion object {
        private const val KEY_CATEGORY_ID = "key_category_id"

        fun newInstance(id: Int): ProductFragment {
            val args = bundleOf(KEY_CATEGORY_ID to id)

            val fragment = ProductFragment()
            fragment.arguments = args
            return fragment
        }
    }
}