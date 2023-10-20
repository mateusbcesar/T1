package Projeto;

import java.util.List;
import java.util.Scanner;

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
        TipoDeUsuário t2 = new TipoDeUsuário();
        t2.setTipoUsuário("administrador");
        Departamento d1 = new Departamento("Financeiro", 20);
        Departamento d2 = new Departamento("Manutenção", 35);
        Departamento d3 = new Departamento("Engenharia", 70);
        Departamento d4 = new Departamento("Judiciário", 15);
        Departamento d5 = new Departamento("RH", 5);
        Funcionario f1 = new Funcionario(21, "Nicholas", d1, t2);
        Funcionario f2 = new Funcionario(95, "Maria", d2, t1);
        Funcionario f3 = new Funcionario(84, "Joao", d3, t1);
        Funcionario f4 = new Funcionario(83, "Mateus", d4, t1);
        Funcionario f5 = new Funcionario(52, "Joao", d5, t1);
        Funcionario f6 = new Funcionario(34, "Eduardo", d1, t1);
        Funcionario f7 = new Funcionario(53, "Carlos", d2, t1);
        Funcionario f8 = new Funcionario(67, "Ana", d3, t1);
        Funcionario f9 = new Funcionario(39, "Michael", d4, t1);
        Funcionario f10 = new Funcionario(1, "Catarina", d5, t1);
        Funcionario f11 = new Funcionario(8, "Sarah", d1, t1);
        Funcionario f12 = new Funcionario(98, "Emma", d2, t1);
        Funcionario f13 = new Funcionario(100, "Lucas", d3, t1);
        Funcionario f14 = new Funcionario(324, "Douglas", d4, t1);
        Funcionario f15 = new Funcionario(453, "Ana", d5, t2);
        Item i1 = new Item("Caneta", 1.50, 1);
        Item i2 = new Item("Lapis", 0.50, 1);
        Item i3 = new Item("Borracha", 0.75, 1);
        Item i4 = new Item("Caderno", 5.00, 1);
        Item i5 = new Item("Mochila", 10.00, 1);
        ComprarItem compra1 = criarNovoPedido(f1, "01/01/2021");
        compra1.addItem(i5);
        compra1.addItem(i4);
        compra1.mostrarPedidos();
        compra1.getPrecoTotalPedido();
        System.out.println(compra1);

        ComprarItem compra = criarNovoPedido(f15, "01/01/2021");
        compra.addItem(i1);
        compra.addItem(i1);
        compra.addItem(i2);
        compra.mostrarItens();
        compra.getPrecoTotalPedido();
        System.out.println(compra);

        avaliarPedido(compra, OrderStatus.APPROVED);
        avaliarPedido(compra1, OrderStatus.APPROVED);
        exibirEstatisticasGerais(List.of(compra1, compra));

        compra.buscarPedidosPorFuncionario(List.of(compra, compra1), f15);
        compra.listarPedidosEntreDatas(List.of(compra, compra1), "01/01/2021", "05/01/2021");
    }

    private static ComprarItem criarNovoPedido(Funcionario funcionario, String dia){
        ComprarItem novopedido = new ComprarItem(funcionario, dia);
        novopedido.setDiaFinal("05/01/2021");
        novopedido.setStatus(OrderStatus.OPEN);
        return novopedido;
    }

    private static void avaliarPedido(ComprarItem pedido, OrderStatus novoStatus) {
        if (novoStatus == OrderStatus.APPROVED || novoStatus == OrderStatus.REJECTED) {
            if (pedido.getFuncionario().getTipoUsuario().getTipoDeUsuário().equalsIgnoreCase("administrador")) {
                System.out.println("Detalhes do Pedido:");
                System.out.println(pedido);
                if (pedido.podeSerModificado()) {
                    System.out.println("Deseja aprovar (A) ou rejeitar (R) o pedido?");
                    
                    Scanner scanner = new Scanner(System.in);
                    String escolha = scanner.nextLine().toUpperCase();
    
                    switch (escolha) {
                        case "A":
                            pedido.setStatus(OrderStatus.APPROVED);
                            System.out.println("Pedido aprovado com sucesso!");
                            break;
                        case "R":
                            pedido.setStatus(OrderStatus.REJECTED);
                            System.out.println("Pedido rejeitado.");
                            break;
                        default:
                            System.out.println("Escolha inválida. O pedido permanece inalterado.");
                    }
                } else {
                    System.out.println("Não é possível modificar um pedido já aprovado, rejeitado ou concluído.");
                }
    
            } else {
                System.out.println("Apenas administradores podem avaliar pedidos.");
            }
        } else {
            System.out.println("Status de pedido inválido.");
        }
    }

    private static void exibirEstatisticasGerais(List<ComprarItem> pedidos) {
    int totalPedidos = pedidos.size();
    long pedidosAprovados = pedidos.stream().filter(p -> p.getStatus() == OrderStatus.APPROVED).count();
    long pedidosReprovados = pedidos.stream().filter(p -> p.getStatus() == OrderStatus.REJECTED).count();

    System.out.println("Estatísticas Gerais:");
    System.out.println("Número total de pedidos: " + totalPedidos);
    System.out.println("Pedidos aprovados: " + pedidosAprovados + " (" + ((double) pedidosAprovados / totalPedidos) * 100 + "%)");
    System.out.println("Pedidos reprovados: " + pedidosReprovados + " (" + ((double) pedidosReprovados / totalPedidos) * 100 + "%)");
    }
}
