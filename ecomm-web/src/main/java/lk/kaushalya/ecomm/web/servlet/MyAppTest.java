package lk.kaushalya.ecomm.web.servlet;


import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.kaushalya.ecomm.ejb.remote.AppSetting;

import java.io.IOException;

@WebServlet(value = "/testmyapp",loadOnStartup = 1)
public class MyAppTest extends HttpServlet {

    @Inject
    private MyApp myApp;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("MyAppTest init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        resp.setContentType("text/html");
        resp.getWriter().write("<h1><Strong>E-commerce Web module MyAppTest</Strong></h1>");
        req.getSession();
        myApp.doSomething();
    }
}
