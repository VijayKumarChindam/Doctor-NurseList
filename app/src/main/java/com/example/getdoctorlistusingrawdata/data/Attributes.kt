package com.example.getdoctorlistusingrawdata.data

import com.google.gson.annotations.SerializedName


data class Attributes (

  @SerializedName("display"         ) var display         : String?          = null,
  @SerializedName("uuid"            ) var uuid            : String?          = null,
  @SerializedName("attributeType"   ) var attributeType   : AttributeType?   = AttributeType(),
  @SerializedName("value"           ) var value           : String?          = null,
  @SerializedName("voided"          ) var voided          : Boolean?         = null,
  @SerializedName("links"           ) var links           : ArrayList<Links> = arrayListOf(),
  @SerializedName("resourceVersion" ) var resourceVersion : String?          = null

)