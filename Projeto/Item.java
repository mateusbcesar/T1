package Projeto;

public class Item {
    private String descricao;
    private double preco;
    private int quantidade;

    public Item(String descricao, double preco, int quantidade) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getPreco(){
        return this.preco;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public double getPrecoTotal(){
        return this.preco * this.quantidade;
    }
}
