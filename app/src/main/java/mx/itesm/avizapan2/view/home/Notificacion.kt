package mx.itesm.avizapan2.view.home

import com.google.gson.annotations.SerializedName

data class Notificacion(
    @SerializedName("notification_id")
    val idNoti: Double,
    @SerializedName("notification_title")
    val tituloNoti: String="",
    @SerializedName("notification_description")
    val descripcionNoti: String="",
    @SerializedName("notification_location")
    val ubicacionZC: Double=0.0,
    @SerializedName("notification_posted")
    val publicado: String="2022-09-15T17:05:21.000Z",
    @SerializedName("notification_categoryId")
    val categoriaNoti: Double=0.0,
    //val categoriaNoti: Map<Double, String>,
    // val imgNoti: String=""
)
