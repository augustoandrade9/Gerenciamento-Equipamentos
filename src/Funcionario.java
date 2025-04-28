import java.util.List;

public class Funcionario {
    private int id;
    private String nome;
    private String email;

    public Funcionario(int id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    
    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID do Funcionario: " + id + "\nNome do Funcionario: " + nome + "\n Email do Funcionario: " + email;
    }

    public String toCSV() {
        return id + "," + nome + "," + email;
    }

    public static Funcionario fromCSV (String linha){
        String[] partes = linha.split(",");
        return new Funcionario(Integer.parseInt(partes[0]), partes[1], partes[2]);
    }

    public static void listarFuncionarios(List<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado.");
        } else {
            System.out.println("\n=== Lista de Funcionários ===\n");
            for (Funcionario f : funcionarios) {
                System.out.println("----------------------------");
                System.out.println(f);
                System.out.println("----------------------------\n");
            }
        }
    }
}
