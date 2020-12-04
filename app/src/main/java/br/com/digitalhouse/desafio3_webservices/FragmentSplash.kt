package br.com.digitalhouse.desafio3_webservices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FragmentSplash : Fragment() {

    val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        goLogin()
        return view
    }

    private fun goLogin() {
        scope.launch {
            delay(5000)
            findNavController().navigate(R.id.action_fragmentSplash_to_fragmentLogin)
        }
    }
}