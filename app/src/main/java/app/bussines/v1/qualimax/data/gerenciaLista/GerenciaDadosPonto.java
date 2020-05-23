package app.bussines.v1.qualimax.data.gerenciaLista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import app.bussines.v1.qualimax.R;
import app.bussines.v1.qualimax.data.model.DadosModelPonto;

public class GerenciaDadosPonto extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerencia_dados_ponto);

        recyclerView=(RecyclerView)findViewById(R.id.listapontoRecycler);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        DadosModelPonto modelPonto= new DadosModelPonto();

        modelPonto.getListaPonto();

    }
}
