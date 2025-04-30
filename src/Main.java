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

        // TESTE DE ESTADOS DE MANUTENÇÃO
        System.out.println("\n=== Teste de Manutenção ===");
        Manutencao manutencao = new Manutencao();
        manutencao.setEquipamento(equipamento);
        manutencao.setFuncionario(funcionario);
        manutencao.setDataPedido(new Date());
        manutencao.setDescricao("Problema na inicialização");

        System.out.println("Estado inicial: " + manutencao.getEstado());

        while (true) {
            System.out.println("Digite o novo estado (SOLICITADA, EM_ANDAMENTO, CONCLUIDA) ou 'fim' para encerrar:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("fim")) break;

            try {
                Manutencao.EstadoManutencao novoEstado = Manutencao.EstadoManutencao.valueOf(input.toUpperCase());
                boolean alterado = manutencao.setEstado(novoEstado);
                if (alterado) {
                    System.out.println("Estado alterado para: " + manutencao.getEstado());
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Estado inválido. Tente novamente.");
            }
        }

        scanner.close();
    }
}
