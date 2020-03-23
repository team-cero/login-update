package com.example.culctogoalset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.widget.SeekBar
import java.util.*
import kotlinx.android.synthetic.main.activity_goalsetting2.*
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.widget.Toast


class GoalSettingActivity2 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goalsetting2)

        //seekbar for goal setting
        // initial seekbar progress
        seekbar.setProgress(100)
        // seekbar max num
        seekbar.setMax(100)

        seekbar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                //called by a knob
                override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean
                ) {
                    // percentage format
                    val str = String.format(Locale.US, "%d %%", progress)
                    goalNum.text = str //percentage which user setted
                    refreshCircle(progress.toFloat())
                }


                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // called when a knob is touched
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // called when a knob is released
                }


            })
        refreshCircle(100f)

        }



    //draw circles
    private fun refreshCircle(radius: Float) {
        val bitmap: Bitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888)
        val canvas: Canvas = Canvas(bitmap)

        var paint1 = Paint()
        paint1.setColor(Color.parseColor("#03DAC5"))
        paint1.setAntiAlias(true)
        paint1.setDither(true)

        //stable circle
        var paint2 = Paint()
        paint2.setColor(Color.parseColor("#7B7B7B"))
        paint2.setAntiAlias(true)
        paint2.setDither(true)


        //changing circle
        var center_x = (150).toFloat()
        var center_y = (150).toFloat()
        var radius = (120 * (radius/ 100)).toFloat()


        canvas.drawCircle(center_x, center_y, (120).toFloat(), paint2)
        canvas.drawCircle(center_x, center_y, radius, paint1)

        // now bitmap holds the updated pixels

        // set bitmap as background to ImageView
        imageV2.background = BitmapDrawable(getResources(), bitmap)
    }
}
