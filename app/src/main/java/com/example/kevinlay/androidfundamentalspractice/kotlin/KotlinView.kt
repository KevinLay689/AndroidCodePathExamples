package com.example.kevinlay.androidfundamentalspractice.kotlin

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Created by kevinlay on 1/18/18.
 */
class KotlinView : View {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


}