package Projeto;

import java.util.ArrayList;
import java.util.List;

public class ComprarItem{


    private Funcionario funcionario;
    private Departamento departamentoFuncionario;
    private String dia;
    private String diaFinal;
    private OrderStatus status;
    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public ComprarItem(Funcionario funcionario, String dia) {
        this.funcionario = funcionario;
        this.departamentoFuncionario = funcionario.getDepartamento();
        this.dia = dia;
        this.status = OrderStatus.OPEN;
        this.items = new ArrayList<>();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setDiaFinal(String diaFinal) {
        this.diaFinal = diaFinal;
    }

    public void getPrecoTotalPedido(){
        double valorTotal = 0;
        for (Item item : items) {
            valorTotal += item.getPreco();
        }
        if(valorTotal<=departamentoFuncionario.getMaxPreco()){
            System.out.println("Valor total do pedido: " + valorTotal);
        }else
            System.out.println("Valor total do pedido: " + valorTotal + " - Pedido excedeu o valor máximo permitido");
    }

    public void mostrarPedidos(){
        for(Item item: items){
            System.out.println("Item: " + item.getDescricao() + " - Preço: " + item.getPreco() + " - Quantidade: " + item.getQuantidade());
        }
    }

    public String toString() {
        return "Funcionário: " + funcionario.getNomeUsuario() + " - Departamento: " + departamentoFuncionario.getNomeDepartamento() + " - Dia: " + dia + " - Dia final: " + diaFinal + " - Status: " + status;
    }

    public void mostrarItens() {
        System.out.println("Itens do Pedido:");
        for (Item item : items) {
            System.out.println("Descrição: " + item.getDescricao() +
                    " | Valor Unitário: " + item.getPreco() +
                    " | Quantidade: " + item.getQuantidade() +
                    " | Total do Item: " + item.getPrecoTotal());
        }
    }

    public Funcionario getFuncionario(){
        return funcionario;
    }

    public String getDia(){
        return dia;
    }

    public void listarPedidosEntreDatas(List<ComprarItem> pedidos, String dataInicio, String dataFim) {
        System.out.println("Pedidos entre " + dataInicio + " e " + dataFim + ":");
        for (ComprarItem pedido : pedidos) {
            if (pedido.getDia().compareTo(dataInicio) >= 0 && pedido.getDia().compareTo(dataFim) <= 0) {
                System.out.println(pedido);
            }
        }
    }

    public void buscarPedidosPorFuncionario(List<ComprarItem> pedidos, Funcionario funcionario) {
        System.out.println("Pedidos de " + funcionario.getNomeUsuario() + ":");
        for (ComprarItem pedido : pedidos) {
            if (pedido.getFuncionario().equals(funcionario)) {
                System.out.println(pedido);
            }
        }
    }

    public void buscarPedidosPorDescricaoItem(List<ComprarItem> pedidos, String descricaoItem) {
        System.out.println("Pedidos contendo o item '" + descricaoItem + "':");
        for (ComprarItem pedido : pedidos) {
            for (Item item : pedido.getItems()) {
                if (item.getDescricao().equalsIgnoreCase(descricaoItem)) {
                    System.out.println(pedido);
                    break;
                }
            }
        }
    }

    public boolean podeSerModificado() {
        return status == OrderStatus.OPEN;
    }

    public void excluirPedido(Funcionario funcionarioQueExclui) {
        if (status == OrderStatus.OPEN && funcionarioQueExclui.equals(funcionario)) {
            System.out.println("Pedido excluído com sucesso.");
        } else {
            System.out.println("Não é possível excluir o pedido. Verifique o status ou o usuário.");
        }
    }
}
