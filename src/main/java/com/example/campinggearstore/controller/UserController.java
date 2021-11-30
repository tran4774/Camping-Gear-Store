package com.example.campinggearstore.controller;

//import com.example.campinggearstore.config.MongoDBConfig;
import com.example.campinggearstore.entity.UserEntity;
//import com.example.campinggearstore.repository.IUserRepository;
//import com.example.campinggearstore.repository.impl.UserRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserController extends HttpServlet {

    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            resp.sendRedirect("/");
            return;
        }
        UserEntity user = new UserEntity();
        user = objectMapper.readValue(req.getReader(), UserEntity.class);
        req.getSession().setAttribute("user", user);
        req.getRequestDispatcher(req.getContextPath() + '/' + action).forward(req, resp);
    }
}
