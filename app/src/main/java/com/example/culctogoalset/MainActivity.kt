package com.example.culctogoalset

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
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
    var selectedBrand = String()
    var selectedModel = String()

    //form
    private val RESULT_SUBACTIVITY = 1000

    override fun onItemSelected(
        parent: AdapterView<*>, view: View, position: Int,
        id: Long
    ) {
        if(spinner1?.selectedItem == "Hyundai") {
            Toast.makeText(
                applicationContext, "Mobil dipilih",
                Toast.LENGTH_SHORT
            ).show()

            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.Hyundai_array, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        } else if (spinner1?.selectedItem == "Opel") {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.Opel_array, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        } else if (spinner1?.selectedItem == "Renault"){
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.Renault_array, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }else if (spinner1?.selectedItem == "SEAT"){
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.SEAT_array, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        } else {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.SKODA_array, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }

        /* get the distance value and  culculate following selected brands and models

        if(spinner2?.getSelectedItem() == "Atos 1.1 Comfort "){
            co2result = (160 * co2result.toInt()).toString()
        }
         */

        selectedBrand = (spinner1?.getSelectedItem()).toString()
        selectedModel = (spinner2?.getSelectedItem()).toString()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //register listeners
        //Brand
        //Model

        spinner1 = findViewById<Spinner>(R.id.spinner1)
        spinner2 = findViewById<Spinner>(R.id.spinner2)
//        var selectedBrand: String = "null"
//        var selectedModel: String = "null"

        val adapter1 = ArrayAdapter.createFromResource(
            this,
            R.array.array1, android.R.layout.simple_spinner_item
        )
        spinner1?.adapter = adapter1
        spinner1?.onItemSelectedListener = this



        //move to the sub page once the culc button was tapped
        button.setOnClickListener{
            if (distance.text != null && !distance.text.toString().isEmpty()){
                val intent = Intent(applicationContext, SubActivity::class.java)
                val str = distance.text.toString()
                val brandResult = selectedBrand
                val modelResult = selectedModel
                Log.d("debug", str)

                //save database

                saveCar(brandResult, modelResult, str)


                intent.putExtra(EXTRA_BRAND, brandResult)
                intent.putExtra(EXTRA_MODEL, modelResult)
                intent.putExtra(EXTRA_DISTANCE, str)
                startActivityForResult(intent, RESULT_SUBACTIVITY)
                distance.setText("")
            }

            else{
                Toast.makeText(applicationContext, "Enter the distance form", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveCar(brand: String, model:String, dist: String){

//        Log.d("Car Brand:", brand)
//        Log.d("Car Model", model)
//        Log.d("Car dist", dist)

        val database = FirebaseDatabase.getInstance().reference

        val carId = database.child("cars").push().key!! //added non-nullable assertion

        Log.d("car id:", carId)
        val car = Car(carId, brand, model, dist)

        database.child("cars").child(carId).setValue(car)
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
            val id = item.itemId
            return if (id == R.id.action_settings) {
                true
            } else super.onOptionsItemSelected(item)
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


    }


