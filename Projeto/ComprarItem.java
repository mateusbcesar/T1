package Projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComprarItem{


    private Funcionario funcionario;
    private Departamento departamentoFuncionario;
    private Date dia;
    private Date diaFinal;
    private OrderStatus status;
    private ArrayList<Item> items;

    public ComprarItem(Funcionario funcionario, Departamento departamentoFuncionario, Date dia) {
        this.funcionario = funcionario;
        this.departamentoFuncionario = departamentoFuncionario;
        this.dia = dia;
        this.status = OrderStatus.OPEN;
        this.items = new ArrayList<>();
    }

    // Métodos getters e setters

    // Método para adicionar um item ao pedido
    public void addItem(Item item) {
        items.add(item);
    }
}
