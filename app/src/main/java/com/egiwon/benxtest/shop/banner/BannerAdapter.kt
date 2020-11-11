package com.egiwon.benxtest.shop.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.egiwon.benxtest.R
import com.egiwon.benxtest.base.BindingViewHolder
import com.egiwon.benxtest.databinding.ItemBannerBinding
import com.egiwon.benxtest.shop.model.Banner
import com.egiwon.benxtest.util.ToastManager

class BannerAdapter(
    @LayoutRes private val layoutResId: Int,
    private val bindingId: Int?
) : RecyclerView.Adapter<BindingViewHolder>() {

    private val list = mutableListOf<Banner>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val binding = DataBindingUtil.inflate<ItemBannerBinding>(
            LayoutInflater.from(parent.context),
            layoutResId,
            parent,
            false
        )

        return BindingViewHolder(binding, bindingId).apply {
            itemView.setOnClickListener {
                ToastManager.showToast(itemView.context, R.string.select_banner_text)
            }
        }
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