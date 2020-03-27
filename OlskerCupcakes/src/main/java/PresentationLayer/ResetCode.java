package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

import static Util.UserHelper.randomCode;

    /**
    * Nulstiller password for en bruger til et RNG
    * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
    */
public class ResetCode extends Command {

    /**
     *
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return kundekartotek
     * @throws LoginSampleException Exception for login
     * @throws SQLException Exception for SQL
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        HttpSession session = request.getSession();
        String id = request.getParameter( "id" );
        String email = request.getParameter("email");
        String newCode = randomCode(8);
        LogicFacade.resetCode( Integer.parseInt(id) , newCode);
        request.setAttribute("besked", "Brugeren: " + email + " har fået ændret sin code til " + newCode );
        List<User> allUsers = LogicFacade.viewCustomer();
        session.setAttribute("allusers",allUsers);
        request.setAttribute("kundekartotek", allUsers);
        return "kundekartotek";
    }
}
