package mx.itesm.avizapan2.view.home

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AvizapanAPI
{
    @GET("notifications/active")
    fun descargarNotisActivas(): Call<List<Notificacion>>

    @GET("notifications/category/{category}")
    fun filtrarNotisActivas(@Path("category") category: String): Call<List<Notificacion>>
}