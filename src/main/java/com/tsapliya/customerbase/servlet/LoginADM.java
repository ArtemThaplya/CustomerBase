package com.tsapliya.customerbase.servlet;

import com.tsapliya.customerbase.login.ValidationService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/login")
public class LoginADM extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ValidationService validationService = new ValidationService();
//        RequestDispatcher dispatcher = request.getRequestDispatcher("web/index.jsp");
//        dispatcher.forward(request, response);
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean statusLogin = validationService.isAdmin(login, password);

        if (statusLogin){
            response.sendRedirect("menu.html");
//            response.sendRedirect("http://localhost:8080/web/admin_main_inteface.html");
//            request.getRequestDispatcher("admin_main_inteface.html").forward(request, response);

        }else {
            response.sendRedirect("index.html");
//            response.sendRedirect("http://localhost:8080/web/admin.html");
//            request.getRequestDispatcher("index.jsp");
        }
        pw.close();
    }
}
