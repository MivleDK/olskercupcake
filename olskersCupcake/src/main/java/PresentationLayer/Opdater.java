package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Opdater extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        int phone = Integer.parseInt(request.getParameter( "phone" ));
        User user = LogicFacade.Opdater( password, email, phone );
        HttpSession session = request.getSession();
        return "adminpage";
    }
}
