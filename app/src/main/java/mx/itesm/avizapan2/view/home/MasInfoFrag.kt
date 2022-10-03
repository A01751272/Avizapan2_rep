package mx.itesm.avizapan2.view.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.SupportMapFragment
import mx.itesm.avizapan2.R
import mx.itesm.avizapan2.databinding.FragmentMasInfoBinding

class MasInfoFrag : Fragment() {

    //Mapa


    // binding
    private lateinit var binding : FragmentMasInfoBinding

    // ViewModel
    private val viewModel: MasInfoViewModel by viewModels()

    // Argumentos Navegacion
    private val args: MasInfoFragArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMasInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Definir valores que llegan desde Home
        val titulo = args.notificacion.tituloNoti
        val descripcion = args.notificacion.descripcionNoti
        val fechaCompleta = args.notificacion.publicado

        // Formato fecha y hora
        val fechaSplit = fechaCompleta.split('T')
        val horaSplit = fechaSplit[1].split('.')

        // Poner valores en los tvs correspondientes
        binding.tvTituloMasInfo.text = titulo
        binding.tvFechaMasInfo.text = fechaSplit[0]
        binding.tvHoraMasInfo.text = horaSplit[0]
        binding.tvDescripcionMasInfo.text = descripcion
    }


}