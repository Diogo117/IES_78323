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
@WebServlet(name = "RequestServlet", urlPatterns = {"/RequestServlet"})
public class RequestServlet extends HttpServlet{
    
    public boolean validateUser(String name, String pass){
        return name == null ? pass == null : name.equals(pass);
}
    
    
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean success = validateUser(username, password);

        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");

            if(success) {
                out.println("<h2>Welcome Friend</h2>");
                out.println("<h2>"+username+"</h2>");
                out.println("<h2>"+password+"</h2>");
            }else{
                out.println("<h2>Validate your self again.</h2>");
            }

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

}
