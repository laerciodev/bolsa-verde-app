package com.example.bolsaverde

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val db = DatabaseManager(this)
        val nameEditText = findViewById<TextInputEditText>(R.id.nameEditText)
        val emailEditText = findViewById<TextInputEditText>(R.id.emailEditText)
        val passwordEditText = findViewById<TextInputEditText>(R.id.passwordEditText)
        val confirmPasswordEditText = findViewById<TextInputEditText>(R.id.confirmPasswordEditText)
        val createAccountButton = findViewById<Button>(R.id.createAccount)

        createAccountButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (password != confirmPassword) {
                Toast.makeText(this, "Senhas diferentes", Toast.LENGTH_SHORT).show()
            } else {
                val user = db.getUser(email, password)
                if (user.moveToFirst()) {
                    Toast.makeText(this, R.string.email_exists, Toast.LENGTH_SHORT).show()
                } else {
                    db.addUser(name, email, password)
                    Toast.makeText(this, R.string.create_account_success, Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}