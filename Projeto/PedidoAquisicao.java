import java.util.List;

public class PedidoDeAquisicao {
    private int numeroPedido;
    private Funcionario funcionarioSolicitante;
    private Departamento departamentoSolicitante;
    private String dataPedido;
    private OrderStatus status;
    private List<Item> itensAquisicao;

    public PedidoDeAquisicao(int numeroPedido, Funcionario funcionarioSolicitante, Departamento departamentoSolicitante, String dataPedido, OrderStatus status, List<Item> itensAquisicao) {
        this.numeroPedido = numeroPedido;
        this.funcionarioSolicitante = funcionarioSolicitante;
        this.departamentoSolicitante = departamentoSolicitante;
        this.dataPedido = dataPedido;
        this.status = status;
        this.itensAquisicao = itensAquisicao;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public Funcionario getFuncionarioSolicitante() {
        return funcionarioSolicitante;
    }

    public Departamento getDepartamentoSolicitante() {
        return departamentoSolicitante;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<Item> getItensAquisicao() {
        return itensAquisicao;
    }

    public double getValorTotal() {
        double total = 0.0;
        for (Item item : itensAquisicao) {
            total += item.getValorTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "PedidoDeAquisicao{" +
                "numeroPedido=" + numeroPedido +
                ", funcionarioSolicitante=" + funcionarioSolicitante +
                ", departamentoSolicitante=" + departamentoSolicitante +
                ", dataPedido='" + dataPedido + '\'' +
                ", status=" + status +
                ", itensAquisicao=" + itensAquisicao +
                '}';
    }
}
