package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException, SQLException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );

        HttpSession session = request.getSession();

        session.setAttribute("userId", user.getId());
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke

        List<Bottom> allBottoms = LogicFacade.getBottoms();
        List<Topping> allToppings = LogicFacade.getToppings();
        List<Orders> allOrders = LogicFacade.getAllOrders();
        request.setAttribute("bottom", allBottoms);
        request.setAttribute("topping", allToppings);
        request.setAttribute("allOrders", allOrders);

        return user.getRole() + "page";
    }

}
