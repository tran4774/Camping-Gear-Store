package com.example.campinggearstore.controller;

import com.example.campinggearstore.dto.FileDTO;
import com.example.campinggearstore.service.IStorageStrategy;
import com.example.campinggearstore.service.Impl.FirebaseStorageStrategyImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/upload-image"})
public class UploadFileController extends HttpServlet {
    final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    IStorageStrategy storageStrategy;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("file-name");
        resp.setHeader("Content-Type", "application/json");
        if (fileName == null) {
            resp.sendRedirect("/");
            return;
        }
        FileDTO fileDTO = new FileDTO();
        try {
            fileDTO = objectMapper.readValue(req.getReader(), FileDTO.class);
            fileDTO = storageStrategy.generateSignedUrl(fileDTO);
            objectMapper.writeValue(resp.getOutputStream(), fileDTO);
        } catch (Exception e) {
            objectMapper.writeValue(resp.getOutputStream(), e);
        }
    }
}
