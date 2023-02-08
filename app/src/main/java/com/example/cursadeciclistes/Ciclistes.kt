package com.example.cursadeciclistes

import android.widget.ImageView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Cyclist (
    val nom: String,
    val meta: Float
) {
    var image: ImageView? = null
    var posicioActual: Float = 0f

    suspend fun run() {
        posicioActual = image!!.y

        while(posicioActual < meta)
        {
            posicioActual += 5F
            image!!.y = posicioActual
            val rand = (0..100).random().toLong()
            delay(rand)
        }
    }
}