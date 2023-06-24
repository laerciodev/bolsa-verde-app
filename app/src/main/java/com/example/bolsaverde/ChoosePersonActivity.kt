package com.example.bolsaverde

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChoosePersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_person)

        val createAccountUserButton = findViewById<Button>(R.id.createAccountUserButton);
        val createAccountCompanyButton = findViewById<Button>(R.id.createAccountCompanyButton);

        createAccountUserButton.setOnClickListener {
            val intent = Intent(this, SignUpUserActivity::class.java)
            startActivity(intent)
        }

        createAccountCompanyButton.setOnClickListener {
            val intent = Intent(this, SignUpCompanyActivity::class.java)
            startActivity(intent)
        }

    }
}