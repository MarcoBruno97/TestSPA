package com.business.testspa;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "backendServlet", value = "/backend")
public class BackendServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //JSON
        /*
        response.setContentType("application/json");
        String username = request.getParameter("username");
        PrintWriter out = response.getWriter();
        out.println("{\"message\":\"" + username + "\"}");
        out.close();

        */

        //xml


        response.setContentType("application/xml");
        String username = request.getParameter("username");
        PrintWriter out = response.getWriter();
        out.println("<message>Welcome " + username + " </message>");//xml è case sensitive,forse
        out.close();


        System.out.println("in doGet()");
    }

}