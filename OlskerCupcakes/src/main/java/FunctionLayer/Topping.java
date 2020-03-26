package FunctionLayer;
/**
 * håndtere topping objekt
 * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
 */
public class Topping {

    private int id;
    private String name;
    private double price;

    /**
     *
     * @param id
     * @param name
     * @param price
     */
    public Topping(int id, String name, double price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
