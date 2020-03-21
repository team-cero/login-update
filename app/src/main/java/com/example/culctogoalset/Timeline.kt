package com.example.culctogoalset

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_timeline.*


class Timeline : AppCompatActivity() {
    var fbAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeline)

        //game challenge

        //calculator
        var btnCalc = findViewById<Button>(R.id.btnCalc)
        btnCalc.setOnClickListener {
            val intent = Intent(application, CalculationActivity::class.java)
            startActivity(intent)
        }

        //goal setting
        var btnGoal= findViewById<Button>(R.id.btnGoal)
        btnGoal.setOnClickListener {
            val intent2 = Intent(application, GoalSettingActivity::class.java)
            startActivity(intent2)
        }

        //record
        var btnReacord= findViewById<Button>(R.id.btnRecord)
        btnGoal.setOnClickListener {
            //val intent = Intent(application, RecordActivity::class.java)
            //startActivity(intent)
        }

         //logout
        var btnLogOut = findViewById<Button>(R.id.btnLogout)

        btnLogOut.setOnClickListener{ view ->
            showMessage(view, "Logging Out...")
            signOut()
        }

        fbAuth.addAuthStateListener {
            if(fbAuth.currentUser == null){
                this.finish()
            }
        }
    }

    fun signOut(){
        fbAuth.signOut()

    }

    fun showMessage(view: View, message: String){
        Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show()
    }



}





