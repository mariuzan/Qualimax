package app.bussines.v1.qualimax.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import app.bussines.v1.qualimax.R;

public class PosLogin extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_login);

    }
    public void proximaTelaMaquina(View view){
        Intent intent= new Intent(this, CadastrarMaquina.class);

            startActivity(intent);

    }
    public void proximaTelaPonto(View view){
        Intent intent = new Intent(this, CadastrarPonto.class);
        startActivity(intent);

    }
    public void proximaTelaGerenciarDados(View view){

        Intent intent= new Intent(this,VerDados.class);

        startActivity(intent);

    }

}
