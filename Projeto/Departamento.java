package Projeto;

public class Departamento {
    private String nomeDepartamento;
    private double maxPreco;

    public Departamento(String nomeDepartamento, double maxPreco) {
        this.nomeDepartamento = nomeDepartamento;
        this.maxPreco = maxPreco;
    }

    public double getMaxPreco() {
        return maxPreco;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setMaxPreco(double maxOrderAmount) {
        this.maxPreco = maxOrderAmount;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }
}
