package br.com.digitalhouse.desafio3_webservices.domain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafio3_webservices.R
import kotlinx.android.synthetic.main.login_body.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_cadastre_se.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))

        }
    }
}