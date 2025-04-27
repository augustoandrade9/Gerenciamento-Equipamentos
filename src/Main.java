import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios.add(new Funcionario(1, "João Silva", "joao.silva@empresa.com"));
        funcionarios.add(new Funcionario(2,"Mariana Souza", "mariana@empresa.com"));
        funcionarios.add(new Funcionario(3, "Carlos Rosa", "carlos.r@empresa.com"));
        funcionarios.add(new Funcionario(4, "Marcos Henrique", "m.henrique@empresa.com"));
        funcionarios.add(new Funcionario(5, "Mariano Rossi", "mariano@empresa.com"));
        funcionarios.add(new Funcionario(6, "Carmen Mello", "carmen@empresa.com"));
        funcionarios.add(new Funcionario(7, "João Pedro", "j.pedro@empresa.com"));
        funcionarios.add(new Funcionario(8, "João Bernardez","j.Bernardez@empresa.com"));
        funcionarios.add(new Funcionario(9,"Luiz Favero", "Luiz.F@empresa.com"));
        while(true) {
            System.out.println("=== Busca ===");
            System.out.println("Você gostaria de buscar um funcionário ou um equipamento? (f/e)");
            String control = scanner.nextLine();
            if (control.equalsIgnoreCase("f")) {
                System.out.println("Digite o nome do funcionário que deseja buscar: ");
                String busca = scanner.nextLine();
                FuncionarioBusca.procurarFuncionario(funcionarios, busca);
                break;
            }
            if (control.equalsIgnoreCase("e")) {
                System.out.println("equipamento busca bla bla bla");
                break;
            } else {
                System.out.println("Erro na busca! Insira uma opção válida!");
            }
        }


        System.out.println();



        Equipamento equipamento = new Equipamento(
                1,
                "Computador Dell",
                "Computador desktop para escritório",
                funcionarios.getFirst(),
                new Date(),
                3500.00,
                "Eletrônico"
        );

        System.out.println("=== Equipamento Criado ===");
        System.out.println(equipamento.toString());
        System.out.println();

        while (true) {
            System.out.println("=== Editando Descrição ===");
            System.out.println("Descrição atual: " + equipamento.getDescricao());
            System.out.print("Digite a nova descrição (ou 'sair' para continuar): ");
            String novaDescricao = scanner.nextLine();

            if (novaDescricao.equalsIgnoreCase("sair")) {
                break;
            }

            equipamento.setDescricao(novaDescricao);
            System.out.println("Nova descrição definida: " + equipamento.getDescricao());
            System.out.println();
        }

        System.out.println("=== Marcando como Indisponível ===");
        System.out.print("Deseja marcar o equipamento como indisponível? (s/n): ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            equipamento.setDisponivel(false);
        }
        System.out.println("Disponível: " + (equipamento.isDisponivel() ? "Sim" : "Não"));
        System.out.println();

        System.out.println("=== Exportando para CSV ===");
        String csv = equipamento.toCSV();
        System.out.println("CSV: " + csv);
        System.out.println();

        System.out.println("=== Importando de CSV ===");
        Equipamento equipamentoImportado = Equipamento.fromCSV(csv, funcionarios.getFirst());
        System.out.println(equipamentoImportado.toString());

        scanner.close();
    }
}