package com.example.getdoctorlistusingrawdata
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.getdoctorlistusingrawdata.Doctor.DoctorActivity
import com.example.getdoctorlistusingrawdata.Nurse.NurseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        title = "Home Page"

        Doctorlayout.setOnClickListener {
            val intent = Intent(this, DoctorActivity::class.java).apply {
            }
            startActivity(intent)

        }
        HealthWorkerlayout.setOnClickListener {
            val intent = Intent(this, NurseActivity::class.java).apply {
            }
            startActivity(intent)

        }
    }
}