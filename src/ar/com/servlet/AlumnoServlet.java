/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.servlet;

import ar.com.entidades.Alumno;
import ar.com.entidades.AlumnoDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego guzman
 */
public class AlumnoServlet extends HttpServlet {

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
        if (request.getParameter("accion").equals("alta")) {

            Alumno alumno = new Alumno();
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String direccion = request.getParameter("direccion");
            alumno.setApellido(apellido);
            alumno.setNombre(nombre);
            alumno.setDni (dni);
            alumno.setDireccion (direccion);
            AlumnoDAO.insertar(alumno);
            ArrayList alumnos = AlumnoDAO.getTodos();
            request.setAttribute("losAlumnos", alumnos);
            RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
            rd.forward(request, response);

        } else if (request.getParameter("accion").equals("eliminar")) {

            String id = request.getParameter("id");
            AlumnoDAO.eliminar(Integer.valueOf(id));
            ArrayList alumnos = AlumnoDAO.getTodos();
            request.setAttribute("losAlumnos", alumnos);
            RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
            rd.forward(request, response);

        } else if (request.getParameter("accion").equals("consultar")) {

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String id = request.getParameter("id");
            ArrayList alumnos = AlumnoDAO.getAlumnosPorCriterio(id, nombre, apellido);
            request.setAttribute("losAlumnos", alumnos);
            RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
            rd.forward(request, response);

        } else if (request.getParameter("accion").equals("modificar_init")) {

            String id = request.getParameter("id");
            Alumno alumno = AlumnoDAO.getSegunID(Integer.valueOf(id));
            request.setAttribute("elAlumno", alumno);
            RequestDispatcher rd = request.getRequestDispatcher("modificar.jsp");
            rd.forward(request, response);

        } else if (request.getParameter("accion").equals("modificar")) {
            
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String direccion = request.getParameter("direccion");
            
            Alumno alumno = new Alumno();
            alumno.setApellido(apellido);
            alumno.setNombre(nombre);
            alumno.setDni (dni);
            alumno.setDireccion (direccion);
            alumno.setApellido(apellido);
            alumno.setNombre(nombre);
            alumno.setId(Integer.valueOf(id));
            AlumnoDAO.actualizar(alumno);
            ArrayList alumnos = AlumnoDAO.getTodos();
            request.setAttribute("losAlumnos", alumnos);
            RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
            rd.forward(request, response);

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
