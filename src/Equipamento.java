import java.util.Date;

public class Equipamento {
    private int id;
    private String nome;
    private String descricao;
    private Funcionario funcionario;
    private Date dataAquisicao;
    private double valorAquisicao;
    private String classificacao;
    private boolean disponivel;

    public Equipamento(int id, String nome, String descricao, Funcionario funcionario,
                       Date dataAquisicao, double valorAquisicao, String classificacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.funcionario = funcionario;
        this.dataAquisicao = dataAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.classificacao = classificacao;
        this.disponivel = true; // New equipment is available by default
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public double getValorAquisicao() {
        return valorAquisicao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    private void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    private void setValorAquisicao(double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    private void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public String toString() {
        return "ID do Equipamento: " + id +
                "\nNome: " + nome +
                "\nDescrição: " + descricao +
                "\nFuncionário: " + (funcionario != null ? funcionario.getNome() : "N/A") +
                "\nData de Aquisição: " + dataAquisicao +
                "\nValor de Aquisição: " + valorAquisicao +
                "\nClassificação: " + classificacao +
                "\nDisponível: " + (disponivel ? "Sim" : "Não");
    }

    public String toCSV() {
        return id + "," +
                nome + "," +
                descricao + "," +
                (funcionario != null ? funcionario.getId() : "") + "," +
                dataAquisicao.getTime() + "," +
                valorAquisicao + "," +
                classificacao + "," +
                disponivel;
    }

    public static Equipamento fromCSV(String linha, Funcionario funcionario) {
        String[] partes = linha.split(",");
        int id = Integer.parseInt(partes[0]);
        String nome = partes[1];
        String descricao = partes[2];
        Date dataAquisicao = new Date(Long.parseLong(partes[4]));
        double valorAquisicao = Double.parseDouble(partes[5]);
        String classificacao = partes[6];
        boolean disponivel = Boolean.parseBoolean(partes[7]);

        Equipamento equipamento = new Equipamento(id, nome, descricao, funcionario,
                dataAquisicao, valorAquisicao, classificacao);
        equipamento.setDisponivel(disponivel);
        return equipamento;
    }
}