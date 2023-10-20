package com.example.fragmensqlite.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    final static private String tabla = "articulo";
    //final static private String tablaVenta = "venta";
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tablaCrea = "create table "+tabla+"(codigo int primary key, descripcion text, precio real)";
        //String tablaCreaVenta = "create table "+tablaVenta+"(codigo int primary key, descripcion text, precio real)";

        db.execSQL(tablaCrea);
        //db.execSQL(tablaCreaVenta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
