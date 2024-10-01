package com.example.agendaroom

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agendaroom.adapter.ContactAdapter
import com.example.agendaroom.models.Contact
import com.example.agendaroom.repository.AppDatabase

class MainActivity : AppCompatActivity() {

    lateinit var contacts: List<Contact>

    lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadContacts()

        //Acceso al RecyclerView, el adaptador y el LinearLayoutManager
        val rvContacts = findViewById<RecyclerView>(R.id.rvContact)
        contactAdapter = ContactAdapter(contacts)
        rvContacts.adapter = contactAdapter
        rvContacts.layoutManager = LinearLayoutManager(this)

    }

    private fun loadContacts() {
        //Acceso al getAll, la base de datos
        contacts = AppDatabase.getInstance(this).getDao().getAll()
        //AppDatabase.getInstance(this).getDao().getAll() => A diferencia de la linea anterior, esta linea no guarda los datos en una variable, solo los obtiene


    }
}