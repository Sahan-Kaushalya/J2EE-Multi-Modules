package lk.kaushalya.ecomm.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.kaushalya.ecomm.user.remote.TestRemote;
import lk.kaushalya.ecomm.user.remote.UserRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/test",loadOnStartup = 1)
public class Test extends HttpServlet {

    @EJB(lookup = "java:global/ecomm-user-1.0/TestSessionBean") // since J2EE 5+
    private TestRemote testRemote;

    @Override
    public void init() throws ServletException {

        System.out.println("============== Servlet Service Init ==============");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        try {
//            TestRemote tr;
//
//            HttpSession session = req.getSession();
////            if (session.getAttribute("testBean") == null) {
//                InitialContext ic = new InitialContext(); /// since J2EE 1+
////            UserRemote userRemote = (UserRemote) ic.lookup("java:global/ecomm-user-1.0/UserSessionBean");
////
////            List<UserDTO> allUsers = userRemote.getAllUsers();
////            for (UserDTO user: allUsers){
////              resp.getWriter().write(user.toString());
////            }
//                tr = (TestRemote) ic.lookup("java:global/ecomm-user-1.0/TestSessionBean");
//                session.setAttribute("testBean", tr);
////            } else {
////                tr = (TestRemote) session.getAttribute("testBean");
////            }
//
//            String test = tr.test();
//
///          //  tr.remove();
//        } catch (NamingException e) {
//            throw new RuntimeException(e);
//        }

//        resp.getWriter().write("E-commerce Web module Test");
        resp.setContentType("text/html");
        resp.getWriter().write("<h2><Strong>E-commerce Web module Test</Strong></h2><br>");
        resp.getWriter().write("<h4><Strong>Result :" + testRemote.test()+"</Strong></h4>");

    }
}
