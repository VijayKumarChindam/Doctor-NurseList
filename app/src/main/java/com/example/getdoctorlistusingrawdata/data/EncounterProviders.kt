package com.example.getdoctorlistusingrawdata.data

import com.google.gson.annotations.SerializedName


data class EncounterProviders (

  @SerializedName("uuid"            ) var uuid            : String?          = null,
  @SerializedName("provider"        ) var provider        : Provider?        = Provider(),
  @SerializedName("encounterRole"   ) var encounterRole   : EncounterRole?   = EncounterRole(),
  @SerializedName("voided"          ) var voided          : Boolean?         = null,
  @SerializedName("links"           ) var links           : ArrayList<Links> = arrayListOf(),
  @SerializedName("resourceVersion" ) var resourceVersion : String?          = null

)