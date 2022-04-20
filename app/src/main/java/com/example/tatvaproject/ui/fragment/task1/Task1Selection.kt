package com.example.tatvaproject.ui.fragment.task1

import com.example.tatvaproject.model.BlkModel

interface Task1Selection {
    fun onItemClick(pos: Int, block: BlkModel)

    fun onBlockFinish()
}