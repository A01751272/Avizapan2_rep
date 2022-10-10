package mx.itesm.avizapan2

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("token")
    val token: String
)
