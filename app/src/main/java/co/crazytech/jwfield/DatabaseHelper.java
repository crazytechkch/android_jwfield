package co.crazytech.jwfield;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eric on 12/8/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        createLocaleTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            default: break;
        }
    }

    private void createLocaleTable(){
        db.execSQL("create table languages (locale varchar(10), name varchar(150), basename varchar(150));");
        db.execSQL("insert into languages(locale,name,basename) values ('en','English','English');");
        db.execSQL("insert into languages(locale,name,basename) values ('zh','中文简体','Chinese (simplified)');");
    }


}
