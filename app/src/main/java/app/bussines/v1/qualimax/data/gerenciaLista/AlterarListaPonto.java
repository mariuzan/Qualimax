package app.bussines.v1.qualimax.data.gerenciaLista;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import app.bussines.v1.qualimax.R;
import app.bussines.v1.qualimax.data.banco.ContratoPonto;
import app.bussines.v1.qualimax.data.banco.CriaBanco;

public class AlterarListaPonto extends AppCompatActivity {
    EditText nome;
    EditText telefone;
    EditText email;
    EditText cnpj;
    Button alterar;
    Button deletar;
    Cursor cursor;
    ContratoPonto crudPonto;
    String codigoPonto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alterardadosponto);
        codigoPonto = this.getIntent().getStringExtra("codigo");
        crudPonto = new ContratoPonto(getBaseContext());

        nome =(EditText)findViewById(R.id.nomePonto);
        telefone=(EditText)findViewById(R.id.telefonePonto);
        email=(EditText)findViewById(R.id.emailPonto);
        cnpj=(EditText)findViewById(R.id.cnpjPonto);
        alterar=(Button)findViewById(R.id.botaoAlterarPonto);
        deletar=(Button)findViewById(R.id.botaoDeletarPonto);

        cursor= crudPonto.carregaDadosPontosAlterar(Integer.parseInt(codigoPonto));
        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOMEPONTO)));
        telefone.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TELEFONE)));
        email.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.EMAIL)));
        cnpj.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CNPJ)));

        //aqui configura a alteração de dados
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crudPonto.alteradorPonto(Integer.parseInt(codigoPonto), nome.getText().toString()
                        ,telefone.getText().toString(),email.getText().toString(),cnpj.getText().toString());
                Intent intent= new Intent(AlterarListaPonto.this,GerenciaDadosPonto.class);
                startActivity(intent);
                finish();
            }
        });
        deletar.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                crudPonto.carregaDadoDeletarPontos(Integer.parseInt(codigoPonto));
                Intent intent = new Intent(AlterarListaPonto.this,GerenciaDadosPonto.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
