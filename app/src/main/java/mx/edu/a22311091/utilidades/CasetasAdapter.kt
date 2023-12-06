package mx.edu.a22311091.utilidades

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CasetasAdapter(private val caseta: List<Casetas>):
    RecyclerView.Adapter<CasetasAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val casetas = caseta[position]
        holder.render(casetas)
    }

    override fun getItemCount(): Int {
        return caseta.size
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val ciudad: TextView = view.findViewById(R.id.caseta_name)
        val estado: TextView = view.findViewById(R.id.caseta_estado)
        val pais: TextView = view.findViewById(R.id.caseta_pais)
        val paisaje: ImageView = view.findViewById(R.id.caseta_paisaje)
        val image: ImageView = view.findViewById(R.id.caseta_image)

        fun render(caseta: Casetas) {
            ciudad.text = caseta.ciudad + ", "
            estado.text = caseta.estado
            pais.text = caseta.pais
            Picasso.get().load(caseta.paisaje).into(paisaje)
            Picasso.get().load(caseta.image).into(image)
        }
    }

}