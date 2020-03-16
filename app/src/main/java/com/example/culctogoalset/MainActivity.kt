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
import androidx.fragment.app.Fragment
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // list of fragments
        val fragmentList = arrayListOf<Fragment>(
            Sample1Fragment(),
            Sample2Fragment(),
            Sample3Fragment(),
            Sample4Fragment()
        )

        // create isntance of adapters
        val adapter = SamplePagerAdapter(supportFragmentManager, fragmentList)
        /// set adapter
        viewPager.adapter = adapter


    }
}