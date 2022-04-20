package com.example.tatvaproject.ui.fragment.dashboard

import androidx.navigation.navGraphViewModels
import com.example.tatvaproject.BR
import com.example.tatvaproject.R
import com.example.tatvaproject.base.BaseFragment
import com.example.tatvaproject.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    override val layoutId = R.layout.fragment_dashboard
    override val bindingVariable = BR.dashboardViewModel
    private val viewModel: DashboardViewModel by navGraphViewModels(R.id.main_graph)

    override fun init() {
        try {
            binding.apply {
                dashboardViewModel = viewModel
                btnTask1.setOnClickListener {
                    navigate(R.id.action_dashboardFragment_to_task1Fragment)
                }
                btnTask2.setOnClickListener {
                    navigate(R.id.action_dashboardFragment_to_task2Fragment)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}