import java.util.ArrayList;
import java.util.Date;

public class Manutencao {
    public enum EstadoManutencao {
        SOLICITADA,
        EM_ANDAMENTO,
        CONCLUIDA
    }

    public static ArrayList<Manutencao> equipManu = new ArrayList<> ();
    private Equipamento equipamento;
    private Date dataPedido;
    private String descricao;
    private Funcionario funcionario;
    private Date dataEntrada;
    private Date dataSaida;
    private String solucao;
    private EstadoManutencao estado;

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
        equipManu.add(this);
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public EstadoManutencao getEstado() {
        return estado;
    }

    public boolean setEstado(EstadoManutencao novoEstado) {
        if (this.estado == null || novoEstado.ordinal() >= this.estado.ordinal()) {
            this.estado = novoEstado;
            return true;
        } else {
            System.out.println("Não é permitido retroceder o estado de manutenção.");
            return false;
        }
    }
}
