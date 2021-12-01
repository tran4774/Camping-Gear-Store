package com.example.campinggearstore.controller.api;

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
import java.util.regex.Pattern;

@WebServlet(urlPatterns = {"/api/products"})
public class ProductsAPI extends HttpServlet {
    @Autowired
    IProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNumber = req.getParameter("page");
        Pattern pattern = Pattern.compile("^[0-9]$");
        if(pageNumber == null || !pattern.matcher(pageNumber).matches()){
            resp.sendRedirect("/views/web/homepage.jsp");
            return;
        }
        int pageIndex = Integer.parseInt(pageNumber) - 1;
        List<ProductEntity> listProducts = new ArrayList<ProductEntity>();
        listProducts = productService.getProductsPageable(pageIndex, 6);
        req.setAttribute("listProducts", listProducts);
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/components/product.component.jsp");
        rd.forward(req, resp);
    }
}
