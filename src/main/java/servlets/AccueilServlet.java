/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Controllers.categorie;
import Controllers.voiture;
import Models.CategorieModel;
import Models.VoitureModel;
import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BABA SAIDOU DIEME
 */
@WebServlet(name = "accueil", urlPatterns = {"/accueil"})
public class AccueilServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private voiture auto;
    private categorie cat;
    
    @Override
    public void init (){
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        auto = new voiture("jdbc:mysql://localhost:3306/Ecommerce", "root", "");
        cat = new categorie("jdbc:mysql://localhost:3306/Ecommerce", "root", "");
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws java.sql.SQLException
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     public void voituresEtCategories(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
       
        List<VoitureModel> listVoiture = auto.getAllVoiture();
        request.setAttribute("listvoiture", listVoiture);
        List<CategorieModel> listCategorie = cat.getAllCategories();
        request.setAttribute("listCategorie", listCategorie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("accueil.jsp");
        dispatcher.forward(request, response);
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
         try {
            voituresEtCategories(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
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
