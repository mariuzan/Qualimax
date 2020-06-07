package app.bussines.v1.qualimax.data.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ContratoPonto {private SQLiteDatabase db;
    private CriaBanco banco;


    public ContratoPonto(Context context){
        banco=new CriaBanco(context);

    }


    public String InsereDadoPonto(String nomePonto,String telefonePonto,String emailPonto, String cnpjPonto){
        ContentValues valores;
        long resultado;

        db=banco.getWritableDatabase();
        valores= new ContentValues();
        valores.put(CriaBanco.NOMEPONTO,nomePonto);
        valores.put(CriaBanco.TELEFONE,telefonePonto);
        valores.put(CriaBanco.EMAIL,emailPonto);
        valores.put(CriaBanco.CNPJ,cnpjPonto);
        resultado = db.insert(CriaBanco.TABELA2,null,valores);
        db.close();
        if (resultado==-1)
            return "Erro ao inserir o ponto";
        else
            return "Registro efetuado com sucesso";
    }
    public Cursor carregaDadosPonto(){
        Cursor cursor;
        String[] campos= {banco.IDponto,banco.NOMEPONTO,banco.TELEFONE,banco.EMAIL,banco.CNPJ};
        db=banco.getReadableDatabase();
        cursor = db.query(banco.TABELA2,campos,null,null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosPontosAlterar(int id){
        Cursor cursor;
        String[] campos={banco.IDponto,banco.NOMEPONTO,banco.TELEFONE,banco.EMAIL,banco.CNPJ};
        String where=CriaBanco.IDponto + "=" +id;
        db= banco.getReadableDatabase();
        cursor= db.query(CriaBanco.TABELA2,campos,where,null,null,null,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public void alteradorPonto(int id,String nomePonto,String telefone, String email,String cnpj){
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where=CriaBanco.IDponto + "=" + id;
        valores= new ContentValues();
        valores.put(CriaBanco.NOMEPONTO,nomePonto);
        valores.put(CriaBanco.TELEFONE,telefone);
        valores.put(CriaBanco.EMAIL,email);
        valores.put(CriaBanco.CNPJ,cnpj);
        db.update(CriaBanco.TABELA2,valores,where,null);
        db.close();

    }
    public void carregaDadoDeletarPontos(int id){
        String where= CriaBanco.IDponto + "=" + id;
        db=banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA2,where,null);
        db.close();

    }
}
