package com.egiwon.benxtest.shop.product.tab

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ProductCategoryAdapter(
    fragment: Fragment,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}