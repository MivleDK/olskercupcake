package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class OrderCupcake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        HttpSession session = request.getSession();

        List<Basket> basket = (List<Basket>) session.getAttribute("basket");

        double sumTotal = Double.parseDouble(request.getParameter("sumTotal"));
        int userId = (int) session.getAttribute("userId");

        if (!(basket == null) && !(basket.isEmpty())) {

            // get userId to create order and fetch orderId
            int orderId = LogicFacade.createOrder(userId);

            // Loop through basket and insert into orderline with new orderId
            for (int i = 0; i < basket.size(); i++) {
                int quantity = basket.get(i).getAmount();
                double totalPrice = basket.get(i).getTotalPrice();
                int toppingId = basket.get(i).getToppingId();
                int bottomId = basket.get(i).getBottomId();

                LogicFacade.createOrderline(orderId, quantity, totalPrice, toppingId, bottomId);
            }

            // Subtract sumTotal from user
            LogicFacade.updateUserCredit(userId,sumTotal);
        } else {
            request.setAttribute("besked", "Der er ingen varer i din kurv?");
            return "kurv";
        }
        // kill session on basket
        basket.clear();
        request.setAttribute("besked", "Tak for din ordre");

        return "kurv";
    }
}