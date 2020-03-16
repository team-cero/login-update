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
import kotlinx.android.synthetic.main.activity_calculation.*

class CalculationActivity : AppCompatActivity() {

    // initializations
    //spinners
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)

        //register listeners
        //Brand
        //Model
        spinner1 = findViewById(R.id.spinner1) as Spinner
        spinner2 = findViewById(R.id.spinner2) as Spinner

        val adapter1 = ArrayAdapter.createFromResource(
            this,
            R.array.array1, android.R.layout.simple_spinner_item
        )
        spinner1?.setAdapter(adapter1)
        spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var adapter2: ArrayAdapter<CharSequence>? = null

                if (spinner1?.getSelectedItem() == "Hyundai") {

                    adapter2 = ArrayAdapter.createFromResource(
                        applicationContext,
                        R.array.Hyundai_array, android.R.layout.simple_spinner_item
                    )


                } else if (spinner1?.getSelectedItem() == "Opel") {
                    adapter2 = ArrayAdapter.createFromResource(
                        applicationContext,
                        R.array.Opel_array, android.R.layout.simple_spinner_item
                    )

                } else if (spinner1?.getSelectedItem() == "Renault") {
                    adapter2 = ArrayAdapter.createFromResource(
                        applicationContext,
                        R.array.Renault_array, android.R.layout.simple_spinner_item
                    )

                } else if (spinner1?.getSelectedItem() == "SEAT") {
                    adapter2 = ArrayAdapter.createFromResource(
                        applicationContext,
                        R.array.SEAT_array, android.R.layout.simple_spinner_item
                    )
                } else {
                    adapter2 = ArrayAdapter.createFromResource(
                        applicationContext,
                        R.array.SKODA_array, android.R.layout.simple_spinner_item
                    )

                }

                //set the adapter and the listener for spinner2
                spinner2?.setAdapter(adapter2)
                spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val spinner2_content = spinner2?.getSelectedItem() as String
                        //textView2?.text = spinner2_content

                    }


                }
                // here I try to put the selected contents to variables
                val spinner1_content = spinner1?.getSelectedItem() as String
                //textView1?.text = spinner1_content
            }
        }


        //move to the sub page once the culc button was tapped
        button.setOnClickListener{
            if (distance.text != null && !distance.text.toString().isEmpty()){
                val intent = Intent(applicationContext, GoalSettingActivity::class.java)
                val str = distance.text.toString()
                Log.d("debug", str)

                intent.putExtra(EXTRA_DISTANCE, str)
                startActivityForResult(intent, RESULT_SUBACTIVITY)
                distance.setText("")
            }

            else{
                Toast.makeText(applicationContext, "Enter the distance form", Toast.LENGTH_SHORT).show()
            }
        }
    }




    // variables
    companion object{
        //const val EXTRA_BRAND = "com.example.kotlinactivitydatatrans.BRAND"
        //const val EXTRA_MODEL = "com.example.kotlinactivitydatatrans.MODEL"
        const val EXTRA_DISTANCE = "com.example.kotlinactivitydatatrans.DISTANCE"
    }



    //form
    private val RESULT_SUBACTIVITY = 1000


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



    var selectedBrand: String = (spinner1?.getSelectedItem()).toString()
    var selectedModel: String = (spinner2?.getSelectedItem()).toString()


}

