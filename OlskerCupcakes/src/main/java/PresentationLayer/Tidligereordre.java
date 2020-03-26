package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class Tidligereordre extends Command {
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

        // Finder userId fra session
        int userId = (int) session.getAttribute("userId");

        // Henter gamle ordre fra kunde
        List<Orders> orders = LogicFacade.getOldOrders(userId);
        request.setAttribute("orders",orders);

        // Henter gamle ordrelinier fra kunde (status = 'Afsluttet')
        List<PreviousOrders> previousOrders = LogicFacade.getPreviousOrders(userId);
        request.setAttribute("previousOrders", previousOrders);


        return "tidligereordre";
    }
}
