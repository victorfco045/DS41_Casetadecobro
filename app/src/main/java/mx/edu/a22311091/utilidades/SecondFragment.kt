package mx.edu.a22311091.utilidades

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlin.math.cos


class SecondFragment : Fragment() {

    private var costodelpasaje: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_secondfragment, container, false)

        val spinnerCasetas = view.findViewById<Spinner>(R.id.spinner)
        val spinnerVehiculos = view.findViewById<Spinner>(R.id.spinner2)
        val editTextFecha = view.findViewById<EditText>(R.id.editText)
        val button = view.findViewById<Button>(R.id.to_third)

        val casetasOptions = resources.getStringArray(R.array.casetas_options)
        val vehiculosOptions = resources.getStringArray(R.array.vehiculos_options)

        val adapterCasetas = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item,casetasOptions
        )
        adapterCasetas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCasetas.adapter = adapterCasetas

        val adapterVehiculos = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, vehiculosOptions)
        adapterVehiculos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerVehiculos.adapter = adapterVehiculos

        button.setOnClickListener {
            val casetaSeleccionada = spinnerCasetas.selectedItem.toString()
            val vehiculoSeleccionado = spinnerVehiculos.selectedItem.toString()
            val fechaIngresada = editTextFecha.text.toString()
            costodelpasaje = calcularCosto(vehiculoSeleccionado)

            showToast("Caseta Seleccionada: $casetaSeleccionada")
            showToast("Costo: $costodelpasaje")
            showToast("Fecha ingresada: $fechaIngresada")

            val bundle = Bundle()
            bundle.putDouble("costoTotal", costodelpasaje)
            val controller: NavController = Navigation.findNavController(view)
            controller.navigate(R.id.action_secondfragment_to_threefragment, bundle)
        }

        return view
    }

    private fun calcularCosto(tipoVehiculo: String): Double {
        return when (tipoVehiculo) {
            "Carro" -> 100.0
            "Moto" -> 50.0
            "Camion" -> 150.0
            else -> 0.0
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}


