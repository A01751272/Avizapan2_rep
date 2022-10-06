package mx.itesm.avizapan2.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import mx.itesm.avizapan2.R

class AdaptadorNoti (private val contexto: Context, var arrNotis: Array<Notificacion>)
    :  RecyclerView.Adapter<AdaptadorNoti.CajaNoti>()
{

    // Variable de instancia ListenerRecycler
    var listener: ListenerRecycler? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CajaNoti {
        val vista = LayoutInflater.from(contexto).inflate(
            R.layout.caja_notificaciones,
            parent, false)
        return CajaNoti(vista)
    }

    override fun onBindViewHolder(holder: CajaNoti, position: Int) {
        val notificacion = arrNotis[position]
        holder.set(notificacion)
        holder.vistaCaja.setOnClickListener{
            listener?.itemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return arrNotis.size
    }

    class CajaNoti(var vistaCaja: View) : RecyclerView.ViewHolder(vistaCaja)
    {
        fun set(notificacion: Notificacion) {
            val tvTituloNoti = vistaCaja.findViewById<TextView>(R.id.tvTituloNoti)
            //val tvsubtituloNoti = vistaCaja.findViewById<TextView>(R.id.tvSubtituloNoti)
            val fecha = vistaCaja.findViewById<TextView>(R.id.tvFecha)
            val hora = vistaCaja.findViewById<TextView>(R.id.tvHora)
            val imgNoti = vistaCaja.findViewById<ShapeableImageView>(R.id.imgNoti)

            // Valores que no desplegamos en la interfaz
            val categoria = notificacion.categoriaNoti


            // Obtener fecha y hora del mismo parámetro
            val fechaCompleta = notificacion.publicado
            val fechaSplit = fechaCompleta.split('T')
            val horaSplit = fechaSplit[1].split('.')


            // Set values de todo
            tvTituloNoti.text = notificacion.tituloNoti
            //tvsubtituloNoti.text = notificacion.descripcionNoti
            fecha.text = fechaSplit[0]
            hora.text = horaSplit[0]
            if(categoria == 1.0) // vialidad
                imgNoti.setImageResource(R.drawable.vialidad)
            else if(categoria == 2.0) // climatológica
                imgNoti.setImageResource(R.drawable.climatologica)
            else if(categoria == 5.0) // sismológica
                imgNoti.setImageResource(R.drawable.sismologica)
            else if(categoria == 6.0) // protección civil
                imgNoti.setImageResource(R.drawable.proteccion_civil)
            else
                imgNoti.setImageResource(R.drawable.defaultbackground)


            // Descargar la bandera desde el url y ponerla en imgBandera
            //val url = (pais.info["flag"])

            // Mostrar la imagen con Gradle
            //Glide.with(renglonPais.context) // mandamos la vista pq todas las vistas pueden preguntar su contexto
                //.load(url)
                //.into(imgBandera)

            // sismologica
            // proteccion civil
        }

    }
}