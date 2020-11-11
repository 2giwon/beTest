package com.egiwon.benxtest.ext

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.egiwon.benxtest.base.BaseAdapter
import com.egiwon.benxtest.shop.banner.BannerAdapter
import com.egiwon.benxtest.shop.model.Banner
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("replaceBannerItem")
fun replaceBannerItem(recyclerView: RecyclerView, items: List<Banner>?) {
    if (items != null) {
        (recyclerView.adapter as? BannerAdapter)?.run {
            replaceItems(items)
            notifyDataSetChanged()
        }
    }
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("replaceItem")
fun replaceItem(recyclerView: RecyclerView, items: List<Any>?) {
    if (items != null) {
        (recyclerView.adapter as? BaseAdapter<Any>)?.run {
            replaceItems(items)
            notifyDataSetChanged()
        }
    }
}

@BindingAdapter("loadImageUrl")
fun loadImageUrlByGlide(imageView: ImageView, imageUrl: String?) {
    if (imageUrl != null) {

        Glide.with(imageView)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    }
}

@BindingAdapter("loadCircleImageUrl")
fun loadCircleImageByGlide(imageView: ImageView, imageUrl: String?) {
    if (imageUrl != null) {

        Glide.with(imageView)
            .load(imageUrl)
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    }
}

@BindingAdapter("textToPrice")
fun textToPrice(textView: AppCompatTextView, price: Int) {
    val symbol = Currency.getInstance(Locale.getDefault()).symbol
    val decimalFormat = DecimalFormat("'$symbol' #,##0")
    textView.text = decimalFormat.format(price)
}

@BindingAdapter("textToDate")
fun textToDate(textView: AppCompatTextView, text: String) {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault())
    try {
        val date = simpleDateFormat.parse(text) ?: return
        val newFormat = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())

        textView.text = newFormat.format(date)
    } catch (ex: ParseException) {
        textView.text = text
    }

}
