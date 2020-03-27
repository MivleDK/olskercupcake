package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

    /**
    * Opretter en ny kunde i databasen
    * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
    */
public class Register extends Command {

    /**
     *
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return returnerer en bruger til kundesiden
     * @throws LoginSampleException Exception for login
     * @throws SQLException Exception for SQL
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        boolean emailFlag = false;
        boolean phoneFlag = false;
        boolean passwordFlag = false;
        String errMessage;

        if (!(email.equalsIgnoreCase(""))) {
            emailFlag = true;
        } else {
            errMessage = "You must provide a valid Email";
            throw new LoginSampleException(errMessage);
        }

        if (!(phone.length() < 8)) {
            phoneFlag = true;
        } else {
            errMessage = "You must provide a valid phone number";
            throw new LoginSampleException(errMessage);
        }

        if (!(password1.equals(password2) && password1 == null)) {
            passwordFlag = true;
        } else {
            errMessage = "The two passwords did not match";
            throw new LoginSampleException(errMessage);
        }

        if (emailFlag && phoneFlag && passwordFlag) {
            User user = LogicFacade.createUser(email, Integer.parseInt(phone), password1);
            HttpSession session = request.getSession();

            session.setAttribute("userId", user.getId());
            session.setAttribute("email", email);
            session.setAttribute("phone", phone);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            List<Bottom> allBottoms = LogicFacade.getBottoms();
            List<Topping> allToppings = LogicFacade.getToppings();
            request.setAttribute("bottom", allBottoms);
            request.setAttribute("topping", allToppings);

            return user.getRole() + "page";
        } else {
            throw new LoginSampleException("Something else went wrong - Contact IT!");
        }
    }
}
