package com.example.campinggearstore.controller;

import com.example.campinggearstore.entity.ProductEntity;
import com.example.campinggearstore.service.IProductService;
import com.example.campinggearstore.service.Impl.ProductServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/products"})
public class ProductController extends HttpServlet {
    final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private IProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "application/json");
        List<ProductEntity> listProducts = new ArrayList<ProductEntity>();
        objectMapper.writeValue(resp.getOutputStream(), listProducts);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            resp.sendRedirect("/");
            return;
        }
        List<ProductEntity> listProducts = new ArrayList<ProductEntity>();
        listProducts = objectMapper.readValue(req.getReader(), new TypeReference<List<ProductEntity>>(){});
        productService.saveListProducts(listProducts);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
