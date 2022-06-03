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
public class ArithmeticCalculatorServlet extends HttpServlet {

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
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
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
        // Capture the incoming parameters from the JSP
        String first_input = request.getParameter("first");
        String second_input = request.getParameter("second");
        String operation = request.getParameter("action");
        String invalidOutput;
        
        // Set attributes in the request object, to be forwarded to the JSP
        request.setAttribute("firstInput", first_input);
        request.setAttribute("secondInput", second_input);
                
        if(first_input == null || first_input.equals("") || second_input == null || second_input.equals("")){
             
            invalidOutput = "invalid";
            request.setAttribute("outPut", invalidOutput);
        
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            // Stop the code call after loading a JSP
            return;
             
        }
        try {
            //try if inputs are numbers.
            Integer.parseInt(first_input); 
            Integer.parseInt(second_input);
            
            //convert string to integer.
            int firstNum = Integer.parseInt(first_input);
            int secondNum = Integer.parseInt(second_input);
            int answer = 0;
            
            //test if operation is addition, subraction, mutiplication or divition
            switch (operation) {
                case "+":
                    answer = firstNum + secondNum;
                    break;
                case "-":
                    answer = firstNum - secondNum;
                    break;
                case "*":
                    answer = firstNum * secondNum;
                    break;
                case "%":
                    answer = firstNum / secondNum;
                    break;
            }
            //set the answer attribute
            request.setAttribute("outPut", answer);
            
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            // Stop the code call after loading a JSP
              return;
            
        } catch(NumberFormatException e){
            
            invalidOutput = "invalid";
            request.setAttribute("outPut", invalidOutput);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            // Stop the code call after loading a JSP
              return;
        } 
    }
}
