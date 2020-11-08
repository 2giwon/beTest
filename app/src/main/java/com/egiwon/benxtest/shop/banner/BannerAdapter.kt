package com.egiwon.benxtest.shop.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.egiwon.benxtest.base.BindingViewHolder
import com.egiwon.benxtest.shop.model.Banner

class BannerAdapter(
    @LayoutRes private val layoutResId: Int,
    private val bindingId: Int?
) : RecyclerView.Adapter<BindingViewHolder>() {

    private val list = mutableListOf<Banner>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        val binding: ViewDataBinding = requireNotNull(DataBindingUtil.bind(view))
        return BindingViewHolder(binding, bindingId)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        if (list.size > 0) {
            holder.onBind(list[position % list.size])
        }
    }

    override fun getItemCount(): Int = Int.MAX_VALUE

    fun replaceItems(items: List<Banner>?) {
        if (items != null) {
            list.clear()
            list.addAll(items)
        }
    }
}