import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe para representar um funcionário
class Employee extends User {
    private Department department;

    public Employee(int userId, String userName, Department department) {
        super(userId, userName, UserType.EMPLOYEE);
        this.department = department;
    }

}
