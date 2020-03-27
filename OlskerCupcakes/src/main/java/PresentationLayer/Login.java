package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

    /**
    * Lader brugere logge ind. Initialiserer desuden kritiske objektlister til både admin og customer roles.
    * Er nødvendig for, at siden efter login, ikke er tom for data.
    * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
    */
public class Login extends Command {

    /**
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return returnerer en side afhængigt af user role (admin/kunde)
     * @throws LoginSampleException Exception for login
     * @throws SQLException Exception for SQL
     */
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException, SQLException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );

        HttpSession session = request.getSession();

        session.setAttribute("userId", user.getId());
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", email);

        List<Bottom> allBottoms = LogicFacade.getBottoms();
        List<Topping> allToppings = LogicFacade.getToppings();
        List<Orders> allOrders = LogicFacade.getAllOrders();
        List<Orderline> allOrderlines = LogicFacade.getOrderlines();
        request.setAttribute("bottom", allBottoms);
        request.setAttribute("topping", allToppings);
        request.setAttribute("allOrders", allOrders);
        request.setAttribute("AllOrderlines", allOrderlines);

        return user.getRole() + "page";
    }
}
