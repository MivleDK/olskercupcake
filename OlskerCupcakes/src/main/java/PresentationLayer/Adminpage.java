package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

    /**
    * Adminpage
    * Oversigt over alle ordrer, opdater ordre, vis ordre og status samt slette ordre
    * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
    */
public class Adminpage extends Command {

    /**
     *
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return adminpage
     * @throws SQLException Exception for SQL
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        HttpSession session = request.getSession();

        /*
        HENT ORDRER
        */
        List<Orders> allOrders = (List<Orders>) session.getAttribute("allOrders");

        if (allOrders == null) {
            allOrders = LogicFacade.getAllOrders();
        } else {
            allOrders = (List<Orders>) session.getAttribute("allOrders");
        }

        request.setAttribute("allOrders", allOrders);

        /*
        HENT ORDRERLINKER
        */
        List<Orderline> allOrderlines = (List<Orderline>) session.getAttribute("AllOrderlines");

        if (allOrderlines == null){
            allOrderlines = LogicFacade.getOrderlines();
        } else {
            allOrderlines = (List<Orderline>) session.getAttribute("AllOrderlines");
        }
        request.setAttribute("AllOrderlines", allOrderlines);

        return "adminpage";
    }
}
