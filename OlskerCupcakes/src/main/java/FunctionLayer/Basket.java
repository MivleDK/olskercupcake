package FunctionLayer;

public class Basket {

    private Bottom bottom;
    private Topping topping;
    private int amount;
    private double totalPrice;

    public Basket (Bottom bottom, Topping topping, int amount, double totalPrice) {
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
        this.totalPrice = getTotalPrice(bottom, topping, amount);
    }

    public Bottom getBottom() { return bottom; }

    public void setBottom(Bottom bottom) { this.bottom = bottom; }

    public Topping getTopping() { return topping; }

    public void setTopping(Topping topping) { this.topping = topping; }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }

    public double getTotalPrice(Bottom b, Topping t, int amount) {

        double bPrice = b.getPrice();
        double tPrice = t.getPrice();

        double totPrice = (bPrice + tPrice)*amount;

        return totPrice;
    }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
