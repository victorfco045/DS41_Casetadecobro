package mx.edu.a22311091.utilidades

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class LoginFragment : Fragment() {

    private var users: List<User> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val user = view.findViewById<EditText>(R.id.username)
        val password = view.findViewById<EditText>(R.id.password)
        val button = view.findViewById<Button>(R.id.submit)

        button.setOnClickListener {
            validUsers()

            if(user.text != null && password.text != null) {

                val email = user.text.toString()
                val pass = password.text.toString()

                if(checkUser(email, pass, users)){
                    Toast.makeText(context,"Login Correcto",Toast.LENGTH_SHORT)
                        .show()

                    //TODO Cambiar a MainActivity
                    val i = Intent(view.context, MainActivity::class.java)
                    startActivity(i)
                    activity?.finish()

                } else {
                    Toast.makeText(context,
                        "Las credenciales no coinciden",
                        Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(
                    context,
                    "Ambos campos son requeridos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return view
    }

    private fun checkUser(username: String, password: String,
                          users: List<User>): Boolean {
        return users.any { user ->
            username == user.email && password == user.password
        }
    }

    private fun validUsers() {
        users = listOf(
            User(1, "victor@gmail.com", "123"),
            User(2, "victor1@gmail.com", "123a"),
            User(3, "victor2@gmail.com", "456"),
            User(4, "victor3@gmail.com", "789"),
            User(5, "victor4@gmail.com", "abc"),
            User(6, "victor5@gmail.com", "def"),
            User(7, "victor6@gmail.com", "ffwe"),
            User(8, "victor7@gmail.com", "gew"),
            User(9, "victor8@gmail.com", "dEFhbb"),
            User(10, "victor9@gmail.com", "rrguyg"),
        )
    }
}

