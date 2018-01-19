package com.example.kevinlay.androidfundamentalspractice.kotlin

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by kevinlay on 1/18/18.
 */
class KotlinView : View {

    var textPaint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPaint2 : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}