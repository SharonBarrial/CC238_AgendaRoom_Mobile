package com.example.agendaroom.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.agendaroom.models.Contact

@Dao
interface ContactDao {
    //CRUD

    @Query("SELECT * FROM contact")
    //Obtener todos los contactos
    fun getAll(): List<Contact>

    @Insert
    //Insertar un contacto
    fun insertContact(vararg contacts: Contact) //vararg: varios argumentos

    @Delete
    //Eliminar un contacto
    fun deleteContact(vararg contacts: Contact)

    @Update
    //Actualizar un contacto
    fun updateContact(vararg contacts: Contact)
}