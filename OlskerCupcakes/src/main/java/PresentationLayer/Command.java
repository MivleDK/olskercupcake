package PresentationLayer;

import FunctionLayer.LoginSampleException;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

        /**
        * Command Pattern designskabelon
        * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
        */

abstract class Command {

    private static HashMap<String, Command> commands;

    /**
     * Initialiserer HashMap som refererer til samtlige .jsp sider og deres klasser
     */

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("redirect", new Redirect());
        commands.put("deleteUser", new DeleteUser());
        commands.put("addCredit", new AddCredit());
        commands.put("kundekartotek", new Kundekartotek());
        commands.put("resetcode", new ResetCode());
        commands.put("adminpage", new Adminpage());
        commands.put("customerpage", new Customerpage());
        commands.put("kurv", new Kurv());
        commands.put("tidligereordre", new Tidligereordre());
        commands.put("deleteOrderline", new DeleteOrderline());
        commands.put("orderCupcake", new OrderCupcake());
        commands.put("logout", new Logout());
        commands.put("deleteOrder", new DeleteOrder());
        commands.put("updateOrderStatus", new UpdateOrderStatus());
    }

    /**
     * @param request Henter en hidden value fra et hidden inputfelt med navnet "target" fra en form på en .jsp-side
     * @return Returnerer value fra inputfeltet "target"
     */
    static Command from(HttpServletRequest request) {
        String targetName = request.getParameter("target");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand());   // unknowncommand er default.
    }

    /**
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return Returnerer klassen med samme navn som value fra "target"
     * @throws LoginSampleException
     * @throws SQLException
     * @throws ParseException
     * @throws ClassNotFoundException
     */
    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException, SQLException, ParseException, ClassNotFoundException;

}
