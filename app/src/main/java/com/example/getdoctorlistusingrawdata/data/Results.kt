package com.example.getdoctorlistusingrawdata.data

import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("uuid"       ) var uuid       : String?               = null,
  @SerializedName("patient"    ) var patient    : Patient?              = Patient(),
  @SerializedName("location"   ) var location   : Location?             = Location(),
  @SerializedName("encounters" ) var encounters : ArrayList<Encounters> = arrayListOf(),
  @SerializedName("attributes" ) var attributes : ArrayList<Attributes> = arrayListOf()

)