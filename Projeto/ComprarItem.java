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

    public ComprarItem(Funcionario funcionario, String dia) {
        this.funcionario = funcionario;
        this.departamentoFuncionario = funcionario.getDepartamento();
        this.dia = dia;
        this.status = OrderStatus.OPEN;
        this.items = new ArrayList<>();
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
}
