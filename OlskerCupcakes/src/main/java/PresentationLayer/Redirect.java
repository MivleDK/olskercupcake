package PresentationLayer;

import FunctionLayer.LoginSampleException;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

    /**
    * redirecter til .jsp sider (Ikke implementeret)
    * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
    */
public class Redirect extends Command{

    /**
     *
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return destination
     * @throws LoginSampleException Exception for login
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");

        return destination;
    }
}
