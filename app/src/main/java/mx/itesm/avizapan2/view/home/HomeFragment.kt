package mx.itesm.avizapan2.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.avizapan2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // Binding
    private var _binding: FragmentHomeBinding? = null

    // ViewModel
    private val homeViewModel: HomeViewModel by viewModels()

    // Adaptador
    private lateinit var adaptador: AdaptadorNoti

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onStart() {
        super.onStart()
        // ViewModel
        homeViewModel.descargarNotisActivas()
        // RecyclerView
        configurarRV()
        // Observables
        configurarObservables()
    }

    private fun configurarObservables() {
        homeViewModel.listaNotificaciones.observe(this) { lista ->
            val arrNotis = lista.toTypedArray()
            adaptador.arrNotis = arrNotis
            adaptador.notifyDataSetChanged()
        }
    }

    private fun configurarRV() {
        val arrNotis = arrayOf(
            Notificacion(
                1.0,
                "Título1",
                "Descripción1",
                0.0,
                "2022-09-27T10:25:03.000Z",
                1.0
            ),
            Notificacion(
                2.0,
                "Título2",
                "Descripción2",
                0.0,
                "2022-09-27T10:25:03.000Z",
                1.0
            )
        )

        val layoutRV = LinearLayoutManager(requireContext())
        adaptador = AdaptadorNoti(requireContext(), arrNotis)
        layoutRV.orientation = LinearLayoutManager.VERTICAL
        binding.rvNotis.layoutManager = layoutRV
        binding.rvNotis.adapter = adaptador

        // Separador entre cajas
        val separador = DividerItemDecoration(requireContext(), layoutRV.orientation)
        binding.rvNotis.addItemDecoration(separador)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}