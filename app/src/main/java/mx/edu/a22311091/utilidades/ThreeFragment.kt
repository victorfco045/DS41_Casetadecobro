package mx.edu.a22311091.utilidades

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation


class ThreeFragment : Fragment() {


    private var costoTotal: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_threefragment, container, false)

        val textViewCosto = view.findViewById<TextView>(R.id.textView3)
        val editTextPago = view.findViewById<EditText>(R.id.editTextText3)
        val buttonPagar = view.findViewById<Button>(R.id.to_first)
        val textViewCambio = view.findViewById<TextView>(R.id.result)

        costoTotal = arguments?.getDouble("costoTotal") ?: 0.0
        textViewCosto.text = "Costo Total: $$costoTotal"

        buttonPagar.setOnClickListener {
            val pagoTexto = editTextPago.text.toString()

            if (pagoTexto.isNotEmpty()) {
                val pagoUsuario = pagoTexto.toDouble()
                val cambio = pagoUsuario - costoTotal
                textViewCambio.text = "Cambio: $$cambio"
            } else {
                textViewCambio.text = "No ingresaste la cantidad!!"
            }
        }

        return view
    }


}