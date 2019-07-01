package controladores;

import BD.ConexionMongo;
import clases.Sedeeeee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SedesControlador", urlPatterns = {"/SedesControlador"})
public class SedesControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ConexionMongo conexion = new ConexionMongo();
            ArrayList<Sedeeeee> sedes =conexion.obtenerSedes();
            conexion.cerrarConexion();
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/sedes/verSedes.jsp").forward(request, response);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SedesControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SedesControlador aat " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        if(request.getParameter("pagina").equals("verSedes")){
//            response.sendRedirect("administrador/sedes/verSedes.jsp");
            ConexionMongo conexion = new ConexionMongo();
            ArrayList<Sedeeeee> sedes =conexion.obtenerSedes();
            conexion.cerrarConexion();
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/sedes/verSedes.jsp").forward(request, response);
        }else if(request.getParameter("pagina").equals("editarSede")){
            ConexionMongo conexion = new ConexionMongo();
            Sedeeeee sede =conexion.obtenerSede(Integer.parseInt(request.getParameter("id")));
            conexion.cerrarConexion();
            request.setAttribute("sede",sede);
            request.getRequestDispatcher("administrador/sedes/editarSede.jsp").forward(request, response);
        }else if(request.getParameter("pagina").equals("crearSede")){
            request.getRequestDispatcher("administrador/sedes/crearSede.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("_method").equals("POST")){
            String nombre = request.getParameter("nombreSede");
            String direccion = request.getParameter("direccionSede");
            int aforo = Integer.parseInt(request.getParameter("aforoSede"));
            ConexionMongo conexion = new ConexionMongo();
            conexion.crearSede(nombre,direccion,aforo);
            ArrayList<Sedeeeee> sedes =conexion.obtenerSedes();
            conexion.cerrarConexion();
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/sedes/verSedes.jsp").forward(request, response);
        }else if(request.getParameter("_method").equals("PUT")){
            String nombre = request.getParameter("nombreSede");
            String direccion = request.getParameter("direccionSede");
            int aforo = Integer.parseInt(request.getParameter("aforoSede"));
            int sedeId = Integer.parseInt(request.getParameter("sedeId"));

            ConexionMongo conexion = new ConexionMongo();
            conexion.editarSede(nombre, direccion, aforo, sedeId);
            ArrayList<Sedeeeee> sedes =conexion.obtenerSedes();
            conexion.cerrarConexion();
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/sedes/verSedes.jsp").forward(request, response);
        }else if(request.getParameter("_method").equals("DELETE")){
            int sedeId = Integer.parseInt(request.getParameter("sedeId"));

            ConexionMongo conexion = new ConexionMongo();
            conexion.eliminarSede(sedeId);
            ArrayList<Sedeeeee> sedes =conexion.obtenerSedes();
            conexion.cerrarConexion();
            request.setAttribute("sedes",sedes);
            request.getRequestDispatcher("administrador/sedes/verSedes.jsp").forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
