package com.example.bolsaverde

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val companies = arrayListOf<Company>(
            Company("Banco do Brasil", "30", R.drawable.banco_do_brasil),
            Company("Petrobrás", "25", R.drawable.petrobras),
            Company("Nubank", "5", R.drawable.nubank),
            Company("Itaú", "25", R.drawable.itau),
            Company("Magalu", "4", R.drawable.magalu)
        )

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        itemAdapter = ItemAdapter(companies)
        recyclerView.adapter = itemAdapter
    }
}