package app.bussines.v1.qualimax.data.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


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
        resultado = db.insert(CriaBanco.TABELA1,null,valores);
        db.close();
        if (resultado==-1)
            return "Erro ao inserir a maquina";
        else
            return "Registro efetuado com sucesso";
    }
    public Cursor carregaDadosMaquina(){
            Cursor cursor;
            String[] campos= {banco.IDmaquina,banco.DATACOMPRA,banco.CAPACIDADE,banco.TIPOMAQUINA};
            db=banco.getReadableDatabase();
            cursor = db.query(banco.TABELA1,campos,null,null,null,null,null,null);
            if(cursor!=null){
                cursor.moveToFirst();
            }
            db.close();
            return cursor;
    }

    public Cursor carregaDadosMaquinaAlterar(int id){
        Cursor cursor;
        String[] campos={banco.IDmaquina,banco.DATACOMPRA,banco.TIPOMAQUINA,banco.CAPACIDADE};
        String where=CriaBanco.IDmaquina + "=" +id;
        db= banco.getReadableDatabase();
        cursor= db.query(CriaBanco.TABELA1,campos,where,null,null,null,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public void alteradorMaquina(int id,String dataMaquina,String capacidadeMaquina, String tipoMaquina){
    ContentValues valores;
    String where;
    db = banco.getWritableDatabase();
    where=CriaBanco.IDmaquina + "=" + id;
        valores= new ContentValues();
        valores.put(CriaBanco.DATACOMPRA,dataMaquina);
        valores.put(CriaBanco.CAPACIDADE,capacidadeMaquina);
        valores.put(CriaBanco.TIPOMAQUINA,tipoMaquina);
        db.update(CriaBanco.TABELA1,valores,where,null);
        db.close();

    }
    public void carregaDadoDeletarMaquina(int id){
        String where= CriaBanco.IDmaquina + "=" + id;
        db=banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA1,where,null);
        db.close();

    }
}


