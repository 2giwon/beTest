package com.egiwon.benxtest.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

object ToastManager {
    private fun showToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun showToast(context: Context, @StringRes textResId: Int) {
        showToast(context, context.getString(textResId))
    }
}