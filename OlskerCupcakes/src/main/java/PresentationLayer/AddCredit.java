package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Tilføj kredit til en kundekonto
 * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
 */

public class AddCredit extends Command {
    /**
     * @param request  Anvendes til get&set operationer på .jsp sider.
     * @param response Anvendes ikke
     * @return kundekartoteksside
     * @throws LoginSampleException
     * @throws SQLException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String credit = request.getParameter("credit");

        LogicFacade.updateCredit(email, credit);
        request.setAttribute("besked", "Brugeren: " + email + " har fået indsat " + credit + " kr. på sin saldo.");
        List<User> allUsers = LogicFacade.viewCustomer();
        session.setAttribute("allusers", allUsers);
        request.setAttribute("kundekartotek", allUsers);
        return "kundekartotek";
    }
}