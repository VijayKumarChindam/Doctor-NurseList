package com.example.getdoctorlistusingrawdata.data

import com.google.gson.annotations.SerializedName


data class Person (

  @SerializedName("display"   ) var display   : String? = null,
  @SerializedName("gender"    ) var gender    : String? = null,
  @SerializedName("age"       ) var age       : Int?    = null,
  @SerializedName("birthdate" ) var birthdate : String? = null

)