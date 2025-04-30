import java.util.ArrayList;
import java.util.Objects;

public class EquipamentoBusca {
public String busca(String nome,ArrayList<Equipamento> equipamentos){
    StringBuilder sb = new StringBuilder();
    boolean encontrado = false;
    for(Equipamento e : equipamentos){
        if(Objects.equals(e.getNome().toLowerCase(),nome.toLowerCase())){
            encontrado = true;
            return e.getNome();
        }else{
            if(e.getNome().toLowerCase().contains(nome.toLowerCase())){
                sb.append(e.getNome());
                sb.append("\n");
                encontrado = true;
            }
    }
}
if(encontrado == false){
    return "Equipamento nao existe";
}
    return sb.toString ();
}

}
