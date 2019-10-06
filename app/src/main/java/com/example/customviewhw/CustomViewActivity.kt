package com.example.customviewhw

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.customviewhw.views.CircleDiagramView
import kotlinx.android.synthetic.main.activity_custom_view.*


class CustomViewActivity : AppCompatActivity() {

    private var view : CircleDiagramView? = null
    private var firstParam = 0
    private var secondParam = 0
    private var thirdParam = 0
    private var fourthParam = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        view = cdv_main
        firstParam = intent.extras.getInt("first_param", 2)
        secondParam = intent.extras.getInt("second_param", 2)
        thirdParam = intent.extras.getInt("third_param", 2)
        fourthParam = intent.extras.getInt("fourth_param", 2)
        setDiagramParts()
    }

    private fun setDiagramParts() {
        val arrayList: ArrayList<Int> = ArrayList()
        arrayList.add(firstParam)
        arrayList.add(secondParam)
        arrayList.add(thirdParam)
        arrayList.add(fourthParam)
        view?.setIntList(arrayList)
    }

}
