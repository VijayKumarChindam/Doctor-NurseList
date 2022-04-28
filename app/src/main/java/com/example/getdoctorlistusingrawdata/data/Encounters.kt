package com.example.getdoctorlistusingrawdata.data

import com.google.gson.annotations.SerializedName


data class Encounters (

  @SerializedName("display"            ) var display            : String?                       = null,
  @SerializedName("encounterDatetime"  ) var encounterDatetime  : String?                       = null,
  @SerializedName("voided"             ) var voided             : Boolean?                      = null,
  @SerializedName("encounterType"      ) var encounterType      : EncounterType?                = EncounterType(),
  @SerializedName("encounterProviders" ) var encounterProviders : ArrayList<EncounterProviders> = arrayListOf()

)