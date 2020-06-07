package app.bussines.v1.qualimax.data.gerenciaLista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView;

import app.bussines.v1.qualimax.R;
import app.bussines.v1.qualimax.data.banco.ContratoMaquina;
import app.bussines.v1.qualimax.data.banco.CriaBanco;

public class GerenciaDadosMaquina extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerencia_dados_maquina);


        ContratoMaquina crud= new ContratoMaquina(getBaseContext());
        final Cursor cursor = crud.carregaDadosMaquina();
        String[] nomeCampos= new String[]{CriaBanco.ID,CriaBanco.DATACOMPRA,CriaBanco.CAPACIDADE,CriaBanco.TIPOMAQUINA};
        int[] idViews= new int[]{R.id.idMaquina,R.id.dataCompraMaquina,R.id.capacidadeMaquina,R.id.tipoMaquina};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_lista_maquina_customizada,cursor,nomeCampos,idViews,0);
        lista=(ListView)findViewById(R.id.ListViewMaquina);
        lista.setAdapter(adaptador);

        //alterar dados do banco
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo= cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ID));
                Intent intent= new Intent(GerenciaDadosMaquina.this,AlterarListaMaquina.class);
                intent.putExtra("codigo",codigo);
                startActivity(intent);
                finish();
            }
        });
    }


}
