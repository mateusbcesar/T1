import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

// Classe para representar um usuário
class User {
    private int userId;
    private String userName;
    private UserType userType;

    public User(int userId, String userName, UserType userType) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
    }

    // Métodos getters e setters
}

// Classe para representar um departamento
class Department {
    private String departmentName;
    private double maxOrderAmount;

    public Department(String departmentName, double maxOrderAmount) {
        this.departmentName = departmentName;
        this.maxOrderAmount = maxOrderAmount;
    }

    // Métodos getters
}

// Classe para representar um funcionário
class Employee extends User {
    private Department department;

    public Employee(int userId, String userName, Department department) {
        super(userId, userName, UserType.EMPLOYEE);
        this.department = department;
    }

    // Métodos getters
}

// Classe para representar um pedido de aquisição
class PurchaseOrder {
    private Employee requester;
    private Department requestingDepartment;
    private Date orderDate;
    private Date completionDate;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;

    public PurchaseOrder(Employee requester, Department requestingDepartment, Date orderDate) {
        this.requester = requester;
        this.requestingDepartment = requestingDepartment;
        this.orderDate = orderDate;
        this.orderStatus = OrderStatus.OPEN;
        this.orderItems = new ArrayList<>();
    }

    // Métodos getters e setters

    // Método para adicionar um item ao pedido
    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    // Outros métodos relevantes
}

// Classe para representar um item do pedido
class OrderItem {
    private String description;
    private double unitPrice;
    private int quantity;

    public OrderItem(String description, double unitPrice, int quantity) {
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // Métodos getters
}

// Classe principal que contém o método main
public class PurchaseOrderSystem {
    public static void main(String[] args) {
        // Aqui você pode começar a criar instâncias de usuários, departamentos e pedidos para testar o sistema.
    }
}
