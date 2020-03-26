package PresentationLayer;

import FunctionLayer.LoginSampleException;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

public class Redirect extends Command{
    /**
     *
     * @param request Anvender value fra inputfeltet "target"
     * @param response Anvendes umiddelbart ikke
     * @return
     * @throws LoginSampleException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");

        return destination;
    }
}
