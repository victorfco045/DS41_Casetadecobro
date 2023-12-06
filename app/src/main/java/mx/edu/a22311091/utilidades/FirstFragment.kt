package mx.edu.a22311091.utilidades

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FirstFragment : Fragment() {

    private var casetas : List<Casetas> = emptyList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_firstfragment, container, false)

        val second = view.findViewById<Button>(R.id.second_button)

        second.setOnClickListener {
            val controller : NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_firstfragment_to_secondfragment)
        }


        initData()
        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.countriesRecycler
            )
        val adapter = CasetasAdapter(casetas)
        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {
        casetas = listOf(
            Casetas(1, "Hermosillo", "Sonora", "Mexico", "https://th.bing.com/th/id/OIP.efapcqq_g37gJyFlYP6gbQHaKN?rs=1&pid=ImgDetMain", "https://4.bp.blogspot.com/-Xc1iBxU4wwk/Uen-cImOkHI/AAAAAAAABSc/O46k4NAY4nU/s16000/caseta-de-cobro-en-mexico.jpg"),
            Casetas(2, "Nogales", "Sonora", "Mexico", "https://i.pinimg.com/736x/c1/14/fa/c114fa8d9f0f9e671d151358196f629f---states-united-states.jpg", "https://th.bing.com/th/id/R.96750b3951a4d98c480aa1588409516e?rik=dW47k%2fs70QxVOg&pid=ImgRaw&r=0"),
            Casetas(3,"Obregon","Sonora","Mexico","https://th.bing.com/th/id/R.65db87436e9208fc70f28534201081c4?rik=EHkhE5mV8dHkAA&pid=ImgRaw&r=0", "https://i.ytimg.com/vi/0KjE5uWXTwA/hqdefault.jpg?sqp=-oaymwEmCOADEOgC8quKqQMa8AEB-AHUBoAC4AOKAgwIABABGGUgVihKMA8=&rs=AOn4CLCm0Pz1Y1X0r7i-bsupR_u-K35Rqg"),
            Casetas(4, "Guaymas", "Sonora", "Mexico", "https://th.bing.com/th/id/OIP.nTyqV9D4h1NS3cw-tPoo2QHaE9?rs=1&pid=ImgDetMain", "https://th.bing.com/th/id/OIP.zHwDT6iPQRwzdURQY6U5UgHaEo?rs=1&pid=ImgDetMain"),
            Casetas(5, "Magdalena", "Sonora", "Mexico", "https://panoramacultural.com.co/media/images/articulos/2021/02/19104948.jpg", "https://www.elimparcial.com/__export/1555353607466/sites/elimparcial/img/2017/09/02/1726302-N.JPG_673822677.jpg"),
            Casetas(6, "Navojoa", "Sonora", "Mexico", "https://th.bing.com/th/id/OIP.IPN9FxGhEa93N1Sj414G3gHaEK?rs=1&pid=ImgDetMain", "https://th.bing.com/th/id/OIP.Mbkpd49ny0rq_3of16KBZAHaEn?rs=1&pid=ImgDetMain"),
            Casetas(7,"Caborca", "Sonora", "Mexico", "https://i.pinimg.com/736x/94/22/1f/94221fce60c60d1e2a729bb032822b50.jpg", "https://4.bp.blogspot.com/-Xc1iBxU4wwk/Uen-cImOkHI/AAAAAAAABSc/O46k4NAY4nU/s16000/caseta-de-cobro-en-mexico.jpg"),
            Casetas(8, "Puerto peñasco", "Sonora", "Mexico", "https://th.bing.com/th/id/R.52ebdd0e74e8a77157df051a3af9e69a?rik=RvcJ5T4TkPmyow&pid=ImgRaw&r=0", "https://fastly.4sqi.net/img/general/600x600/46240243_1HLtGGs0CgzhpzLgOUxUFC31b2-ka17jDfmcP5VF0cI.jpg"),
            Casetas(9,"San luis", "Sonora", "Mexico", "https://i0.wp.com/fueradeeje.com/wp-content/uploads/2020/04/DESTINOS-PARA-CONOCER-EN-SAN-LUIS-02.jpg?resize=800%2C534&ssl=1", "https://www.meganoticias.mx/uploads/noticias/estado-actual-de-la-caseta-de-cobro-san-luis-bc-183464.png"),
            Casetas(10, "Ures", "Sonora", "Mexico", "https://www.soycobre.com/wp-content/uploads/2023/06/IGLESIA-URES-1200x628-cropped.jpg", "https://th.bing.com/th/id/OIP.s-k2pyCauyORSkOSEjXOXwHaFj?rs=1&pid=ImgDetMain")
        )
    }


}

