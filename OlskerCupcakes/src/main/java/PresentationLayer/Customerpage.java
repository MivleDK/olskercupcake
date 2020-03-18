package PresentationLayer;

import FunctionLayer.Bottom;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class Customerpage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {

        HttpSession session = request.getSession();

        List<Bottom> allBottoms = (List<Bottom>) session.getAttribute("allBottoms");

        if (allBottoms == null) {
            allBottoms = LogicFacade.getBottoms();
        } else {
            allBottoms = (List<Bottom>) session.getAttribute("allBottoms");
        }
        request.setAttribute("customerpage", allBottoms);

        return "customerpage";
    }

}
