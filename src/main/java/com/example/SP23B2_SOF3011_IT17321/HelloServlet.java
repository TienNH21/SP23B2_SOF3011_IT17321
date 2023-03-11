package com.example.SP23B2_SOF3011_IT17321;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({
    "/hello",
    "/hello1",
})
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World 123!";
    }

    public void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws IOException, ServletException {
        String name = "TienNH21";
        request.setAttribute("hoTen", name);
        request.getRequestDispatcher("/views/hello.jsp")
            .forward(request, response);
    }

    public void destroy() {
    }
}