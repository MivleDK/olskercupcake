package FunctionLayer;

public class Orderline {

    private int orderlineId;
    private int ordersId;
    private int quantity;
    private double sum;
    private String topping;
    private String bottom;

    public Orderline (int orderlineId, int ordersId, int quantity, double sum, String topping, String bottom) {
        this.orderlineId = orderlineId;
        this.ordersId = ordersId;
        this.quantity = quantity;
        this.sum = sum;
        this.topping = topping;
        this.bottom = bottom;
    }

    public int getOrderlineId() { return orderlineId; }

    public void setOrderlineId(int orderlineId) { this.orderlineId = orderlineId; }

    public int getOrdersId() { return ordersId; }

    public void setOrdersId(int ordersId) { this.ordersId = ordersId; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getSum() { return sum; }

    public void setSum(double sum) { this.sum = sum; }

    public String getTopping() { return topping; }

    public void setToppingId(String topping) { this.topping = topping; }

    public String getBottom() { return bottom; }

    public void setBottomId(String bottom) { this.bottom = bottom; }
}
