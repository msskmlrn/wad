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
import javax.servlet.http.HttpSession;

/**
 *
 * @author miika
 */
public class Login extends HttpServlet {

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
        
        
        /*
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             *
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
        
        */
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
        /*
        PrintWriter out = response.getWriter();
        try {
            out.println("<strong>Käyttäjätunnus</strong><br />");
            out.println("<form method="+"POST"+">");
            out.println("<input type=text name=tunnus /><input type=submit value=Kirjaudu />");
            out.println("</form>");
        } finally {
            out.close();
        } 
        */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tunnus = request.getParameter("tunnus");
        
        if(tunnus != null && tunnus.length() > 3 && tunnus.length() < 9) {
            HttpSession session = request.getSession();
            session.setAttribute("tunnus", tunnus);
                        
            response.sendRedirect(request.getContextPath() + "/Chat");
            
            // lisää sessioon attribuutti tunnus

            // ohjaa osoitteeseen request.getContextPath() + "/Chat"
            //   missä "/Chat" on Chat-servletin kuuntelema polku

            // lähetä tiedot vastaukseen ja palaa metodikutsusta
            response.flushBuffer();
            return;
        }
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
