package PresentationLayer;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class DeleteOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ParseException, ClassNotFoundException {

        HttpSession session = request.getSession();

        String orderID = request.getParameter("orderId");

        LogicFacade.deleteOrder(Integer.parseInt(orderID));

        List<Orders> allOrders = LogicFacade.getAllOrders();
        List<Orderline> allOrderlines = LogicFacade.getOrderlines();
        request.setAttribute("allOrders", allOrders);
        request.setAttribute("AllOrderlines", allOrderlines);

        return "adminpage";
    }
}
