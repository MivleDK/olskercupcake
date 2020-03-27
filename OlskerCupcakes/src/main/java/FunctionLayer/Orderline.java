package FunctionLayer;

    /**
    * Hånterer ordrelinjeobjekter
    * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
    */
public class Orderline {

    private int orderlineId;
    private int ordersId;
    private int quantity;
    private double sum;
    private String topping;
    private String bottom;

        /**
         *
         * @param orderlineId Orderline ID
         * @param ordersId Order ID
         * @param quantity Quantity of cupcake for orderline
         * @param sum Total sum for orderline
         * @param topping Topping name
         * @param bottom Bottom name
         */
    public Orderline (int orderlineId, int ordersId, int quantity, double sum, String topping, String bottom) {
        this.orderlineId = orderlineId;
        this.ordersId = ordersId;
        this.quantity = quantity;
        this.sum = sum;
        this.topping = topping;
        this.bottom = bottom;
    }

        /**
         *
         * @param ordersId Order ID
         * @param bottom Bottom name
         * @param topping Topping name
         * @param quantity Quantity of cupcake for orderline
         * @param sum Total sum for orderline
         */
    public Orderline (int ordersId, String bottom, String topping, int quantity, double sum){
        this.ordersId = ordersId;
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
        this.sum = sum;
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
