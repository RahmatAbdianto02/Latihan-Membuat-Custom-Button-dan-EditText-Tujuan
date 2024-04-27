package com.dicoding.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class MyButton : AppCompatButton{
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet): super(context,attrs)

    private var txtColor: Int = 0
    private var enabledBackground: Drawable
    private var disableBackground: Drawable

    init {
       txtColor = ContextCompat.getColor(context,android.R.color.background_light)
        enabledBackground = ContextCompat.getDrawable(context,R.drawable.bg_button) as Drawable
        disableBackground = ContextCompat.getDrawable(context,R.drawable.bg_button_disable) as Drawable
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Mengubah background dari Button
        background = if(isEnabled) enabledBackground else disableBackground

        // Mengubah warna text pada button
        setTextColor(txtColor)

        // Mengubah ukuran text pada button
        textSize = 12f

        // Menjadikan object pada button menjadi center
        gravity = Gravity.CENTER

        // Mengubah text pada button pada kondisi enable dan disable
        text = if(isEnabled) "Submit" else "Isi Dulu"
    }
}