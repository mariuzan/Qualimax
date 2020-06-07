package app.bussines.v1.qualimax.data.gerenciaLista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import app.bussines.v1.qualimax.R;
import app.bussines.v1.qualimax.data.banco.ContratoPonto;
import app.bussines.v1.qualimax.data.banco.CriaBanco;

public class GerenciaDadosPonto extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerencia_dados_ponto);


        ContratoPonto crud = new ContratoPonto(getBaseContext());
        final Cursor cursor = crud.carregaDadosPonto();
        String[] nomeCampos = new String[]{CriaBanco.IDponto, CriaBanco.NOMEPONTO, CriaBanco.TELEFONE, CriaBanco.EMAIL, CriaBanco.CNPJ};
        int[] idViews = new int[]{R.id.nomePonto, R.id.telefonePonto, R.id.emailPonto, R.id.cnpjPonto};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_lista_ponto_customizada, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.ListViewPontos);
        lista.setAdapter(adaptador);

        //alterar dados do banco
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.IDponto));
                Intent intent = new Intent(GerenciaDadosPonto.this, AlterarListaPonto.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}

