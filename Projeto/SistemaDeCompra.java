package Projeto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;


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
        Funcionario f9 = new Funcionario(39, "Michael", d4, t1);
        Funcionario f10 = new Funcionario(1, "Catarina", d5, t1);
        Funcionario f11 = new Funcionario(8, "Sarah", d1, t1);
        Funcionario f12 = new Funcionario(98, "Emma", d2, t1);
        Funcionario f13 = new Funcionario(100, "Lucas", d3, t1);
        Funcionario f14 = new Funcionario(324, "Douglas", d4, t1);
        Funcionario f15 = new Funcionario(453, "Ana", d5, t1);
        Item i1 = new Item("Caneta", 1.50, 1);
        Item i2 = new Item("Lapis", 0.50, 1);
        Item i3 = new Item("Borracha", 0.75, 1);
        Item i4 = new Item("Caderno", 5.00, 1);
        Item i5 = new Item("Mochila", 10.00, 1);
        ComprarItem compra1 = new ComprarItem(f1, "01/01/2021");
        compra1.addItem(i5);
        compra1.addItem(i4);
        compra1.mostrarPedidos();
        compra1.getPrecoTotalPedido();
        System.out.println(compra1);

        List<PedidoDeAquisicao> listaPedidos;

        ComprarItem compra = criarNovoPedido(f15, "01/01/2021");
        compra.addItem(i1);
        compra.addItem(i1);
        compra.addItem(i2);
        compra.mostrarItens();
        compra.getPrecoTotalPedido();
        System.out.println(compra);
    }

    public SistemaDeCompra() {
        // Inicialize a lista de pedidos no construtor
        listaPedidos = new ArrayList<>();
        }

    private static ComprarItem criarNovoPedido(Funcionario funcionario, String dia){
        ComprarItem novopedido = new ComprarItem(funcionario, dia);
        novopedido.setDiaFinal("05/01/2021");
        novopedido.setStatus(OrderStatus.OPEN);
        return novopedido;
    }

    public List<PedidoDeAquisicao> getPedidos() {
        return listaPedidos;
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

        // Método para calcular as estatísticas gerais
    public void calcularEstatisticasGerais() {
        List<PedidoDeAquisicao> pedidos = getPedidos(); // Suponha que você tenha um método getPedidos() que retorna todos os pedidos.
         }

    // Converter as Strings de data em LocalDate (assumindo que a data está no formato "dd/MM/yyyy")
        LocalDate hoje = LocalDate.now();
        LocalDate dataLimite = hoje.minusDays(30);

    private static void exibirEstatisticasGerais(List<ComprarItem> pedidos) {
        int totalPedidos = pedidos.size();
        long pedidosAprovados = pedidos.stream().filter(p -> p.getStatus() == OrderStatus.APPROVED).count();
        long pedidosReprovados = pedidos.stream().filter(p -> p.getStatus() == OrderStatus.REJECTED).count();

    System.out.println("Estatísticas Gerais:");
    System.out.println("Número total de pedidos: " + totalPedidos);
    System.out.println("Pedidos aprovados: " + pedidosAprovados + " (" + ((double) pedidosAprovados / totalPedidos) * 100 + "%)");
    System.out.println("Pedidos reprovados: " + pedidosReprovados + " (" + ((double) pedidosReprovados / totalPedidos) * 100 + "%)");

    // 8.2 Número de pedidos nos últimos 30 dias e seu valor médio.
        LocalDate hoje = LocalDate.now();
        LocalDate dataLimite = hoje.minus(30, ChronoUnit.DAYS);

        List<PedidoDeAquisicao> pedidosUltimos30Dias = pedidos.stream()
                .filter(pedido -> {
                    try {
                        LocalDate dataPedido = LocalDate.parse(pedido.getDataPedido(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        return dataPedido.isAfter(dataLimite);
                    } catch (Exception e) {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        double valorMedioPedidosUltimos30Dias = pedidosUltimos30Dias.stream()
                .mapToDouble(PedidoDeAquisicao::getValorTotal)
                .average()
                .orElse(0.0);

        System.out.println("Número de pedidos nos últimos 30 dias: " + pedidosUltimos30Dias.size());
        System.out.println("Valor médio dos pedidos nos últimos 30 dias: " + valorMedioPedidosUltimos30Dias);

    // 8.3 Valor total de cada categoria nos últimos 30 dias.
    for (Departamento departamento : departamentos) {
        double valorTotalCategoria = pedidosUltimos30Dias.stream()
                .filter(pedido -> pedido.getDepartamentoSolicitante().equals(departamento))
                .mapToDouble(PedidoDeAquisicao::getValorTotal)
                .sum();
        System.out.println("Categoria: " + departamento.getNome() + " - Valor Total: " + valorTotalCategoria);
    }

   // 8.4 Detalhes do pedido de aquisição de maior valor ainda aberto.
        PedidoDeAquisicao pedidoMaiorValorAberto = pedidos.stream()
                .filter(pedido -> pedido.getStatus() == StatusPedido.ABERTO)
                .max(Comparator.comparingDouble(PedidoDeAquisicao::getValorTotal))
                .orElse(null);

        if (pedidoMaiorValorAberto != null) {
            System.out.println("Detalhes do Pedido de Maior Valor Aberto:");
            System.out.println("Número do Pedido: " + pedidoMaiorValorAberto.getNumeroPedido());
            // Adicione outros detalhes aqui conforme necessário.
        }
    }
}
