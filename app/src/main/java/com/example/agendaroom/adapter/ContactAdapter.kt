package com.example.agendaroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.agendaroom.R
import com.example.agendaroom.models.Contact

class ContactAdapter(val contacts: List<Contact>): Adapter<ContactPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_contact, parent, false)
        return ContactPrototype(view)
    }

    override fun onBindViewHolder(holder: ContactPrototype, position: Int) {
        holder.bind(contacts[position])
        //holder.bind(contacts.get(position)) => A diferencia de la linea anterior, esta linea no es correcta ya que get() no es un metodo de la clase List
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}

class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvPhone = itemView.findViewById<TextView>(R.id.tvPhone)
    val cvContact = itemView.findViewById<CardView>(R.id.cvContact)

    fun bind(contact: Contact) {
        tvName.text = contact.name
        tvPhone.text = contact.phone
    }

}
