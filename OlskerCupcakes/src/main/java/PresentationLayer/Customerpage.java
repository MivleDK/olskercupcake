package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customerpage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();

        List<Bottom> allBottoms = (List<Bottom>) session.getAttribute("allBottoms");
        List<Topping> allToppings = (List<Topping>) session.getAttribute("allToppings");

        if(session.getAttribute("basket") == null ) {
            List<Basket> basket = new ArrayList<>();
            session.setAttribute("basket", basket);
        }

        int bottomId = Integer.parseInt(request.getParameter("bottom")) - 1;
        int toppingId = Integer.parseInt(request.getParameter("topping")) - 1;
        int antal = Integer.parseInt(request.getParameter("antal"));

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

        String bottomName = b.get(bottomId).getName();
        double bottomPrice = b.get(bottomId).getPrice();
        String toppingName = t.get(toppingId).getName();
        double toppingPrice = t.get(toppingId).getPrice();
        double totalPrice = (bottomPrice + toppingPrice) * antal;

        Basket orderline = new Basket(bottomName,toppingName,antal,totalPrice);
        ((List<Basket>) session.getAttribute("basket") ).add(orderline);

        return "customerpage";
    }

}
