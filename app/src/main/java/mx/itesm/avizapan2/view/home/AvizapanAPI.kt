package mx.itesm.avizapan2.view.home

import retrofit2.Call
import retrofit2.http.*


interface AvizapanAPI
{
    @GET("notifications/active")
    fun descargarNotisActivas(): Call<List<Notificacion>>

    @GET("notifications/category/{category}")
    fun filtrarNotisActivas(@Path("category") category: String): Call<List<Notificacion>>


    @GET("tokens/{token}")
    fun subirToken(@Path("token") token: String): Call<String>
    //fun subirToken(@Body token: String): Call<String>
}