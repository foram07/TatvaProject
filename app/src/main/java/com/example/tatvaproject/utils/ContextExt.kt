package com.example.tatvaproject.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.os.Build
import android.util.TypedValue
import android.widget.Toast
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.getColorOrThrow
import androidx.core.content.res.getDrawableOrThrow
import java.util.*

fun Context.getInteger(@IntegerRes resId: Int) =
    resources.getInteger(resId)

fun Context.getDimenSize(@DimenRes resId: Int) =
    resources.getDimensionPixelSize(resId)

fun Context.getCompatColor(@ColorRes resId: Int) =
    ContextCompat.getColor(this, resId)

fun Context.isActivityFinishing(): Boolean {
    return this is Activity && isFinishing
}

fun Context.isActivityDestroyed(): Boolean {
    return this is Activity && isDestroyed
}

fun Context.toast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, duration).show()
}

fun Context.toast(text: String?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text.orEmpty(), duration).show()
}

@RequiresPermission(value = Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.isNetworkConnected(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    connectivityManager?.let {
        val netInfo = it.activeNetworkInfo
        netInfo?.let {
            if (it.isConnected) return true
        }
    }
    return false
}