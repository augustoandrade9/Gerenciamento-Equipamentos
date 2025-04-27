public class Funcionario {
    private int id;
    private String nome;
    private String email;

    //Entidade Funcionário
    public Funcionario(int id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    
    //Pedir o ID de um funcionário
    public int getId(){
        return id;
    }

    //Pedir/Mudar o Nome de um funcionário
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    //Pedir/Mudar o email de um Funcionário
    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    //Criar um novo Funcionário
    @override
    public String toString() {
        return "ID do Funcionario: " + id + "\nNome do Funcionario: " + nome + "\n Email do Funcionario: " + email;
    }

    //Transformar em arquivo txt
    public String toCSV() {
        return id + "," + nome + "," + email;
    }

    //Pegar as informações do arquivo txt
    public static Funcionario fromCSV (String linha){
        String[] partes = linha.split(",");
        return new Funcionario(Integer.parseInt(partes[0], partes[1], partes[2]));
    }
}
