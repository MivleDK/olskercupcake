package FunctionLayer;

public class PreviousOrders {

    private int ordersId;
    private String ordersDate;
    private String bottom;
    private String topping;
    private int quantity;
    private double sum;

    public PreviousOrders (int ordersId, String ordersDate, String bottom, String topping, int quantity, double sum) {
        this.ordersId = ordersId;
        this.ordersDate = ordersDate;
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
        this.sum = sum;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public String getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(String ordersDate) {
        this.ordersDate = ordersDate;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
