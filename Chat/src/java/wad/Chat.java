/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author miika
 */
public class Chat extends HttpServlet {
    
    private Queue<String> viestit = new LinkedList();
    
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
            
             * TODO output your page here. You may use following sample code.
             *
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Chat</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Chat at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
        * 
        */
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            tarkistaKirjautuminen(request, response);
            out.println("<strong>Chat</strong><br />");
            out.println("<form method="+"POST"+">");
            out.println("<input type=text name=viesti /><input type=submit value=Lähetä />");
            out.println("</form>");
            
            out.println("<strong>Viestit</strong><br />");
            Iterator iterator = viestit.iterator();
            while (iterator.hasNext()) {
                out.println(iterator.next()+ "<br />");
            }
            out.println("<a href=\"" + request.getContextPath() + "/Logout\">kirjaudu ulos</a>");
            // tulostaminen
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        try {
            tarkistaKirjautuminen(request, response);
                        String tunnus = "" + request.getSession().getAttribute("tunnus");
            String viesti = tunnus + ": " + request.getParameter("viesti");
            
            if (viestit.size() < 10) {
                //viestit.add(request.getParameter("viesti"));
                viestit.add(viesti);
            }
            else {
                viestit.remove();
                viestit.add(viesti);
                //viestit.add(request.getParameter("viesti"));
            }
            Iterator iterator = viestit.iterator();
            while (iterator.hasNext()) {
                out.println(iterator.next());
            }
            response.sendRedirect(request.getRequestURI());
        } finally {
            out.close();
        }
    }
    
    private void tarkistaKirjautuminen(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        String tunnus = (String) request.getSession().getAttribute("tunnus");
        
        if (tunnus == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
        // jos sessiossa ei ole attribuuttia tunnus
        //   ohjaa käyttäjä osoitteeseen request.getContextPath() + "/Login"
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
