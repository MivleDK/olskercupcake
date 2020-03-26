package FunctionLayer;

    /**
    * Håndterer previousOrder objekter
    * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
    */
public class PreviousOrders {

    private int ordersId;
    private String ordersDate;
    private String bottom;
    private String topping;
    private int quantity;
    private double sum;

        /**
         *
         * @param ordersId Order ID
         * @param ordersDate Date of created order
         * @param bottom Bottom name
         * @param topping Topping name
         * @param quantity Quantity for orderline
         * @param sum Total sum for orderline
         */
    public PreviousOrders (int ordersId, String ordersDate, String bottom, String topping, int quantity, double sum) {
        this.ordersId = ordersId;
        this.ordersDate = ordersDate;
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
        this.sum = sum;
    }

    public int getOrdersId() { return ordersId; }

    public void setOrdersId(int ordersId) { this.ordersId = ordersId; }

    public String getOrdersDate() { return ordersDate; }

    public void setOrdersDate(String ordersDate) { this.ordersDate = ordersDate; }

    public String getBottom() { return bottom; }

    public void setBottom(String bottom) { this.bottom = bottom; }

    public String getTopping() { return topping; }

    public void setTopping(String topping) { this.topping = topping; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getSum() { return sum; }

    public void setSum(double sum) { this.sum = sum; }
}
