package app.bussines.v1.qualimax.data.gerenciaLista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.bussines.v1.qualimax.R;
import app.bussines.v1.qualimax.data.banco.ContratoMaquina;
import app.bussines.v1.qualimax.data.banco.CriaBanco;
import app.bussines.v1.qualimax.data.model.Maquina;

public class AlterarListaMaquina extends AppCompatActivity {
    EditText dataCompraMaquina;
    EditText capacidadeMaquina;
    EditText tipoMaquina;
    Button alterar;
    Button deletar;
    Cursor cursor;
    ContratoMaquina crud;
    String codigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alterardadosmaquina);
        codigo= this.getIntent().getStringExtra("codigo");
        crud= new ContratoMaquina(getBaseContext());

        dataCompraMaquina=(EditText)findViewById(R.id.dataCompraMaquina);
        capacidadeMaquina=(EditText)findViewById(R.id.capacidadeMaquina);
        tipoMaquina=(EditText)findViewById(R.id.tipoMaquina);
        alterar=(Button)findViewById(R.id.botaoAlterarMaquina);
        deletar=(Button)findViewById(R.id.botaoDeletarMaquina);

        cursor= crud.carregaDadosMaquinaAlterar(Integer.parseInt(codigo));
        dataCompraMaquina.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.DATACOMPRA)));
        capacidadeMaquina.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CAPACIDADE)));
        tipoMaquina.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TIPOMAQUINA)));

        //aqui configura a alteração de dados
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteradorMaquina(Integer.parseInt(codigo),dataCompraMaquina.getText().toString()
                        ,capacidadeMaquina.getText().toString(),tipoMaquina.getText().toString());
                Intent intent= new Intent(AlterarListaMaquina.this,GerenciaDadosMaquina.class);
                startActivity(intent);
                finish();
            }
        });
        deletar.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                crud.carregaDadoDeletarMaquina(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarListaMaquina.this,GerenciaDadosMaquina.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
