package com.egiwon.benxtest.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<ANY : Any>(
    @LayoutRes private val layoutResId: Int,
    private val bindingId: Int?,
    private val onClick: (ANY) -> Unit = {}
) : RecyclerView.Adapter<BindingViewHolder>() {

    private var list = mutableListOf<ANY>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        val binding: ViewDataBinding = requireNotNull(DataBindingUtil.bind(view))
        return BindingViewHolder(binding, bindingId).apply {
            itemView.setOnClickListener {
                onClick(list[adapterPosition])
            }
        }
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun replaceItems(items: List<ANY>?) {
        if (items != null) {
            list.clear()
            list.addAll(items)
        }
    }
}