package mx.itesm.avizapan2.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {

    // Descargar datos del API desde una URL
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://avizapan-app-3s4eu.ondigitalocean.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Instancia que crea el objeto que realizará la descarga
    private val avizapanAPI by lazy {
        retrofit.create(AvizapanAPI::class.java)
    }

    // Variables observables
    val listaNotificaciones = MutableLiveData<List<Notificacion>>()

    fun descargarNotisActivas() {
        val call = avizapanAPI.descargarNotisActivas()
        call.enqueue(object: Callback<List<Notificacion>> {
            override fun onResponse(call: Call<List<Notificacion>>,
                                    response: Response<List<Notificacion>>) {
                if (response.isSuccessful) {
                    println("Lista de notificaciones: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listaNotificaciones.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<List<Notificacion>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }

    fun filtrarNotisActivas(category: String){
        var categoryDouble = 0.0
        // sacar valor de spinner, pasarlo a double y mandarlo a las funciones
        if (category == "Mostrar todo") {
            descargarNotisActivas()
            return
        }
        else if (category == "Vialidad") {
            categoryDouble = 1.0
        }
        else if (category == "Clima") {
            categoryDouble = 2.0
        }
        else if (category == "Sismos") {
            categoryDouble = 5.0
        }
        else {
            categoryDouble = 6.0
        }
        val call = avizapanAPI.filtrarNotisActivas(categoryDouble.toString())
        call.enqueue(object: Callback<List<Notificacion>> {
            override fun onResponse(call: Call<List<Notificacion>>,
                                    response: Response<List<Notificacion>>) {
                if (response.isSuccessful) {
                    println("Lista de notificaciones: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listaNotificaciones.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<List<Notificacion>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}