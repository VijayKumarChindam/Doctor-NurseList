package com.example.getdoctorlistusingrawdata.Nurse

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
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

class NurseActivity : AppCompatActivity() {
    var personNames: ArrayList<String> = ArrayList()
    var cases: ArrayList<String> = ArrayList()
    var role: ArrayList<String> = ArrayList()
    var date: ArrayList<String> = ArrayList()
    var size: ArrayList<String> = ArrayList()
    var datamodellist:ArrayList<Datamodel>?=null
    var recyclerView:RecyclerView?=null
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadProfile()
        title = "Nurse details"
        recyclerView = MainrecyclerView
    }
    private fun loadProfile() {
        val call = BasicAuthClient<DemoRemoteService>().create(DemoRemoteService::class.java).getProfile()
        call.enqueue(object : Callback<DoctorData> {
            override fun onResponse(call: Call<DoctorData>, response: Response<DoctorData>) {
                var details=response.body()
                Log.d("resp", details.toString())
                val customAdapter = CustomAdapter(this@NurseActivity, personNames, role, date,cases)
                recyclerView?.adapter = customAdapter
                if (response.isSuccessful) {
                    val items = response.body()?.results
                    if (items != null) {
                        for (i in 0 until items.size) {
                            for (j in 0 until items[i].encounters.size) {
                                for (k in 0 until items[i].encounters[j].encounterProviders.size) {
                                    if (details != null) {
                                        if (details.results[i].encounters[j].encounterProviders[k].encounterRole?.uuid?.contains(
                                                "73bbb069-9781-4afc-a9d1-54b6b2270e04") == true) {
                                            personNames.add("" + details.results[i].encounters[j].encounterProviders[k].provider?.display)
                                            role.add("" + details.results[i].encounters[j].encounterProviders[k].encounterRole?.display)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                size.add(personNames.groupingBy { it }.eachCount().filter { it.value>1 }.toString())
                size.toString().removeRange(2,2)
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

            }
            override fun onFailure(call: Call<DoctorData>, t: Throwable) {
                Log.d("tag", "error",t)

            }

        })
    }
}
