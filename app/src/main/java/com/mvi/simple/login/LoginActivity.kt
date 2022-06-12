package com.mvi.simple.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mvi.simple.MainActivity
import com.mvi.simple.R

class LoginActivity : AppCompatActivity() {

    private val errorMessageView: TextView by lazy { TODO() }
    private val progressBar: ProgressBar by lazy { TODO() }
    private val loginButton: View by lazy { TODO() }
    private val userName: EditText by lazy { TODO() }
    private val password: EditText by lazy { TODO() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //get view Model
        val viewModel=ViewModelProvider(this)[LoginViewModel::class.java]

     //   view(viewModel)

    }

    private fun view(viewModel: LoginViewModel) {
        viewModel.progressVisibility.observe(this) {
            progressBar.visibility = if (it) VISIBLE else GONE
        }

        loginButton.setOnClickListener {
            viewModel.Login(userName.text.toString(), password.text.toString())
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, "" + it.toString(), Toast.LENGTH_SHORT).show()
            errorMessageView.text = it?.toString()
        }
        viewModel.userToken.observe(this) {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}