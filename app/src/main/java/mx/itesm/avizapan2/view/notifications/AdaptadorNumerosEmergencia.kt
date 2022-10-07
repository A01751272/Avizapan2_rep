package mx.itesm.avizapan2.view.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import mx.itesm.avizapan2.R

class AdaptadorNumerosEmergencia (private val contexto: Context,
                                  var arrNumeros: Array<NumerosEmergencia>)
    : RecyclerView.Adapter<AdaptadorNumerosEmergencia.RenglonNumerosEmergencia>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenglonNumerosEmergencia {
        val vista =LayoutInflater.from(contexto).inflate(
            R.layout.renglon_numeros_emergencia,
            parent, false)
        return RenglonNumerosEmergencia(vista)
    }

    override fun onBindViewHolder(holder: RenglonNumerosEmergencia, position: Int) {
        val numero = arrNumeros[position]
        holder.set(numero)
    }

    override fun getItemCount(): Int {
        return arrNumeros.size
    }

    class RenglonNumerosEmergencia(var vistaRenglon: View): RecyclerView.ViewHolder(vistaRenglon)
    {
        fun set(numero: NumerosEmergencia) {
            val tvNombre = vistaRenglon.findViewById<TextView>(R.id.tvNombreTel)
            val tvNumero = vistaRenglon.findViewById<TextView>(R.id.tvNumeroTel)

            tvNombre.text = numero.nombreTel
            tvNumero.text = numero.numeroTel
        }
    }
}