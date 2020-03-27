package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Orderline;
import FunctionLayer.Orders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

    /**
    * Opdaterer status på en ordre
    * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
    */
public class UpdateOrderStatus extends Command {

    /**
     *
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return adminpage
     * @throws LoginSampleException Exception for login
     * @throws SQLException Exception for SQL
     * @throws ParseException Exception for error while parsing
     * @throws ClassNotFoundException Exception when specified class cannot be found in the classpath
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ParseException, ClassNotFoundException {

        HttpSession session = request.getSession();

        String orderID = request.getParameter("opdaterOrdreID");
        String orderStatus = request.getParameter("ordrestatus");

        LogicFacade.updateStatus(Integer.parseInt(orderID), orderStatus);

        List<Orders> allOrders = LogicFacade.getAllOrders();
        List<Orderline> allOrderlines = LogicFacade.getOrderlines();
        request.setAttribute("allOrders", allOrders);
        request.setAttribute("AllOrderlines", allOrderlines);

        return "adminpage";
    }
}
