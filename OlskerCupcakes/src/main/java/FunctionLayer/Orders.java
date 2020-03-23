package FunctionLayer;

public class Orders {

    private int ordersId;
    private int userId;
    private String ordersDate;
    private String status;
    private String email;
    private int quantity;
    private double total;

    public Orders (int ordersId, int userId, String ordersDate, String status) {
        this.ordersId = ordersId;
        this.userId = userId;
        this.ordersDate = ordersDate;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Orders(int ordersId, String ordersDate, String status, String email, int quantity, double total){
        this.ordersId = ordersId;
        this.userId = userId;
        this.ordersDate = ordersDate;
        this.status = status;
        this.email = email;
        this.quantity = quantity;
        this.total = total;
    }

    public int getOrdersId() { return ordersId; }

    public void setOrdersId(int ordersId) { this.ordersId = ordersId; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public String getOrdersDate() { return ordersDate; }

    public void setOrdersDate(String ordersDate) { this.ordersDate = ordersDate; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
