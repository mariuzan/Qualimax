package app.bussines.v1.qualimax.data.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CriaBanco extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private  static final String DATABASE_NAME="bancoApp.db";
    public static final String TABELA="maquina";
    public static final String ID="_id";
    public static final String DATACOMPRA="dataCompraMaquina";
    public static final String CAPACIDADE="capacidadeMaquina";
    public static final String TIPOMAQUINA="tipoMaquina";


    CriaBanco(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+TABELA+"("+ID+" integer primary key autoincrement,"+DATACOMPRA+" text,"+CAPACIDADE+" text,"
                +TIPOMAQUINA+" text"+")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABELA);
        onCreate(db);
    }
}
