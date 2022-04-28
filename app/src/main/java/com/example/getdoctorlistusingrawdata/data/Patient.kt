package com.example.getdoctorlistusingrawdata.data

import com.google.gson.annotations.SerializedName


data class Patient (

  @SerializedName("uuid"        ) var uuid        : String?                = null,
  @SerializedName("identifiers" ) var identifiers : ArrayList<Identifiers> = arrayListOf(),
  @SerializedName("person"      ) var person      : Person?                = Person()

)