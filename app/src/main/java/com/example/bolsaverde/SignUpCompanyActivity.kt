package com.example.bolsaverde

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class SignUpCompanyActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_company)

        val createAccountButton = findViewById<Button>(R.id.createAccount)

        createAccountButton.setOnClickListener {
            Toast.makeText(this, R.string.create_account_success, Toast.LENGTH_SHORT).show()
        }
    }
}