package com.business.testspa;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "InvoiceServlet", value = "/invoice")
public class InvoiceServlet extends HttpServlet {
    private String message;


    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        response.setContentType("application/xml");
        String id = request.getParameter("id");
        String desc = request.getParameter("desc");
        String amount = request.getParameter("amount");
        PrintWriter out = response.getWriter();
        if(id.isEmpty())
            id="1";
        else if(Integer.parseInt(id)< 101)
            id="1";
        if(amount.isEmpty())
            amount="1";
        else if(Integer.parseInt(amount)<=1000 || Integer.parseInt(amount)>=2000)
            amount="1";
        out.println("<response>");
        if(id.equals("1") || desc.isEmpty() || amount.equals("1")){
            if (Integer.parseInt(id) < 101)
                out.println("<message1> it has to be &gt; 100 </message1>");
                if (desc.isEmpty())
                    out.println("<message2> description mandatory </message2>");
                    if (Integer.parseInt(amount)<=1000 || Integer.parseInt(amount)>=2000)
                        out.print("<message3> it has to be &lt; 1000 and &gt; 2000  </message3>");
        }
        else
            out.println("<message4> Saved invoice </message4>");

//|| desc.isEmpty() || (Integer.parseInt(amount)<=1000 && Integer.parseInt(amount)>=2000)
        out.println("</response>");
        out.close();


        System.out.println("version final today");
    }

}
