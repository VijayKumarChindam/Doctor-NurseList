package com.example.getdoctorlistusingrawdata

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getdoctorlistusingrawdata.Auth.BasicAuthClient
import com.example.getdoctorlistusingrawdata.Auth.DemoRemoteService
import com.example.getdoctorlistusingrawdata.data.DoctorData
import com.example.getdoctorlistusingrawdata.data.EncounterRole
import com.example.getdoctorlistusingrawdata.data.Encounters
import com.example.getdoctorlistusingrawdata.data.Provider
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.nio.charset.Charset
import java.text.ParseException
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
    }
}