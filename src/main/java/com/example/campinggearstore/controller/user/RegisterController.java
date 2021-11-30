package com.example.campinggearstore.controller.user;

import com.example.campinggearstore.entity.UserEntity;
//import com.example.campinggearstore.repository.IUserRepository;
//import com.example.campinggearstore.repository.impl.UserRepositoryImpl;
import com.example.campinggearstore.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private UserRepository userRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/regisPage.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserEntity user = (UserEntity) req.getSession().getAttribute("user");
        UserEntity user2;
        try {
            user2 = userRepository.save(user);
            objectMapper.writeValue(resp.getOutputStream(), user2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("/index.jsp");
    }
}
