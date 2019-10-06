package com.example.customviewhw.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import org.jetbrains.annotations.Nullable
import android.view.View as View
import android.graphics.RectF
import android.support.v7.widget.TintTypedArray
import com.example.customviewhw.R
import java.util.*
import kotlin.collections.ArrayList


class CircleDiagramView : View {

    private var segmentsCount = 0
    private var intList = ArrayList<Int>()
    private var angleList = ArrayList<Float>()

    constructor(context: Context?) : super(context) {
        init(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(attrs)
    }

    @SuppressLint("RestrictedApi")
    private fun init(@Nullable attrs: AttributeSet?) {
        val a = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.CircleDiagramView, 0, 0)

        segmentsCount = a.getInteger(R.styleable.CircleDiagramView_cdv_count, 1)

        a.recycle()
    }

    fun setIntList(newIntList: ArrayList<Int>) {
        intList = newIntList
        setAngleList()
        invalidate()
    }

    private fun setAngleList() {
        var sum = 0
        for (i in intList)
            sum += i

        for (j in 0 until segmentsCount) {
            angleList.add(360F*intList[j]/sum) // x/360 = intList{i}/sum
        }
    }

    private fun getPaint(): Paint {
        val paint = Paint()

        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        paint.color = color
        paint.style = Paint.Style.STROKE
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        return paint
    }

    private fun getArcPart(): RectF {
        val center_x: Float = 540f
        var center_y: Float = 820f
        val oval = RectF()
        oval.set(
            center_x - 200f, center_y - 200f, center_x + 200f,
            center_y + 200f
        )
        return oval
    }

    override fun onDraw(canvas: Canvas?) {
        var startAngel = 0F
        //var sweepAngel = 360F / segmentsCount
        for (i in 0 until segmentsCount) {
            canvas?.drawArc(getArcPart(), startAngel, angleList[i], true, getPaint())
            startAngel += angleList[i]
        }


    }
}