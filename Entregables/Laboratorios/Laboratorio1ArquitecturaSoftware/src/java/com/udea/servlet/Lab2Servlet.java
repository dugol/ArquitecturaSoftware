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
import com.udea.entity.Cliente;
import com.udea.entity.Matricula;
import com.udea.entity.Vehiculo;
import com.udea.entity.Venta;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Daniel
 */
@MultipartConfig
public class Lab2Servlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            String url = "index.jsp";
            if ("listClient".equals(action)) {
                List<Cliente> findAll = clienteFacade.findAll();
                request.getSession().setAttribute("clientes", findAll);
                url = "listaClientes.jsp";
            } else if ("listCar".equals(action)) {
                List<Vehiculo> findAll = vehiculoFacade.findAll();
                request.getSession().setAttribute("vehiculos", findAll);
                url = "listaVehiculos.jsp";
            } else if ("listSale".equals(action)) {
                List<Venta> findAll = ventaFacade.findAll();
                request.getSession().setAttribute("ventas", findAll);
                url = "listaVentas.jsp";
            } else if ("login".equals(action)) {
                String u = request.getParameter("username");
                String p = request.getParameter("password");
                boolean checkLogin = cuentaFacade.checkLogin(u, p);
                if (checkLogin) {
                    request.getSession().setAttribute("login", u);
                    url = "manager.jsp";
                } else {
                    url = "login.jsp?error=1";
                }
            } else if ("toAddCar".equals(action)) {
                url = "nuevoVehiculo.jsp";
            } else if ("toAddCliente".equals(action)) {
                url = "nuevoCliente.jsp";
            } else if ("toAddVenta".equals(action)) {
                url = "nuevaVenta.jsp";
            } else if ("newClient".equals(action)) {
                Cliente cliente = new Cliente();
                cliente.setNombre(request.getParameter("name"));
                cliente.setDocumento(request.getParameter("document"));
                cliente.setDireccion(request.getParameter("address"));
                cliente.setTelefono(request.getParameter("phone"));
                cliente.setCorreo(request.getParameter("email"));
                clienteFacade.create(cliente);
                url = "listaClientes.jsp";
            } else if ("newSale".equals(action)) {
                Venta venta = new Venta();
                venta.setValor(Integer.parseInt(request.getParameter("value")));
                Matricula m = new Matricula(request.getParameter("matricula"));
                venta.setMatricula(m);
                Cliente c = new Cliente(request.getParameter("client"));
                venta.setCliente(c);
                ventaFacade.create(venta);
                url = "listaVentas.jsp";

            } else if ("newCar".equals(action)) {
                Part archivo = request.getPart("image");
                Matricula m = new Matricula();
                m.setCodigoMatricula(request.getParameter("matricula"));
                m.setPlaca(request.getParameter("placa"));
                Vehiculo v = new Vehiculo();

                
                v.setMarca(request.getParameter("marca"));
                v.setModelo(request.getParameter("modelo"));
                v.setMatricula(m);
                if(archivo !=null && archivo.getSize()>0){
                 InputStream i = archivo.getInputStream();
                byte[] contents;
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;
                while ((count = i.read(buffer)) != -1) {
                    output.write(buffer, 0, count);
                }//debugger says myinputstream has blksize 16384, buffcount 12742, and max 127394 here
                contents = output.toByteArray();
                v.setFoto(contents);
                }else{
                    v.setFoto(null);
                }
                
                
                matriculaFacade.create(m);
                vehiculoFacade.create(v);
                url = "login.jsp";

            } else if ("filter".equals(action)) {
                String filter=request.getParameter("filter");
                Matricula m= new Matricula();
                m.setCodigoMatricula(filter);
                List<Vehiculo> vehiculos=vehiculoFacade.findByMatricula(m);
                request.getSession().setAttribute("vehiculos", vehiculos);
                url = "listaVehiculos.jsp";
            } 
            else if ("logout".equals(action)) {
                request.getSession().removeAttribute("login");
                url = "login.jsp";
            }
            response.sendRedirect(url);

        } finally {
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
