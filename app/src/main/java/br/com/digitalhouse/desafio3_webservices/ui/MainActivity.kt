package br.com.digitalhouse.desafio3_webservices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import br.com.digitalhouse.desafio3_webservices.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startNavigation()
    }
    private fun startNavigation() {
        navController = findNavController(R.id.nav_host_fragment_container)
    }
}