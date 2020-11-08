package com.egiwon.benxtest.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BindingViewHolder(
    private val binding: ViewDataBinding,
    private val bindingId: Int?
) : RecyclerView.ViewHolder(binding.root) {

    open fun onBind(item: Any?) {
        if (bindingId == null) return
        if (item == null) return

        binding.run {
            setVariable(bindingId, item)
            executePendingBindings()
        }
    }

}