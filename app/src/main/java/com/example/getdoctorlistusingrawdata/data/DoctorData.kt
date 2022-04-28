package com.example.getdoctorlistusingrawdata.data

import com.google.gson.annotations.SerializedName


data class DoctorData (

  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf(),
  @SerializedName("links"   ) var links   : ArrayList<Links>   = arrayListOf()


)