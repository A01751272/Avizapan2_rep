package mx.itesm.avizapan2.view.home

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationRequest
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Looper
import android.os.PersistableBundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.SupportMapFragment
import mx.itesm.avizapan2.BuildConfig
import mx.itesm.avizapan2.R
import mx.itesm.avizapan2.databinding.FragmentMasInfoBinding

class MasInfoFrag : Fragment() {

    // binding
    private lateinit var binding : FragmentMasInfoBinding

    // ViewModel
//    private val viewModel: MasInfoViewModel by viewModels()

    // Argumentos Navegacion
    private val args: MasInfoFragArgs by navArgs()

//    // Cliente proveedor de ubicación
//    private lateinit var clienteLocalizacion: FusedLocationProviderClient
//
//    // Callback para manejar las actualizaciones de ubicación
//    private lateinit var locationCallback: LocationCallback
//
//    // Para saber si las actualizaciones están activas
//    private var actualizandoPosicion: Boolean = false
//
//    // Código para solicitar permiso de usar la ubicación
//    private val CODIGO_PERMISO_GPS = 200

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
        // TODO: pasar lat y long al mapa para que despliegue
        //  un marcador en dichas coordenadas
//        val longitud = args.notificacion.longitud
//        val latitud = args.notificacion.latitud
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

//    override fun onStart() {
//        super.onStart()
//        if (! this::clienteLocalizacion.isInitialized) {
//            clienteLocalizacion = LocationServices.getFusedLocationProviderClient(this)
//            configurarGPS()
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        if (actualizandoPosicion) {
//            iniciarActualizacionesPosicion()
//        }
//    }
//
//    override fun onPause() {
//        super.onPause()
//        detenerActualizacionesPosicion()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        println("DETENIENDO")
//    }
//
//    // GPS
//
//    private fun mostrarMapa(posicion: Location) {
//        val uri = Uri.parse("geo:19.5942151,-99.2297187")
//        val intMapa = Intent(Intent.ACTION_VIEW, uri)
//        intMapa.setPackage("com.google.android.apps.maps")
//        startActivity(intMapa)
//    }
//
//    private fun tienePermiso(): Boolean {
//        val estado = ContextCompat.checkSelfPermission(requireActivity().application, // applicationContext
//            Manifest.permission.ACCESS_FINE_LOCATION)
//        return estado == PackageManager.PERMISSION_GRANTED
//    }
//
//    private fun configurarGPS() {
//        if (tienePermiso()) {
//            iniciarActualizacionesPosicion()
//        } else {
//            solicitarPermisos()
//        }
//    }
//
//    private fun solicitarPermisos() {
//        val requiereJustificacion = shouldShowRequestPermissionRationale(this,
//            Manifest.permission.ACCESS_FINE_LOCATION)
//        if (requiereJustificacion) {
//            mostrarDialogo()
//        } else { // Pedir el permiso directo
//            pedirPermisoUbicacion()
//        }
//    }
//
//    private fun mostrarDialogo() {
//        val dialogo = AlertDialog.Builder(requireContext())
//            .setMessage("Necesitamos saber tu posición para generar alertas")
//            .setPositiveButton("Aceptar") { dialog, which ->
//                pedirPermisoUbicacion()
//            }
//            .setNeutralButton("Cancelar", null)
//        dialogo.show()
//    }
//
//    private fun pedirPermisoUbicacion() {
//        ActivityCompat.requestPermissions(
//            requireActivity(),
//            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), CODIGO_PERMISO_GPS
//        )
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == CODIGO_PERMISO_GPS) {
//            if (grantResults.isEmpty()) {
//            } else if (grantResults.first() == PackageManager.PERMISSION_GRANTED) {
//                println("INICIAR las actualizaciones")
//            } else {
//                // Permiso negado
//                val dialogo = AlertDialog.Builder(requireContext())
//                dialogo.setMessage("Esta app requiere GPS, ¿Quieres habilitarlo manualmente?")
//                    .setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, which ->
//                        val intent = Intent()
//                        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
//                        val uri = Uri.fromParts("package",
//                            BuildConfig.APPLICATION_ID, null) // TODO: checar si es null
//                        intent.data = uri
//                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                        startActivity(intent)
//                    })
//                    .setNeutralButton("Cancelar", DialogInterface.OnClickListener { dialog, which ->
//                        println("No hay forma de usar gps, cerrar la actividad")
////Deshabilitar funcionalidad
//                    })
//                    .setCancelable(false)
//                dialogo.show()
//            }
//        }
//    }
//
//    private fun leerUltimaUbicacion() {
//        clienteLocalizacion = LocationServices.getFusedLocationProviderClient(this)
//        if (ActivityCompat.checkSelfPermission(
//                requireContext(),
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                requireContext(),
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            return
//        }
//        clienteLocalizacion.lastLocation
//            .addOnSuccessListener { location: Location? ->
//                println("Ultima ubicación: $location")
//            }
//    }
//
//    @SuppressLint("MissingPermission")
//    private fun iniciarActualizacionesPosicion() {
//        val locationRequest = LocationRequest.create()?.apply {
//            interval = 10000
//            fastestInterval = 10000
//            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        }
//        clienteLocalizacion.requestLocationUpdates(locationRequest,
//            locationCallback,
//            Looper.getMainLooper()
//        )
//        actualizandoPosicion = true
//    }
//
//    locationCallback = object : LocationCallback() {
//        override fun onLocationResult(locationResult: LocationResult?) {
//            locationResult ?: return
//            val posicion = locationResult.locations.last()
//            println("Nueva ubicación: $posicion")
//        }
//    }
//
//    private fun detenerActualizacionesPosicion() {
//        clienteLocalizacion.removeLocationUpdates(locationCallback)
//    }
//
//    override fun onSaveInstanceState(outState: Bundle, outPersistentState:
//    PersistableBundle
//    ) {
//        outState?.putBoolean("ActualizandoPosicion", actualizandoPosicion)
//        super.onSaveInstanceState(outState, outPersistentState)
//    }
//
//    private fun recuperarActualizandoPosicion(savedInstanceState: Bundle?) {
//        savedInstanceState ?: return
//        if (savedInstanceState.containsKey("ActualizandoPosicion")) {
//            actualizandoPosicion = savedInstanceState.getBoolean("ActualizandoPosicion")
//        }
//    }
//

}