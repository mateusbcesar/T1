package Projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComprarItem{


    private Funcionario funcionario;
    private Departamento departamentoFuncionario;
    private String dia;
    private String diaFinal;
    private OrderStatus status;
    private ArrayList<Item> items;

    public ComprarItem(Funcionario funcionario, Departamento departamentoFuncionario,
    String dia) {
        this.funcionario = funcionario;
        this.departamentoFuncionario = departamentoFuncionario;
        this.dia = dia;
        this.diaFinal = diaFinal;
        this.status = OrderStatus.OPEN;
        this.items = new ArrayList<>();
    }

    // Métodos getters e setters

    // Método para adicionar um item ao pedido
    public void addItem(Item item) {

        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valorItem = preco*quantidade;

        if(valorItem<=maxOrderAmount){
        items.add(item);}
        }
    public void administradorAvaliador() {
        
    }
