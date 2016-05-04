package pl.edu.ur.kulturalia;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteAssetHelper {
    private static String databasePath;
    public static String databaseName = "kulturalia.db";
    private SQLiteDatabase myDataBase;
    private final Context myContext;


    public DatabaseHelper(Context context) {

        super(context, databaseName, null, 1);

        this.myContext = context;
        databasePath=myContext.getDatabasePath("kulturalia").getPath();


    }








    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getKoncert(int id, String tableName) { //zwraca cursor z zadaną przez nas zawartością
        //id jest to nr koncertu danego dnia począwszy od 1
        // tableName to nazwa dnia w którym odbywa się koncert bez PL znaków(Czwartek, Piatek, Sobota)
        //przyklad uzycia
        //  DatabaseHelper db=new DatabaseHelper(this);
        //Cursor c= db.getKoncert(1,"Czwartek");
        //System.out.println(c.getString(1)+c.getString(2));
        // c.getString(1) zwraca nazwę koncertu
        //c.getString(2) zwraca czas koncertu
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {id+" _id", "nazwa","czas"};


        qb.setTables(tableName);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }


}