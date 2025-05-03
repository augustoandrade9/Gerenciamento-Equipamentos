import java.util.ArrayList;

public class FuncionarioBusca {
    public static void procurarFuncionario(ArrayList<Funcionario> funcionarios, String busca) {
        boolean encontrado = false;
        busca = busca.toLowerCase();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().toLowerCase().contains(busca)) {
                System.out.println(funcionario.getNome());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum funcionário encontrado.");
        }
    }

}
