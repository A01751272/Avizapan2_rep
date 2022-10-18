package mx.itesm.avizapan2

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import mx.itesm.avizapan2.view.home.AvizapanAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServicioMensajeFB : FirebaseMessagingService()
{
    private val channelName = "alertasPC"
    private val channelId = "mx.itesm.avizapan2"

    private val retrofit by lazy {
        // El objeto retrofit para instanciar el objeto que se conecta
        // a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("https://avizapan-app-3s4eu.ondigitalocean.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val servicioAvizapanAPI by lazy {
        retrofit.create(AvizapanAPI::class.java)
    }

    override fun onNewToken(token: String) {
        println("Nuevo token: $token")
        subirToken(token)
    }

    private fun subirToken(token: String) {
        servicioAvizapanAPI.subirToken(token).enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    println("Subi el Token")
                }
            }
        )
    }

    override fun onMessageReceived(message: RemoteMessage) {
        println("Llega una notificacion remota")
        if(message.notification != null) {
            generarNotificacion(message)
        }
    }

    private fun generarNotificacion(message: RemoteMessage) {
        //Abre la app
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this,
            0, intent, PendingIntent.FLAG_MUTABLE)

        var builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.icono_transparente)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)
        builder = builder.setContent(crearVistaRemota(message))

        val admNotificaciones = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val canalNotificaciones = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            admNotificaciones.createNotificationChannel(canalNotificaciones)
        }
        // Genera la notificacion LOCALMENTE
        admNotificaciones.notify(0, builder.build())
    }
    /* Genera la GUI para mostrar la notificacion*/
    @SuppressLint("RemoteViewLayout")
    private fun crearVistaRemota(message: RemoteMessage): RemoteViews {
        val titulo = message.notification?.title!!
        val mensaje = message.notification?.body!!
        val vistaRemota = RemoteViews("mx.itesm.avizapan2", R.layout.alerta_notificacion)
        vistaRemota.setTextViewText(R.id.tvTitulo, titulo)
        vistaRemota.setTextViewText(R.id.tvCategoria, mensaje)
        vistaRemota.setImageViewResource(R.id.imageView, R.drawable.icono_transparente)
        return vistaRemota
    }
}