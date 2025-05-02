import java.util.ArrayList;
import java.util.Objects;

public class EquipamentoBusca {
public String busca(String nome,ArrayList<Equipamento> equipamentos){
    StringBuilder sb = new StringBuilder();
    boolean encontrado = false;
    for(Equipamento e : equipamentos){
        if(Objects.equals(e.getNome().toLowerCase(),nome.toLowerCase())){
            encontrado = true;
            for(Manutencao m : Manutencao.equipManu){
                if(Objects.equals(m.getEquipamento(),e)){
                    sb.append(e.getNome());
                    sb.append("\n");
                    sb.append(m.getDescricao ());
                    return sb.toString();
                }
                else{
                    return e.getNome ();
                }

            }
        }else{
            if(e.getNome().toLowerCase().contains(nome.toLowerCase())) {
                for (Manutencao m : Manutencao.equipManu) {
                    if (Objects.equals (m.getEquipamento (), e)) {
                        encontrado = true;
                        sb.append(e.getNome());
                        sb.append("\n");
                        sb.append(m.getDescricao ());
                        return sb.toString();
                    }else{
                        return e.getNome();
                    }
                }
            }
            }
}
if(encontrado == false){
    return "Equipamento nao existe";
}
    return sb.toString ();
}

}
