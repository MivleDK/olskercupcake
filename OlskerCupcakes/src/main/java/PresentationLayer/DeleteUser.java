package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class DeleteUser extends Command {
    /**
     *
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return
     * @throws LoginSampleException
     * @throws SQLException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        HttpSession session = request.getSession();
        String email = request.getParameter( "email" );
        LogicFacade.deleteUser( email);
        request.setAttribute("besked", "Brugeren: " + email + " er slettet");
        List<User> allUsers = LogicFacade.viewCustomer();
        session.setAttribute("allusers",allUsers);
        request.setAttribute("kundekartotek", allUsers);
        return "kundekartotek";
    }
}
