package Projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComprarItem{


    private Empregado empregado;
    private Departamento departamentoEmpregado;
    private Date dia;
    private Date diaFinal;
    private OrderStatus status;
    private ArrayList<Item> items;

    public ComprarItem(Empregado empregado, Departamento departamentoEmpregado, Date dia) {
        this.empregado = empregado;
        this.departamentoEmpregado = departamentoEmpregado;
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