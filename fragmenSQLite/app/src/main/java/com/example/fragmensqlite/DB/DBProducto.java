package com.example.fragmensqlite.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fragmensqlite.Model.Producto;

import java.util.ArrayList;
import java.util.List;

public class DBProducto {
    private AdminSQLiteOpenHelper adminSQLiteOpenHelper;

    public DBProducto(Context context) {
        this.adminSQLiteOpenHelper = new AdminSQLiteOpenHelper(context, "administracion", null, 1);
    }

    //Inser
    public int insertPro(Producto i){
        try {
            SQLiteDatabase bd = this.adminSQLiteOpenHelper.getWritableDatabase();
            String cod = String.valueOf(i.getCod());
            String descri = i.getDescripcion();
            String precio = String.valueOf(i.getPrecio());
            ContentValues registro = new ContentValues();
            registro.put("codigo", cod);
            registro.put("descripcion", descri);
            registro.put("precio", precio);
            bd.insert("articulo", null, registro);
            bd.close();
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    public List<Producto> listaProducto(){
        List<Producto> productList = new ArrayList<>();
        SQLiteDatabase bd = this.adminSQLiteOpenHelper.getWritableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM articulo", null);
        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String descrip = cursor.getString(1);
                double precio = cursor.getDouble(2);
                Producto prod = new Producto(id, descrip, precio);
                productList.add(prod);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return productList;
    }
}
