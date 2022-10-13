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
                "Bomberos Atizapán",
                "55 3622 1004"
            ),
            NumerosEmergencia(
                "Cruz Roja",
                "5822 5547 / 5822 8151"
            ),
            NumerosEmergencia(
                "Emergencias Atizapán (C4)",
                "5366 7193"
            ),
            NumerosEmergencia(
                "Seguridad Pública",
                "1106 2163"
            ),
            NumerosEmergencia(
                "Policía Federal de Caminos",
                "5684 2142 / 5684 9710"
            ),
            NumerosEmergencia(
                "Incendios Forestales",
                "5554 0612 / 01 800 00 77 100"
            ),
            NumerosEmergencia(
                "Comisión de Derechos Humanos",
                "5299 5600"
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