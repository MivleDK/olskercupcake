package PresentationLayer;

import FunctionLayer.Basket;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class DeleteOrderline extends Command {
    /**
     *
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return
     * @throws LoginSampleException
     * @throws SQLException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        HttpSession session = request.getSession();

        String uniqueId = request.getParameter("uniqueId");

        List<Basket> basket = (List<Basket>) session.getAttribute("basket");


        /*
         * Find ordrelinjes unikke ID og slet den hvis det findes.
         */
        for (int i = 0; i < basket.size(); i++) {
            String findID = basket.get(i).getLineId();
            if (findID.equalsIgnoreCase(uniqueId)) {
                //System.out.println(unikId);
                //System.out.println(basket.get(i).getLineId());
                basket.remove(i);
            }
        }
        //System.out.println(basket.size());

        return "kurv";
    }
}
