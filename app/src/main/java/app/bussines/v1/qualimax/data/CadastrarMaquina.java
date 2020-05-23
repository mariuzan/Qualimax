package app.bussines.v1.qualimax.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import app.bussines.v1.qualimax.R;
import app.bussines.v1.qualimax.data.model.DadosModelMaquina;
import app.bussines.v1.qualimax.data.model.Maquina;

public class CadastrarMaquina extends AppCompatActivity {
         DadosModelMaquina dadosModelMaquina = new DadosModelMaquina();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_maquina);
        Button botaoMaquina=findViewById(R.id.botaoCadastroMaquina);

        final EditText pegaIdMaquina=findViewById(R.id.idMaquina);
        final EditText pegaDataCompraMaquina=findViewById(R.id.dataCompraMaquina);
        final EditText pegaCapacidadeMaquina=findViewById(R.id.capacidadeMaquina);
        final EditText pegaTipoMaquina=findViewById(R.id.tipoMaquina);

        botaoMaquina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Maquina maquina= new Maquina(pegaIdMaquina.toString()
                        ,pegaDataCompraMaquina.toString(),
                        pegaCapacidadeMaquina.toString(),
                        pegaTipoMaquina.toString());

                     dadosModelMaquina.setListaMaquinaArray(maquina);

                Toast.makeText(getApplicationContext(),"Maquina Adicionada com Sucesso!! ",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"dasdas"+dadosModelMaquina.getListaMaquinaArray().toString(),Toast.LENGTH_LONG).show();
            }
        });






    }
}
