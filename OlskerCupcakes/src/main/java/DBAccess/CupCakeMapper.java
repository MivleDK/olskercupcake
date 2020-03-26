package DBAccess;

import FunctionLayer.Bottom;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * henter Topping og bottoms fra databasen til dropdown menu
 * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
 */

public class CupCakeMapper {
    /**
     *
     * @return List of allBottoms
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    public static List<Bottom> getBottoms() throws SQLException {
        List<Bottom> allBottoms = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM bottom ORDER BY bottom_id";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bottom_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Bottom bottom = new Bottom(id, name, price);
                allBottoms.add(bottom);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException(ex.getMessage());
        }

        return allBottoms;
    }

    /**
     *
     * @return List of allToppings
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    public static List<Topping> getToppings() throws SQLException {
        List<Topping> allToppings = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Topping ORDER BY topping_id";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("topping_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                Topping topping = new Topping(id, name, price);
                allToppings.add(topping);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
        return allToppings;
    }
}
