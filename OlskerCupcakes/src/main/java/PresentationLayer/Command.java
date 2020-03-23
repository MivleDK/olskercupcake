package PresentationLayer;

import FunctionLayer.LoginSampleException;

import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

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
    }


    static Command from(HttpServletRequest request) {
        String targetName = request.getParameter("target");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand());   // unknowncommand er default.
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException, SQLException;

}
