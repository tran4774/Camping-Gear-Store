package com.example.campinggearstore.controller;

import com.example.campinggearstore.config.MongoDBConfig;
import com.example.campinggearstore.entity.UserEntity;
import com.example.campinggearstore.repository.IUserRepository;
import com.example.campinggearstore.repository.impl.UserRepositoryImpl;
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
    final IUserRepository repo = UserRepositoryImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserEntity u = new UserEntity();
//        u.setUsername("tran");
//        u.setPassword("123");
//        UserEntity u2 = repo.create(u);
//        System.out.println(u2.getUsername());
//
//        UserEntity u = repo.findByID(new ObjectId("61a1dcc01c5e200fbf80e1cb"));
//        u.setPassword("123456");
//        repo.update(u);
//        int i = 3;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserEntity user = new UserEntity();
//        user = objectMapper.readValue(req.getReader(), UserEntity.class);
//        UserEntity user2;
//        try {
//            user2 = repo.create(user);
//            objectMapper.writeValue(resp.getOutputStream(), user2);
//        }
//        catch(Exception e){
//            objectMapper.writeValue(resp.getOutputStream(), e);
//        }
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
