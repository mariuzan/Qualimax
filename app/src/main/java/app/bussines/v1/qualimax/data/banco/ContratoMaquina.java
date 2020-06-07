package app.bussines.v1.qualimax.data.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.bussines.v1.qualimax.data.banco.CriaBanco;


public class ContratoMaquina {
    private SQLiteDatabase db;
    private CriaBanco banco;


    public ContratoMaquina(Context context){
        banco=new CriaBanco(context);

    }

    public String InsereDadoMaquina(String dataCompraMaquina,String capacidadeMaquina,String tipoMaquina){
        ContentValues valores;
        long resultado;

        db=banco.getWritableDatabase();
        valores= new ContentValues();
        valores.put(CriaBanco.DATACOMPRA,dataCompraMaquina);
        valores.put(CriaBanco.CAPACIDADE,capacidadeMaquina);
        valores.put(CriaBanco.TIPOMAQUINA,tipoMaquina);
        resultado = db.insert(CriaBanco.TABELA,null,valores);
        db.close();
        if (resultado==-1)
            return "Erro ao inserir a maquina";
        else
            return "Registro efetuado com sucesso";
    }
    public Cursor carregaDadosMaquina(){
            Cursor cursor;
            String[] campos= {banco.ID,banco.DATACOMPRA,banco.CAPACIDADE,banco.TIPOMAQUINA};
            db=banco.getReadableDatabase();
            cursor = db.query(banco.TABELA,campos,null,null,null,null,null,null);
            if(cursor!=null){
                cursor.moveToFirst();
            }
            db.close();
            return cursor;
    }

    public Cursor carregaDadosMaquinaAlterar(int id){
        Cursor cursor;
        String[] campos={banco.ID,banco.DATACOMPRA,banco.TIPOMAQUINA,banco.CAPACIDADE};
        String where=CriaBanco.ID + "=" +id;
        db= banco.getReadableDatabase();
        cursor= db.query(CriaBanco.TABELA,campos,where,null,null,null,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}
