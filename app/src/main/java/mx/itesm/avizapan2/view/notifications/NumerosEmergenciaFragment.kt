package mx.itesm.avizapan2.view.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.avizapan2.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    // Binding
    private var _binding: FragmentNotificationsBinding? = null

    // Adaptador
    private lateinit var adaptador: AdaptadorNumerosEmergencia

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    // Se activa cuando el fragmento es visible al usuario
    override fun onStart() {
        super.onStart()
        // RecyclerView
        configurarRV()
    }

    private fun configurarRV() {
        // Números de emergencia conocidos
        val arrNumerosEmergencia = arrayOf(
            NumerosEmergencia(
                "Ayuntamiento de Atizapán de Zaragoza",
                "55 3622 2800"
            ),
            NumerosEmergencia(
                "Instituto de la Mujer",
                "55 5077 3843"
            ),
            NumerosEmergencia(
                "DIF Atizapán",
                "55 2817 8518"
            ),
            NumerosEmergencia(
                "Cruz Roja",
                "55 5816 0294"
            ),
            NumerosEmergencia(
                "Bomberos: Estación Central",
                "55 3622 1004"
            ),
            NumerosEmergencia(
                "Bomberos: Calacoaya",
                "55 5565 0696"
            ),
            NumerosEmergencia(
                "Bomberos: Blvd. Ignacio Zaragoza",
                "55 5820 9282"
            ),
            NumerosEmergencia(
                "Seguridad Pública y Tránsito",
                "55 3622 2730"
            ),
            NumerosEmergencia(
                "SAPASA (Servicios de Agua Potable)",
                "55 1083 6700"
            )
        )

        // Layout
        val layoutRV = LinearLayoutManager(requireContext())
        adaptador = AdaptadorNumerosEmergencia(requireContext(), arrNumerosEmergencia)
        layoutRV.orientation = LinearLayoutManager.VERTICAL
        binding.rvNumerosEmergencia.layoutManager = layoutRV
        binding.rvNumerosEmergencia.adapter = adaptador

        // Separador entre renglones
        val separador = DividerItemDecoration(requireContext(), layoutRV.orientation)
        binding.rvNumerosEmergencia.addItemDecoration(separador)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}