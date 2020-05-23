package app.bussines.v1.qualimax.data.model;

import java.util.ArrayList;
import java.util.List;

public class DadosModelPonto {

    private List<Ponto> listaPonto= new ArrayList<>();

    public void setListaPonto(int id,Ponto ponto){



        listaPonto.add(id,ponto);



    }

    public  List<Ponto> getListaPonto() {
        return  listaPonto;

    }
}
