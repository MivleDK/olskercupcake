package FunctionLayer;

public class Basket {

    private int bottomId;
    private int toppingId;
    private String bottom;
    private String topping;
    private int amount;
    private double totalPrice;
    private String lineId;

    public Basket (String lineId,int bottomId,int toppingId,String bottom, String topping, int amount, double totalPrice) {
        this.lineId = lineId;
        this.bottomId = bottomId;
        this.toppingId = toppingId;
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public int getBottomId() { return bottomId; }

    public void setBottomId(int bottomId) { this.bottomId = bottomId; }

    public int getToppingId() { return toppingId; }

    public void setToppingId(int toppingId) { this.toppingId = toppingId; }

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
