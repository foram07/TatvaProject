package com.example.tatvaproject.model



    data class BlkModel(
        var block: BLOCK = BLOCK.GREY,
    )

    enum class BLOCK {
        BLUE,
        RED,
        GREY,
    }

