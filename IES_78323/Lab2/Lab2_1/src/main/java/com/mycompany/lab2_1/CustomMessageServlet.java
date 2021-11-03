/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2_1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diogo
 */
@WebServlet(name = "CustomMessageServlet", urlPatterns = {"/CustomMessageServlet"})
public class CustomMessageServlet extends HttpServlet {

    
    public boolean validateUser(String name){
        return !(name == null | name.isEmpty() | name.isBlank());
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        boolean success = validateUser(name);

        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");

            if(success) {
                out.println("<h2>Welcome "+name+"!</h2>");
            }else{
                out.println("<h2>No name inserted!</h2>");
                out.println(" <button onclick=\"location.href='CustomMessage.html'\" type=\"button\">\n CustomMessage</button>");
                
            }

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
