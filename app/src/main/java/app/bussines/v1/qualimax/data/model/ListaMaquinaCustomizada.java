package app.bussines.v1.qualimax.data.model;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import app.bussines.v1.qualimax.R;

public class ListaMaquinaCustomizada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_maquina_customizada);
        TextView dataCompraMaquina= findViewById(R.id.dataCompraMaquina);
        TextView capacidadeMaquina=findViewById(R.id.capacidadeMaquina);

    }
}
