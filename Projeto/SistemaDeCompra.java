package Projeto;

enum OrderStatus {
    OPEN,
    APPROVED,
    REJECTED,
    COMPLETED
}

public class SistemaDeCompra {
    public static void main(String[] args) {
        TipoDeUsuário t1 = new TipoDeUsuário();
        t1.setTipoUsuário("funcionario");
        Departamento d1 = new Departamento("Financeiro", 20);
        Departamento d2 = new Departamento("Manutenção", 35);
        Departamento d3 = new Departamento("Engenharia", 70);
        Departamento d4 = new Departamento("Judiciário", 15);
        Departamento d5 = new Departamento("RH", 5);
        Funcionario f1 = new Funcionario(21, "Nicholas", d1, t1);
        Funcionario f2 = new Funcionario(95, "Maria", d2, t1);
        Funcionario f3 = new Funcionario(84, "Joao", d3, t1);
        Funcionario f4 = new Funcionario(83, "Mateus", d4, t1);
        Funcionario f5 = new Funcionario(52, "Joao", d5, t1);
        Funcionario f6 = new Funcionario(34, "Eduardo", d1, t1);
        Funcionario f7 = new Funcionario(53, "Carlos", d2, t1);
        Funcionario f8 = new Funcionario(67, "Ana", d3, t1);
        Funcionario f9 = new Funcionario(39, "Heraclides", d4, t1);
        Funcionario f10 = new Funcionario(1, "Catarina", d5, t1);
        Funcionario f11 = new Funcionario(8, "Sarah", d1, t1);
        Funcionario f12 = new Funcionario(98, "Emma", d2, t1);
        Funcionario f13 = new Funcionario(100, "Alejandro", d3, t1);
        Funcionario f14 = new Funcionario(324, "Douglas", d4, t1);
        Funcionario f15 = new Funcionario(453, "Marinez", d5, t1);
    }
}
