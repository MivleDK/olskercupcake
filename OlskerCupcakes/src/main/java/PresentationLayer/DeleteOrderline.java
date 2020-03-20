package PresentationLayer;

import FunctionLayer.Basket;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class DeleteOrderline extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        HttpSession session = request.getSession();

        String unikId = request.getParameter("unikId");

        List<Basket> basket = (List<Basket>) session.getAttribute("basket");


        /**
         * Find ordrelinjes unikke ID og slet den hvis det findes.
         */
        for (int i = 0; i < basket.size(); i++) {
            String findID = basket.get(i).getLineId();
            if (findID.equalsIgnoreCase(unikId)) {
                System.out.println(unikId);
                System.out.println(basket.get(i).getLineId());
                basket.remove(i);
            }
        }
        System.out.println(basket.size());

        return "kurv";
    }
}
