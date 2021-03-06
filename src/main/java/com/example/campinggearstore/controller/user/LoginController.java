package com.example.campinggearstore.controller.user;

import javax.servlet.RequestDispatcher;
import com.example.campinggearstore.entity.UserEntity;
import com.google.firebase.auth.internal.GetAccountInfoResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/loginPage.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserEntity user = new UserEntity();
        req.setAttribute("user", user);
        req.getRequestDispatcher(req.getContextPath() + "/index.jsp");
    }
}
