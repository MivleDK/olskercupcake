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

        //System.out.println(basket.get(1).getLineId());
        //basket.remove(1);
        //basket.remove(searchFunc(basket,unikId));
        //System.out.println(searchFunc(basket,unikId));
        //System.out.println(unikId);
        //System.out.println(basket.get(0).getBottom());
        for (int i = 0; i < basket.size(); i++) {
            String findID = basket.get(i).getLineId();
            if (findID.equalsIgnoreCase(unikId)) {
                System.out.println(basket.get(i));
                //basket.remove(findID);
            }
        }
        System.out.println(basket.size());

        return "kurv";
    }

    private int searchFunc(List<Basket> basket, String unikId){
        int index = 0;
        if (basket.size() > 1) {
            for (int i = 0; i < basket.size(); i++) {
                String findID = basket.get(i).getLineId();
                if (findID.equalsIgnoreCase(unikId)) {
                    index = i;
                }
            }
        }
        return index;
    }
}
