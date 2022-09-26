package mx.itesm.avizapan2.view.home

import com.google.gson.annotations.SerializedName

data class Notificacion(
    @SerializedName("id")
    val idNoti: Int,
    @SerializedName("title")
    val tituloNoti: String="",
    @SerializedName("description")
    val descripcionNoti: String="",
    @SerializedName("location")
    val ubicacionZC: Int=0,
    @SerializedName("posted")
    val publicado: String="2022-09-15T17:05:21.000Z",
    @SerializedName("category")
    val categoriaNoti: String="",
    // temporal, después hay que implementar un mapa
    val imgNoti: String=""
)
