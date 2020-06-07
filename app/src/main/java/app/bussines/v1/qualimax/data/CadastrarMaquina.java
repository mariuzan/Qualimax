package app.bussines.v1.qualimax.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.bussines.v1.qualimax.R;
import app.bussines.v1.qualimax.data.banco.ContratoMaquina;

public class CadastrarMaquina extends AppCompatActivity {
         //DadosModelMaquina dadosModelMaquina = new DadosModelMaquina();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_maquina);
        Button botaoMaquina=findViewById(R.id.botaoCadastroMaquina);



        botaoMaquina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContratoMaquina crud= new ContratoMaquina(getBaseContext());
                //final EditText pegaIdMaquina=findViewById(R.id.idMaquina);
                 EditText dataCompraMaquina=(EditText) findViewById(R.id.dataCompraMaquina);
                 EditText capacidadeMaquina=(EditText)findViewById(R.id.capacidadeMaquina);
                 EditText tipoMaquina=(EditText)findViewById(R.id.tipoMaquina);
                 String dataCompraMaquitring=dataCompraMaquina.getText().toString();
                 String capacidadeMaquinaString=capacidadeMaquina.getText().toString();
                 String tipoMaquinString=tipoMaquina.getText().toString();
                 String resultado;
                 resultado=crud.InsereDadoMaquina(dataCompraMaquitring,capacidadeMaquinaString,tipoMaquinString);
                 Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_LONG).show();


               /* metodo antigo
               Maquina maquina= new Maquina(pegaIdMaquina.toString()
                        ,pegaDataCompraMaquina.toString(),
                        pegaCapacidadeMaquina.toString(),
                        pegaTipoMaquina.toString());

                     dadosModelMaquina.setListaMaquinaArray(maquina);

                Toast.makeText(getApplicationContext(),"Maquina Adicionada com Sucesso!! ",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"dasdas"+dadosModelMaquina.getListaMaquinaArray().toString(),Toast.LENGTH_LONG).show();*/
            }
        });






    }
}
