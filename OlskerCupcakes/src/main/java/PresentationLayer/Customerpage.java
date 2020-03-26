package PresentationLayer;

import FunctionLayer.Basket;
import FunctionLayer.Bottom;
import FunctionLayer.LogicFacade;
import FunctionLayer.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
        /**
        * Tilføjer orderline til list basket
        * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
        */

public class Customerpage extends Command {
    /**
     *
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return customerpage
     * @throws NumberFormatException
     * @throws SQLException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException {
        HttpSession session = request.getSession();

        List<Bottom> allBottoms = (List<Bottom>) session.getAttribute("allBottoms");
        List<Topping> allToppings = (List<Topping>) session.getAttribute("allToppings");

        if(session.getAttribute("basket") == null ) {
            List<Basket> basket = new ArrayList<>();
            session.setAttribute("basket", basket);
        }

        int bId = 0;
        int tId = 0;
        int bottomId = -1;
        int toppingId = -1;
        int antal = 0;
        try {
            bId = Integer.parseInt(request.getParameter("bottom"));
            tId = Integer.parseInt(request.getParameter("topping"));
            bottomId = Integer.parseInt(request.getParameter("bottom")) - 1;
            toppingId = Integer.parseInt(request.getParameter("topping")) - 1;
            antal = Integer.parseInt(request.getParameter("antal"));
        } catch (NumberFormatException ex) {}


        if (allBottoms == null) {
            allBottoms = LogicFacade.getBottoms();
        } else {
            allBottoms = (List<Bottom>) session.getAttribute("allBottoms");
        }

        if (allToppings == null) {
            allToppings = LogicFacade.getToppings();
        } else {
            allToppings = (List<Topping>) session.getAttribute("allToppings");
        }
        request.setAttribute("bottom", allBottoms);
        request.setAttribute("topping", allToppings);

        List<Bottom> b = (List<Bottom>) request.getAttribute("bottom");
        List<Topping> t = (List<Topping>) request.getAttribute("topping");

       if(bottomId != -1 && toppingId != -1 && antal > 0) {
           String lineId = UUID.randomUUID().toString();
           //System.out.println(lineId);

           String bottomName = b.get(bottomId).getName();
           double bottomPrice = b.get(bottomId).getPrice();
           String toppingName = t.get(toppingId).getName();
           double toppingPrice = t.get(toppingId).getPrice();
           double totalPrice = (bottomPrice + toppingPrice) * antal;
           Basket orderline = new Basket(lineId,bId,tId,bottomName, toppingName, antal, totalPrice);
           ((List<Basket>) session.getAttribute("basket")).add(orderline);
       }
        return "customerpage";
    }
}
