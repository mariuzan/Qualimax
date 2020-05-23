package app.bussines.v1.qualimax.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import app.bussines.v1.qualimax.R;
import app.bussines.v1.qualimax.data.model.DadosModelPonto;
import app.bussines.v1.qualimax.data.model.Ponto;

public class CadastrarPonto extends AppCompatActivity {
        DadosModelPonto dadosModelPonto = new DadosModelPonto();
        int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_ponto);
        Button botaoCadastro= findViewById(R.id.botaoCadastroPonto);

        //aqui tem a ligação com a janela xml
        final EditText pegaNome= findViewById(R.id.nomePonto);
        final EditText pegaTelefone= findViewById(R.id.telefonePonto);
        final EditText pegaEmail=findViewById(R.id.emailPonto);
        final EditText pegaCnpj=findViewById(R.id.cnpjPonto);



        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Ponto ponto= new Ponto(pegaNome.toString(),pegaTelefone.toString(),
                            pegaEmail.toString(),pegaCnpj.toString());


                    dadosModelPonto.setListaPonto(id++,ponto);


                    Toast.makeText(getApplicationContext(),"Ponto Adicionado com sucesso  !",
                            Toast.LENGTH_LONG).show();

                }
            }

        );

    }


    }


    /* private  void salvaDados(EditText pegaNome, EditText pegaTelefone, EditText pegaEmail, EditText pegaCnpj){
        ponto addPonto= new ponto(this.pegaNome, this.pegaTelefone, this.pegaEmail, this.pegaCnpj);
        listaPonto.add(addPonto);

         Toast.makeText(getApplicationContext(),"teste"+listaPonto.get(1),Toast.LENGTH_LONG).show();

     }*/

    /*public List<ponto> getListaPonto() {
        return listaPonto;
    }*/


