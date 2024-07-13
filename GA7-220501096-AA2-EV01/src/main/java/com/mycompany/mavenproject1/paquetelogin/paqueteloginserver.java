package com.mycompany.mavenproject1.paquetelogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "paqueteloginserver", urlPatterns = {"/paqueteloginserver"})
public class paqueteloginserver extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/sena";
    private static final String USER = "root";
    private static final String PASSWORD = "1234567890";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load MySQL driver", e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            switch (accion) {
                case "insertar":
                    insertarUsuario(request, response, out);
                    break;
                case "consultar":
                    consultarUsuario(request, response, out);
                    break;
                case "actualizar":
                    actualizarUsuario(request, response, out);
                    break;
                case "eliminar":
                    eliminarUsuario(request, response, out);
                    break;
                case "listar":
                    listarUsuarios(request, response, out);
                    break;
                default:
                    out.println("Acción no soportada.");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws SQLException {
        String usuario = request.getParameter("usuario");
        String query = "INSERT INTO usuarios (usuario) VALUES (?)";
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, usuario);
            pstmt.executeUpdate();
        }
        out.println("Usuario insertado exitosamente.");
    }

    private void consultarUsuario(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String query = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                out.println(rs.getInt("id") + "," + rs.getString("usuario"));
            } else {
                out.println("Usuario no encontrado.");
            }
        }
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws SQLException {
        String query = "SELECT * FROM usuarios";
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                out.println(rs.getInt("id") + "," + rs.getString("usuario"));
            }
        }
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String usuario = request.getParameter("usuario");
        String query = "UPDATE usuarios SET usuario = ? WHERE id = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, usuario);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
        out.println("Usuario actualizado exitosamente.");
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String query = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        out.println("Usuario eliminado exitosamente.");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet que maneja operaciones CRUD con la base de datos";
    }
}
