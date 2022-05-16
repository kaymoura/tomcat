/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.kcm.tomcat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import local.kcm.tomcat.bean.Produto;
import local.kcm.tomcat.dao.ProdutoDAO;

/**
 *
 * @author devsys-b
 */
public class HelloWebServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloWebServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloWebServlet at " + request.getContextPath() + "</h1>");
            out.println("<h2>SENAI - Primeiro Servlet</h2>");
            
            // Capturar dados do Banco de dados
            ProdutoDAO pDAO = new ProdutoDAO();
            List<Produto> listaProdutos = pDAO.getResults();
            
            out.println("<h3>Lista de Produtos</h3>");
            out.println("<table width='80%' border='1' >");
            out.println("<tr><td>ID</td>");
            out.println("<td>Descrição</td>");
            out.println("<td>Qtd</td>");
            out.println("<td>Valor Compra</td>");
            out.println("<td>Valor Venda</td>");
            out.println("</tr>");
            
            // Varrer lista
            for (Produto pAux : listaProdutos){
                out.println("<tr>");
                out.println("<td>" + pAux.getId() + "</td>");
                out.println("<td>" + pAux.getDescricao() + "</td>");
                out.println("<td>" + pAux.getQtd() + "</td>");
                out.println("<td>" + pAux.getValorCompra() + "</td>");
                out.println("<td>" + pAux.getValorVenda() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
