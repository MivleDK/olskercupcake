package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customerpage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {

        HttpSession session = request.getSession();

        List<Bottom> allBottoms = (List<Bottom>) session.getAttribute("allBottoms");
        List<Topping> allToppings = (List<Topping>) session.getAttribute("allToppings");

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


        String b = (String) request.getAttribute("kajkage");
        System.out.println(b);


        //System.out.println(polse.get(1).getName());

        request.setAttribute("bottom", allBottoms);
        request.setAttribute("topping", allToppings);

//        int bottom = (int) request.getAttribute("bottom");
//        int topping = (int) request.getAttribute("topping");
//        int antal = (int) request.getAttribute("antal");



        return "customerpage";
    }

}
