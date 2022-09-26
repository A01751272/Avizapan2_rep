package mx.itesm.avizapan2.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.avizapan2.R

class AdaptadorNoti (private val contexto: Context, var arrNotis: Array<Notificacion>)
    :  RecyclerView.Adapter<AdaptadorNoti.CajaNoti>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CajaNoti {
        val vista = LayoutInflater.from(contexto).inflate(
            R.layout.caja_notificaciones,
            parent, false)
        return CajaNoti(vista)
    }

    override fun onBindViewHolder(holder: CajaNoti, position: Int) {
        val notificacion = arrNotis[position]
        holder.set(notificacion)
    }

    override fun getItemCount(): Int {
        return arrNotis.size
    }

    class CajaNoti(var vistaCaja: View) : RecyclerView.ViewHolder(vistaCaja)
    {
        fun set(notificacion: Notificacion) {
            val tvTituloNoti = vistaCaja.findViewById<TextView>(R.id.tvTituloNoti)
            val tvsubtituloNoti = vistaCaja.findViewById<TextView>(R.id.tvSubtituloNoti)
            val fecha = vistaCaja.findViewById<TextView>(R.id.tvFecha)
            val hora = vistaCaja.findViewById<TextView>(R.id.tvHora)
            //val btnInfo = vistaCaja.findViewById<Button>(R.id.btnMasInfo)
            val imgNoti = vistaCaja.findViewById<ImageView>(R.id.imgNoti)

            // Obtener fecha y hora del mismo parámetro
            val fechaCompleta = notificacion.publicado
            //val fechaSplit = fechaCompleta.split('T')
            //val horaSplit = fechaSplit[1].split('.')

            // Set values
            tvTituloNoti.text = notificacion.tituloNoti
            println(tvTituloNoti)
            tvsubtituloNoti.text = notificacion.descripcionNoti
            println(tvsubtituloNoti)
            fecha.text = fechaCompleta
            //println(fechaSplit[1])
            hora.text = fechaCompleta
            //println(horaSplit[1])
            imgNoti.setImageResource(R.drawable.defaultbackground)

            // Descargar la bandera desde el url y ponerla en imgBandera
            //val url = (pais.info["flag"])

            // Mostrar la imagen con Gradle
            //Glide.with(renglonPais.context) // mandamos la vista pq todas las vistas pueden preguntar su contexto
                //.load(url)
                //.into(imgBandera)
        }

    }
}