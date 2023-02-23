package com.example.bolsaverde

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION)  {
    companion object {
        const val DATABASE_NAME = "app.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createUsersTable =
            "CREATE TABLE USERS (" +
                    "USER_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME TEXT," +
                    "EMAIL TEXT," +
                    "PASSWORD TEXT)"
        db?.execSQL(createUsersTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var deleteTable = "DROP TABLE IF EXISTS USERS"
        db?.execSQL(deleteTable)
    }

    fun addUser(name: String, email: String, password: String){
        var db = this.writableDatabase

        var user = ContentValues()
        user.put("NAME",name)
        user.put("EMAIL",email)
        user.put("PASSWORD",password)

        db.insert("USERS","USER_ID",user)
    }

    fun getUser(email: String, password: String): Cursor {
        var db = this.readableDatabase
        return db.rawQuery("SELECT email FROM USERS WHERE EMAIL = ? AND PASSWORD = ?", arrayOf(email, password))
    }
}