/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miika
 */
public class AwesomeServlet extends HttpServlet {
    private int kavijoita = 0;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("kavijoita", kavijoita++);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("awesome.jsp");
        dispatcher.forward(request, response);
        /*
        PrintWriter out = response.getWriter();
        
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
          /*  
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AwesomeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet AwesomeServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Awesomer!</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
        */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);  
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
