package com.example.culctogoalset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.SeekBar
import java.util.*
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // to get message from MainActivity
        val intent = getIntent()
        val distance = intent.extras?.getString(MainActivity.EXTRA_DISTANCE)?:""

        textView.text = ((distance.toFloat() * 160) / 1000 ).toString() + "kg"


        //seekbar for goal setting
        // seekbar max
        seekbar.setProgress(100)
        // seekbar min
        seekbar.setMax(100)

        seekbar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                //called by a knob
                override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // percentage format
                    val str = String.format(Locale.US, "%d %%", progress)
                    goalNum.text = str
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // called when a knob is touched
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // called when a knob is released
                }

            })

        button.setOnClickListener{
            val intentSub = Intent()


            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}