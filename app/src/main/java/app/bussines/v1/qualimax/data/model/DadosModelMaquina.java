package app.bussines.v1.qualimax.data.model;

import java.util.ArrayList;
import java.util.List;

public class DadosModelMaquina {

    public List<Maquina> listaMaquinaArray = new ArrayList<>();




    public  void setListaMaquinaArray(Maquina maquina){
        listaMaquinaArray.add(maquina);
    }

    public List<Maquina> getListaMaquinaArray() {
        return listaMaquinaArray;
    }
}
