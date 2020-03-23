package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class Adminpage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();

        List<Orders> allOrders = (List<Orders>) session.getAttribute("allOrders");

        if (allOrders == null) {
            allOrders = LogicFacade.getAllOrders();
        } else {
            allOrders = (List<Orders>) session.getAttribute("allOrders");
        }
        request.setAttribute("allOrders", allOrders);

        return "adminpage";
    }
}
