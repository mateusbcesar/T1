// Enum para representar o tipo de usuário
enum UserType {
    EMPLOYEE,
    ADMINISTRATOR
}

// Enum para representar o status do pedido
enum OrderStatus {
    OPEN,
    APPROVED,
    REJECTED,
    COMPLETED
}

// Classe principal que contém o método main
public class SistemaDeCompra {
    public static void main(String[] args) {
        Departamento d1 = new Departamento("Financeiro", 20);
        Empregado e1 = new Empregado(21, "Nicholas", d1, UserType.EMPLOYEE);
        Item item1 = new Item(null, 12000.0, 2);


    }
}
