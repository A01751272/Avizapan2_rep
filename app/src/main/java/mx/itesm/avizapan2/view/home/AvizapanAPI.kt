package mx.itesm.avizapan2.view.home

import mx.itesm.avizapan2.Token
import retrofit2.Call
import retrofit2.http.*


interface AvizapanAPI
{
    @GET("notifications/active")
    fun descargarNotisActivas(): Call<List<Notificacion>>

    @GET("notifications/category/{category}")
    fun filtrarNotisActivas(@Path("category") category: String): Call<List<Notificacion>>


    @Headers("Content-Type: application/json")
    @POST("tokens")
    fun subirToken(@Body token: String): Call<Token>
    //fun subirToken(@Body token: String): Call<String>
}