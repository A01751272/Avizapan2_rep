package mx.itesm.avizapan2.view.home

import android.support.v4.media.session.MediaSessionCompat
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AvizapanAPI
{
    @GET("notifications/active")
    fun descargarNotisActivas(): Call<List<Notificacion>>

    @GET("notifications/category/{category}")
    fun filtrarNotisActivas(@Path("category") category: String): Call<List<Notificacion>>

    @POST("tokens")
    fun subirToken(@Body token: String): Call<Response<String>>
    //fun subirToken(@Body token: String): Call<String>
}