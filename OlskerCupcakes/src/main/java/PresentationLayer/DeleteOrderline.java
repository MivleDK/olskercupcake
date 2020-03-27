package PresentationLayer;

import FunctionLayer.Basket;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

    /**
    * Sletter en ordrelinje fra kurv
    * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
    */
public class DeleteOrderline extends Command {

    /**
     *
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return kurv
     * @throws LoginSampleException Exception for login
     * @throws SQLException Exception for SQL
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        HttpSession session = request.getSession();

        String uniqueId = request.getParameter("uniqueId");

        List<Basket> basket = (List<Basket>) session.getAttribute("basket");

        /*
        Find ordrelinjes unikke ID og slet den hvis det findes.
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
