package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Nulstil extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter( "email" );
        User user = LogicFacade.Nulstil( email );
        HttpSession session = request.getSession();
        return "adminpage";
    }
}