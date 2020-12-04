package br.com.digitalhouse.desafio3_webservices.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.digitalhouse.desafio3_webservices.R
import kotlinx.android.synthetic.main.login_body.view.*

class FragmentLogin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        loginHQ(view)
        register(view)

        return view
    }

    private fun loginHQ(view: View) {
        view.btn_login.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentListHQ)
        }
    }

    private fun register(view: View) {
        view.btn_cadastro.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentCadastro)
        }
    }
}