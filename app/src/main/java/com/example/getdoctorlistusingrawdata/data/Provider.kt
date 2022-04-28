package com.example.getdoctorlistusingrawdata.data

import com.google.gson.annotations.SerializedName


data class Provider (

  @SerializedName("uuid"    ) var uuid    : String?          = null,
  @SerializedName("display" ) var display : String?          = null,
  @SerializedName("links"   ) var links   : ArrayList<Links> = arrayListOf()

)