package br.com.digitalhouse.desafio3_webservices.domain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafio3_webservices.R
import br.com.digitalhouse.desafio3_webservices.domain.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private val scopeSplash = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splash = this
        scopeSplash.launch {
            delay(5000)
            startActivity(Intent(splash, LoginActivity::class.java))
            finish()
        }
    }
}