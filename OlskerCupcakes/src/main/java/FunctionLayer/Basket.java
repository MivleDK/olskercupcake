package FunctionLayer;

public class Basket {

    private String bottom;
    private String topping;
    private int amount;
    private double totalPrice;
    private String lineId;

    public Basket (String lineId,String bottom, String topping, int amount, double totalPrice) {
        this.lineId = lineId;
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public String getBottom() { return bottom; }

    public void setBottom(String bottom) { this.bottom = bottom; }

    public String getTopping() { return topping; }

    public void setTopping(String topping) { this.topping = topping; }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public String getLineId() { return lineId; }

    public void setLineId(String lineId) { this.lineId = lineId; }
}
