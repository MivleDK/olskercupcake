package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCredit extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String credit = request.getParameter("credit");
        LogicFacade.updateCredit(email,credit);
        request.setAttribute("besked", "Brugeren: " + email + " har fået indsat " + credit + " kr. på sin saldo.");
        return "kundekartotek";
    }
}
