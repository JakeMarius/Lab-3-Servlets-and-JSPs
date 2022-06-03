/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jake
 */
public class AgeCalculatorServlet extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Load a JSP from this servlet
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        
       // After a JSP has been loaded, stop the code call
        return;
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String web_input = request.getParameter("age");
        
        if(web_input == null || web_input.equals("")){
        
        request.setAttribute("inputNull", true);
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        // Stop the code call after loading a JSP
        return;
        }
        
        try {  
            //try if inputs ia a number.
            Integer.parseInt(web_input); 
            //convert string to integer.
            int new_age = Integer.parseInt(web_input) + 1;
            
            //set the attributes.
            request.setAttribute("newAge", new_age);
            request.setAttribute("rightInput", true);
            
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            // Stop the code call after loading a JSP
              return;
            
        } catch(NumberFormatException e){  
              request.setAttribute("notNum", true);
              getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            // Stop the code call after loading a JSP
              return;
        } 
     
    }
        
}


