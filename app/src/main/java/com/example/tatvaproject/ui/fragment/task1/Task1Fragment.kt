package com.example.tatvaproject.ui.fragment.task1

import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tatvaproject.BR
import com.example.tatvaproject.R
import com.example.tatvaproject.base.BaseFragment
import com.example.tatvaproject.databinding.FragmentTask1Binding
import com.example.tatvaproject.model.BLOCK
import com.example.tatvaproject.model.BlkModel
import com.example.tatvaproject.utils.Logger
import com.example.tatvaproject.utils.clearValue
import com.example.tatvaproject.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.sqrt

@AndroidEntryPoint
class Task1Fragment : BaseFragment<FragmentTask1Binding>() {

    override val layoutId = R.layout.fragment_task1
    override val bindingVariable = BR.task1ViewModel

    private val viewModel: Task1ViewModel by navGraphViewModels(R.id.main_graph)

    lateinit var adapter: Task1Adapter

    override fun init() {
        binding.apply {
            task1ViewModel = viewModel

            btnSubmit.setOnClickListener {
                try {
                    val value = viewModel.number.get()?:""
                    if (value.isNotEmpty()) {
                        btnSubmit.hideKeyboard()
                        etCount.clearValue()

                        val number = value.toInt()
                        val isSqrt = isPerfectSquare(number) // check number is square root
                        if (isSqrt) {
                            val span = sqrt(value.toDouble()).toInt() // calculate span
                            rvBlock.layoutManager = GridLayoutManager(requireContext(), span)

                            fillBlockRv(number)
                        } else {
                            showSnackbar("Please enter square root number")
                        }
                    }
                } catch (e: Exception) {
                    Logger.e(e)
                }
            }
        }
    }

    private fun fillBlockRv(number: Int) {
        // create list with grey block.
        val list = MutableList(number) {
            BlkModel(BLOCK.GREY)
        }
        adapter = Task1Adapter(list, object : Task1Selection {
            override fun onItemClick(pos: Int, block: BlkModel) {
                adapter.makeAvailable()
            }

            override fun onBlockFinish() {
                showSnackbar("Wow!, You did it!")
                binding.root.hideKeyboard()
            }
        })
        binding.rvBlock.adapter = adapter
        // after 1Sec, random block is clickable.
        delay(1000L) {
            adapter.makeAvailable()
        }
    }
}