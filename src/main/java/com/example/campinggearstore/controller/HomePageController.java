package com.example.campinggearstore.controller;

import com.example.campinggearstore.entity.CategoryEntity;
import com.example.campinggearstore.entity.ProductEntity;
import com.example.campinggearstore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomePageController extends HttpServlet {
    @Autowired
    IProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductEntity> listProducts = new ArrayList<ProductEntity>();
        listProducts = productService.getAllProducts();
        req.setAttribute("listProducts", listProducts);

        List<CategoryEntity> listCategories = new ArrayList<CategoryEntity>();
        req.setAttribute("listCategories", listCategories);
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/homepage.jsp");
        rd.forward(req, resp);
    }
}
