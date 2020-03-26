package FunctionLayer;

/**
 * håndterer user objekter
 * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
 */
public class User {

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private int phone;
    private double credit;
    private String password; // Should be hashed and secured
    private String role;

    /**
     * delete user
     * @param email User email
     */
    public User(String email) {
        this.email = email;
    }

    /**
     * Login
     * @param email User email
     * @param password User password
     * @param role User role
     */
    public User(String email, String password, String role ) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * Create user
     * @param email User email
     * @param phone User phone number
     * @param password User password
     * @param role User role
     */
    public User(String email, int phone, String password, String role ) {
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    /**
     * View customerList
     * @param id User ID
     * @param email User email
     * @param phone User phone number
     * @param credit User credit
     */
    public User(int id, String email, int phone, double credit ) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.credit = credit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public void setPhone(int phone) { this.phone = phone; }

    public int getPhone() { return phone; }

    public double getCredit() { return credit; }

    public void setCredit(double credit) { this.credit = credit; }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

}
