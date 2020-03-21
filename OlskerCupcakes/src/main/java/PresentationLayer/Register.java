package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException, SQLException {
        String email = request.getParameter( "email" );
        int phone = Integer.parseInt(request.getParameter( "phone" ));
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
       if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( email, phone, password1 );
            HttpSession session = request.getSession();

            session.setAttribute("userId", user.getId());
            session.setAttribute("email",email);
            session.setAttribute("phone", phone);
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );

            List<Bottom> allBottoms = LogicFacade.getBottoms();
            List<Topping> allToppings = LogicFacade.getToppings();
            request.setAttribute("bottom", allBottoms);
            request.setAttribute("topping", allToppings);

            return user.getRole() + "page";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}
