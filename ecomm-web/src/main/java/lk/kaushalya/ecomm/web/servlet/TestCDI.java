package lk.kaushalya.ecomm.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.kaushalya.ecomm.ejb.remote.AppSetting;

import java.io.IOException;

@WebServlet(value = "/testCDI",loadOnStartup = 1)
public class TestCDI extends HttpServlet {

    @EJB
    private AppSetting appSetting;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("TestCDI init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        resp.setContentType("text/html");
        resp.getWriter().write("Application Name: <strong>"+appSetting.getName()+"</strong><br>");
    }
}
