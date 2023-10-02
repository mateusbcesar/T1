import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
