package com.simplewebapp.simplewebapp;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("message", "Hello, World! i am kshitij ");

        req.setAttribute("message", session.getAttribute("message"));
        req.getRequestDispatcher("hello.jsp").forward(req, resp);
    }
}