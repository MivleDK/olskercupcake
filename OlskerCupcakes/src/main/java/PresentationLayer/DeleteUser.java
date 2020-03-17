package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUser extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter( "email" );
        User user = LogicFacade.deleteUser( email);
        request.setAttribute("besked", "Brugeren: " + email + " er slettet");
        return "kundekartotek";
    }
}
