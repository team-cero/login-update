package com.example.culctogoalset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.ColorSpace
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    // variables
    companion object{
        const val EXTRA_BRAND = "com.example.kotlinactivitydatatrans.BRAND"
        const val EXTRA_MODEL = "com.example.kotlinactivitydatatrans.MODEL"
        const val EXTRA_DISTANCE = "com.example.kotlinactivitydatatrans.DISTANCE"
    }

    // initializations
    //spinners
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var selectedBrand = null
    var selectedModel = null


    //form
    private val RESULT_SUBACTIVITY = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //register listeners
        //Brand
        //Model

        spinner1 = findViewById(R.id.spinner1) as Spinner
        var selectedBrand: String = "null"
        spinner2 = findViewById(R.id.spinner2) as Spinner
        var selectedModel: String = "null"
        val adapter1 = ArrayAdapter.createFromResource(
            this,
            R.array.array1, android.R.layout.simple_spinner_item
        )
        spinner1?.setAdapter(adapter1)
        spinner1?.setOnItemSelectedListener(this)



        //move to the sub page once the culc button was tapped
        button.setOnClickListener{
            if (distance.text != null && !distance.text.toString().isEmpty()){
                val intent = Intent(applicationContext, SubActivity::class.java)
                val str = distance.text.toString()
                val brand_result = selectedBrand
                val model_result = selectedModel
                Log.d("debug", str)

                intent.putExtra(EXTRA_BRAND, brand_result)
                intent.putExtra(EXTRA_MODEL,model_result)
                intent.putExtra(EXTRA_DISTANCE, str)
                startActivityForResult(intent, RESULT_SUBACTIVITY)
                distance.setText("")
            }

            else{
                Toast.makeText(applicationContext, "Enter the distance form", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the main; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.main, menu)
            return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            val id = item.getItemId()
            return if (id == R.id.action_settings) {
                true
            } else super.onOptionsItemSelected(item)
    }

    override fun onItemSelected(
            parent: AdapterView<*>, view: View, position: Int,
            id: Long
    ) {
            if(spinner1?.getSelectedItem() == "Hyundai") {
                Toast.makeText(
                    applicationContext, "Mobil dipilih",
                    Toast.LENGTH_SHORT
                ).show()

                val adapter2 = ArrayAdapter.createFromResource(
                    this,
                    R.array.Hyundai_array, android.R.layout.simple_spinner_item
                )
                spinner2?.setAdapter(adapter2)
            } else if (spinner1?.getSelectedItem() == "Opel") {
                val adapter2 = ArrayAdapter.createFromResource(
                    this,
                    R.array.Opel_array, android.R.layout.simple_spinner_item
                )
                spinner2?.setAdapter(adapter2)
            } else if (spinner1?.getSelectedItem() == "Renault"){
                val adapter2 = ArrayAdapter.createFromResource(
                    this,
                    R.array.Renault_array, android.R.layout.simple_spinner_item
                )
                spinner2?.setAdapter(adapter2)
            }else if (spinner1?.getSelectedItem() == "SEAT"){
                val adapter2 = ArrayAdapter.createFromResource(
                    this,
                    R.array.SEAT_array, android.R.layout.simple_spinner_item
                )
                spinner2?.setAdapter(adapter2)
            } else {
                val adapter2 = ArrayAdapter.createFromResource(
                    this,
                    R.array.SKODA_array, android.R.layout.simple_spinner_item
                )
                spinner2?.setAdapter(adapter2)
            }

            /* get the distance value and  culculate following selected brands and models

            if(spinner2?.getSelectedItem() == "Atos 1.1 Comfort "){
                co2result = (160 * co2result.toInt()).toString()
            }
             */

        var selectedBrand: String = (spinner1?.getSelectedItem()).toString()
        var selectedModel: String = (spinner2?.getSelectedItem()).toString()


        }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


    }


