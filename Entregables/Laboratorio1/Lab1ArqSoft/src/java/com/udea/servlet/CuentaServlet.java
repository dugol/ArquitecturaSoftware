/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.ClienteFacadeLocal;
import com.udea.ejb.CuentaFacadeLocal;
import com.udea.ejb.MatriculaFacadeLocal;
import com.udea.ejb.VehiculoFacadeLocal;
import com.udea.ejb.VentaFacadeLocal;
import com.udea.entityBean.Matricula;
import com.udea.entityBean.Vehiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class CuentaServlet extends HttpServlet {

    @EJB
    private VentaFacadeLocal ventaFacade;

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;

    @EJB
    private MatriculaFacadeLocal matriculaFacade;

    @EJB
    private CuentaFacadeLocal cuentaFacade;

    @EJB
    private ClienteFacadeLocal clienteFacade;

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
        PrintWriter out=response.getWriter();
        try{
            String action=request.getParameter("action");
            String url="index.jsp";
            if("list".equals(action)){
                List<Vehiculo> findAll=vehiculoFacade.findAll();
                request.getSession().setAttribute("vehiculos", findAll);
                url="listaVehiculos";
            }
            else if("login".equals(action)){
                String u= request.getParameter("username");
                String p= request.getParameter("password");
                boolean checkLogin= cuentaFacade.checkLogin(u, p);
                if(checkLogin){
                   request.getSession().setAttribute("login", u);
                   url="manager.jsp";
                }else {
                    url="login.jsp?error=1";
                }
            }else if ("new".equals(action)){
                Matricula m = new Matricula();
                m.setCodigomatricula(request.getParameter("matricula"));
                m.setPlaca(request.getParameter("placa"));
                Vehiculo v = new Vehiculo();
                v.setMarca(request.getParameter("marca"));
                v.setModelo(request.getParameter("modelo"));
                v.setMatricula(m);
                matriculaFacade.create(m);
                vehiculoFacade.create(v);
                url="listaVehiculos.jsp";
                
            }else if("logout".equals(action)){
                request.getSession().removeAttribute("login");
                url="login.jsp";
            }
            response.sendRedirect(url);
            
        }finally{
            out.close();
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
