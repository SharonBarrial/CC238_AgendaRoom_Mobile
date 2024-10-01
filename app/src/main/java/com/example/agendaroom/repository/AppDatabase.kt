package com.example.agendaroom.repository

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.agendaroom.models.Contact

@Database(entities = arrayOf(Contact::class), version = 1)
/**
 * Clase Abstracta: se utiliza para no instanciarla
 * Clase = Plantilla de la cual creo objetos
 * Clase abstracta = usar la clase directamente sin crear objetos, es decir, no se puede hacer un new
 */

abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao(): ContactDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: android.content.Context): AppDatabase {
            //Aqui nos preguntamos si la base de datos existe
            if (INSTANCE == null) {
                //la BD no existe, entonces la creamos
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "contacts.db")
                    .allowMainThreadQueries()
                    .build()
            }
            //retornamos la BD
            return INSTANCE as AppDatabase
            //return INSTANCE!! => Esto es lo mismo que la linea anterior, pero con !! le decimos a Kotlin que no puede ser nulo
        }
    }
}