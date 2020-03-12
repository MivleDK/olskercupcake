package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Tilfoej extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        String role = request.getParameter( "role" );
        int phone = Integer.parseInt(request.getParameter( "phone" ));

        User user = LogicFacade.createUser( email, password,role, phone );
        HttpSession session = request.getSession();

        session.setAttribute("email",email);
        session.setAttribute( "user", user );
        session.setAttribute( "role", role );
        session.setAttribute( "phone", phone );
        return "adminpage";
    }
}
