package com.example.campinggearstore.controller.user;

import com.example.campinggearstore.entity.UserEntity;
import com.example.campinggearstore.repository.IUserRepository;
import com.example.campinggearstore.repository.impl.UserRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    final ObjectMapper objectMapper = new ObjectMapper();
    final IUserRepository repo = UserRepositoryImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserEntity user = (UserEntity) req.getSession().getAttribute("user");
        UserEntity user2;
        try {
            user2 = repo.create(user);
            objectMapper.writeValue(resp.getOutputStream(), user2);
        } catch (Exception e) {
            objectMapper.writeValue(resp.getOutputStream(), e);
        }
    }
}
