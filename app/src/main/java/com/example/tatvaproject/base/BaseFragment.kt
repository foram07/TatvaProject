package com.example.tatvaproject.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tatvaproject.utils.showSnackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.math.floor
import kotlin.math.sqrt

abstract class BaseFragment<T : ViewDataBinding> : Fragment(), CoroutineScope {
    abstract val layoutId: Int
    abstract val bindingVariable: Int

    override val coroutineContext = Dispatchers.IO

    abstract fun init()

    lateinit var binding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    fun navigate(id: Int) {
        findNavController().navigate(id)
    }

    fun showSnackbar(msg: String) {
        binding.root.showSnackbar(msg)
    }

    open fun isPerfectSquare(n: Int): Boolean {
        val h = n and 0xF // h is the last hex "digit"
        if (h > 9) return false
        // Use lazy evaluation to jump out of the if statement as soon as possible
        if (h != 2 && h != 3 && h != 5 && h != 6 && h != 7 && h != 8) {
            val t = floor(sqrt(n.toDouble()) + 0.5).toInt()
            return t * t == n
        }
        return false
    }

    fun delay(delay: Long, function: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(function, delay)
    }
}