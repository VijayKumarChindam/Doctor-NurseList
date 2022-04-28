package com.example.getdoctorlistusingrawdata.Doctor

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.getdoctorlistusingrawdata.Auth.BasicAuthClient
import com.example.getdoctorlistusingrawdata.Auth.DemoRemoteService
import com.example.getdoctorlistusingrawdata.CustomAdapter
import com.example.getdoctorlistusingrawdata.Model.Datamodel
import com.example.getdoctorlistusingrawdata.R
import com.example.getdoctorlistusingrawdata.data.DoctorData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList


class DoctorActivity : AppCompatActivity() {
    var personNames: ArrayList<String> = ArrayList()
    var cases: ArrayList<String> = ArrayList()
    var role: ArrayList<String> = ArrayList()
    var date: ArrayList<String> = ArrayList()
    var size: ArrayList<String> = ArrayList()
    var sdate: ArrayList<String> = ArrayList()
    var ldate: ArrayList<String> = ArrayList()

    val datamodellist:ArrayList<Datamodel>?= ArrayList()
    var recyclerView:RecyclerView?=null

    private val sdf=SimpleDateFormat("yyyy/MM/dd MM:mm,ss")
    @RequiresApi(Build.VERSION_CODES.O)
    private val dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd MM:mm,ss")

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadProfile()
        title = "Doctor details"
        recyclerView = MainrecyclerView
    }
    private fun loadProfile() {
        val call = BasicAuthClient<DemoRemoteService>().create(DemoRemoteService::class.java).getProfile()
        call.enqueue(object : Callback<DoctorData> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(call: Call<DoctorData>, response: Response<DoctorData>) {
                var details=response.body()
                Log.d("resp", details.toString())
                if (response.isSuccessful){
                    val items= response.body()?.results
                    if (items!=null) {
                        for (i in 0 until items.size) {
                            for (j in 0 until items[i].encounters.size){
                                for(k in 0 until items[i].encounters[j].encounterProviders.size){
                                    if (details != null) {
                                        if (details.results[i].encounters[j].encounterProviders[k].encounterRole?.uuid?.contains("73bbb069-9781-4afc-a9d1-54b6b2270e03") == true) {
                                            if (details.results[i].encounters[j].encounterProviders[k].provider?.display?.contains("nurse") != true) {
                                                personNames.add("" + details.results[i].encounters[j].encounterProviders[k].provider?.display)
                                                role.add("" + details.results[i].encounters[j].encounterProviders[k].encounterRole?.display)
                                                date.add("" + details.results[i].encounters[j].encounterDatetime)
                                                if (details.results[i].encounters[j].encounterType?.display?.contains("Visit Note")==true){
                                                    sdate.add(" "+details.results[i].encounters[j].encounterDatetime)
                                                }
                                                if (details.results[i].encounters[j].encounterType?.display?.contains("Visit Complete")==true){
                                                    ldate.add(" "+details.results[i].encounters[j].encounterDatetime)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                size.add(personNames.groupingBy { it }.eachCount().filter { it.value>1 }.toString())
                val leftcarlyremove = size.toString().split("[{")
                val rightcarlyremove=leftcarlyremove[1].split("}]")
                val sortArray = rightcarlyremove[0].toString().split(",")
                Log.d("sorting", size.toString())
                personNames.clear()
                for (i in sortArray){
                    val iarray=i.split("=")
                    personNames.add(iarray[0])
                    cases.add(iarray[1])
                    datamodellist?.add(Datamodel(iarray[0],iarray[1]))
                }

                val customAdapter = CustomAdapter(this@DoctorActivity, personNames, role, date,cases)
                recyclerView?.adapter = customAdapter

            }
            override fun onFailure(call: Call<DoctorData>, t: Throwable) {
                Log.d("tag", "error",t)

            }

        })
    }
}
