package com.example.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null,
        DATABASE_VERSION
    ) {
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "DatabaseMahasiswa"
        private val TABLE_CONTACTS = "TabelMahasiswa"
        private val KEY_ID = "_id"
        private val KEY_NAMA = "nama"
        private val KEY_NIM = "nim"
    }

    override fun onCreate(db: SQLiteDatabase?) {
//Membuat tabel
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " +
                TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_NAMA + " TEXT,"
                + KEY_NIM + " TEXT" + ")")
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?, oldVersion:
        Int, newVersion: Int
    ) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db)
    }

    //Fungsi untuk memasukkan data
    fun tambahMahasiswa(emp: DataModelClass): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_NAMA, emp.nama)
        contentValues.put(KEY_NIM, emp.nim)

//Memasukkan detail mahasiswa menggunakan query
        val success = db.insert(
            TABLE_CONTACTS, null,
            contentValues
        )
        db.close() //Menutup database
        return success
    }
}