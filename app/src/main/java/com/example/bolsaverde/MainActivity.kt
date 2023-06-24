package com.example.bolsaverde

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val db = DatabaseManager(this)

        val emailInput = findViewById<TextInputLayout>(R.id.email_layout)
        val emailEditText = findViewById<TextInputEditText>(R.id.email_edit_text)
        val passwordEditText = findViewById<TextInputEditText>(R.id.passwordEditText)
        val createAccountLink = findViewById<TextView>(R.id.create_account_link)
        val loginButton = findViewById<Button>(R.id.loginButton)

        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val email = s.toString()

                if (TextUtils.isEmpty(email)) {
                    emailInput.error = getString(R.string.empty_email)
                    return
                }
                val isValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                if (isValid) {
                    emailInput.error = null
                } else {
                    emailInput.error = getString(R.string.invalid_email)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        createAccountLink.setOnClickListener {
            val intent = Intent(this, ChoosePersonActivity::class.java)
            startActivity(intent)
        }

        fun goToDashboard() {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val cursor = db.getUser(email, password)

            if (cursor.moveToFirst()) {
                goToDashboard()
            } else {
                Toast.makeText(this, R.string.login_error, Toast.LENGTH_SHORT).show()
            }
        }
    }
}