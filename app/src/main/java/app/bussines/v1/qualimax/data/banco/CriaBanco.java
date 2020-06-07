package app.bussines.v1.qualimax.data.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private  static final String DATABASE_NAME="bancoApp.db";
    //dados da maquina
    public static final String TABELA1 ="maquina";
    public static final String IDmaquina ="_id";
    public static final String DATACOMPRA="dataCompraMaquina";
    public static final String CAPACIDADE="capacidadeMaquina";
    public static final String TIPOMAQUINA="tipoMaquina";
    //dados do ponto
    public static final String TABELA2 ="ponto";
    public static final String IDponto = "_id";
    public static final String NOMEPONTO= "nome";
    public static final String TELEFONE= "telefone";
    public static final String EMAIL="email";
    public static final String CNPJ="cnpj";


    CriaBanco(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlMaquina);
        db.execSQL(sqlPonto);
    }
        private static final String sqlMaquina="CREATE TABLE "+ TABELA1 +"("+ IDmaquina +" integer primary key autoincrement,"+DATACOMPRA
                +" text,"+CAPACIDADE+" text,"
                +TIPOMAQUINA+" text"+")";

        private  static  final String sqlPonto="CREATE TABLE "+ TABELA2 +"("+ IDponto +" integer primary key autoincrement,"+NOMEPONTO
                +" text,"+TELEFONE+" text,"+EMAIL+" text,"+CNPJ+" text"+")";



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABELA2);
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA1);
        onCreate(db);
    }

}
