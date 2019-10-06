package com.example.customviewhw

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var firstParam = 2
    private var secondParam = 2
    private var thirdParam = 2
    private var fourthParam = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initChangeListeners()
        initClickListeners()
    }

    private fun initClickListeners(){
        btn_start.setOnClickListener{
            val intent = Intent(this, CustomViewActivity::class.java)
            intent.putExtra("first_param", firstParam)
            intent.putExtra("second_param", secondParam)
            intent.putExtra("third_param", thirdParam)
            intent.putExtra("fourth_param", fourthParam)
            startActivity(intent)
            finish()
        }
    }

    private fun initChangeListeners() {
        first_param.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                var num = i + 2
                first_param_text.text = "Маму: $num"
                firstParam = i + 2
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        second_param.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                var num = i + 2
                second_param_text.text = "Андройд : $num"
                secondParam = i + 2
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        third_param.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                var num = i + 2
                third_param_text.text = "Онимэ : $num"
                thirdParam = i + 2
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        fourth_param.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                var num = i + 2
                fourth_param_text.text = "Покушоть : $num"
                fourthParam = i + 2
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
    }
}
