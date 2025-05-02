import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Funcionario funcionario = new Funcionario(1, "João Silva", "joao.silva@empresa.com");

        System.out.println("=== Funcionário Criado ===");
        System.out.println(funcionario.toString());
        System.out.println();

        Equipamento equipamento = new Equipamento(
                1,
                "Computador Dell",
                "Computador desktop para escritório",
                funcionario,
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
        Equipamento equipamentoImportado = Equipamento.fromCSV(csv, funcionario);
        System.out.println(equipamentoImportado.toString());


        //Eu tinha criado essa parte a partir da main atual ai tinha usado coisas que tinha la ja
        // quando juntar é pra funcionar mesmo que esteja apontando erro agora
        System.out.println("=== Gerando Relatorio ===");
        System.out.println("Deseja gerar relatorio? s/n");
        String rel = scanner.next();
        if(rel=="s"){
            Equipamento temp = equipamento;
            System.out.println("\nRelatorio de equipamento:");
            System.out.println("Nome: "+temp.getNome());
            System.out.println("Nome funcionario responsavel: "+temp.getFuncionario().getNome());
            int manut=0;
            String estado = "EM_ANDAMENTO";
            Manutencao.EstadoManutencao estadoManut = Manutencao.EstadoManutencao.valueOf(estado.toUpperCase());
            if(manutencao.getEquipamento().getNome()==temp.getNome() && manutencao.getEstado()==estadoManut) {
                manut++;
                System.out.println("Há uma manutenção em andamento nesse equipamento");
            }
            System.out.println("Quantidade de manutenções: " +manut);
        }else{
            System.out.println("Relatorio não será gerado");
        }

        scanner.close();
    }
}