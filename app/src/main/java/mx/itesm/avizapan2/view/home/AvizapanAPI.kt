package mx.itesm.avizapan2.view.home

import retrofit2.Call
import retrofit2.http.GET

interface AvizapanAPI
{
    @GET("notifications/active")
    fun descargarNotisActivas(): Call<List<Notificacion>>
}