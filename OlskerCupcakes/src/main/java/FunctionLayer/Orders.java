package FunctionLayer;

public class Orders {

    private int ordersId;
    private int userId;
    private String ordersDate;
    private String status;

    public Orders (int ordersId, int userId, String ordersDate, String status) {
        this.ordersId = ordersId;
        this.userId = userId;
        this.ordersDate = ordersDate;
        this.status = status;
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
