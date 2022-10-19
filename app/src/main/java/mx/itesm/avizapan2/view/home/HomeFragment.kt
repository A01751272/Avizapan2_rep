package mx.itesm.avizapan2.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.avizapan2.R
import mx.itesm.avizapan2.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), ListenerRecycler {

    // Binding
    private var _binding: FragmentHomeBinding? = null

    // ViewModel
    private val homeViewModel: HomeViewModel by viewModels()

    // Adaptador
    private lateinit var adaptador: AdaptadorNoti

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
    }

    private fun configurarObservables() {
        homeViewModel.listaNotificaciones.observe(this) { lista ->
            val arrNotis = lista.toTypedArray()
            adaptador.arrNotis = arrNotis
            adaptador.notifyDataSetChanged()
        }
    }

    private fun configurarRV() {
        // Notificaciones por default en el feed
        val arrNotis = arrayOf(
            Notificacion(
                1.0,
                "Título1",
                "Humanity has never had more data about more facets of society than it does today. Computers are great for storing data sets, but those data sets have little value to society until they are analyzed by human beings. Computational techniques can guide humans on the road to deriving meaning from a data set.\n" +
                        "\n" +
                        "Clustering is a computational technique that divides the points in a data set into groups. A successful clustering results in groups that contain points that are related to one another. Whether those relationships are meaningful generally requires human verification.",
                0.0,
                -99.2675,
                19.5562,
                "2022-09-27T10:25:03.000Z",
                1.0
            ),
            Notificacion(
                2.0,
                "Título2",
                "Descripción2",
                0.0,
                -99.2675,
                19.5562,
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

        // Asigna el listener al adaptador
        adaptador.listener = this
    }

    private fun registrarEventos() {
        binding.spinnerFiltros.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            // Si no selecciona nada no muestra nada
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            // Selección del spinner
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val category = binding.spinnerFiltros.selectedItem.toString()
                homeViewModel.filtrarNotisActivas(category)
            }

        }

        binding.btnCreditoss.setOnClickListener {
            // Mostrar fragmento de créditos
            findNavController().navigate(R.id.action_navigation_home_to_creditosFrag)
        }
    }

    // Dar click en caja de notificaciones para mostrar + info
    override fun itemClicked(position: Int){
        // pasar valores al fragmento de más info
        val nombreNotificacion = adaptador.arrNotis[position]
        val accion = HomeFragmentDirections.actionNavigationHomeToMasInfoFrag(nombreNotificacion)
        findNavController().navigate(accion)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}