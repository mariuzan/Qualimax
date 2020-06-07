package app.bussines.v1.qualimax.data;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.bussines.v1.qualimax.R;
import app.bussines.v1.qualimax.data.banco.ContratoMaquina;
import app.bussines.v1.qualimax.data.banco.ContratoPonto;

public class CadastrarPonto extends AppCompatActivity {
         //DadosModelMaquina dadosModelMaquina = new DadosModelMaquina();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_ponto);
        Button botaoponto=findViewById(R.id.botaoCadastroPonto);



        botaoponto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContratoPonto crud= new ContratoPonto(getBaseContext());
                //final EditText pegaIdMaquina=findViewById(R.id.idMaquina);
                 EditText nome=(EditText) findViewById(R.id.nomePonto);
                 EditText telefone=(EditText)findViewById(R.id.telefonePonto);
                 EditText email=(EditText)findViewById(R.id.emailPonto);
                 EditText cnpj=(EditText)findViewById(R.id.cnpjPonto);


                 String nomePontoString=nome.getText().toString();
                 String telefoneString=telefone.getText().toString();
                 String emailString=email.getText().toString();
                 String cnpjString=cnpj.getText().toString();
                 String resultado;
                 resultado=crud.InsereDadoPonto(nomePontoString,telefoneString,emailString,cnpjString);
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
