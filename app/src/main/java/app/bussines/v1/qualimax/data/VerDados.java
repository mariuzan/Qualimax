package app.bussines.v1.qualimax.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.bussines.v1.qualimax.R;
import app.bussines.v1.qualimax.data.gerenciaLista.GerenciaDadosMaquina;
import app.bussines.v1.qualimax.data.gerenciaLista.GerenciaDadosPonto;

public class VerDados extends AppCompatActivity {
    Button botaoMaquina;
    Button botaoPonto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_dados);

        botaoMaquina=findViewById(R.id.verListaMaquina);
        botaoPonto=findViewById(R.id.verListaPonto);

    }

        public void irTelaVerMaquina(View view){

            Intent intent = new Intent(this, GerenciaDadosMaquina.class);

            startActivity(intent);

        }

        public void irVerTelaPonto(View view){

            Intent intent= new Intent(this, GerenciaDadosPonto.class);

            startActivity(intent);

        }
}
