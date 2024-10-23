package com.example.demo.servletClass;

import com.example.demo.constants.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(Paths.CERRARSESION)
public class CerrarSesionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {

        HttpSession session = request.getSession(false);

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        if (session != null) {

            session.invalidate();
            log.info("Sesión cerrada exitosamente.");

            response.getWriter().write("<html>" +
                    "<head>" +
                    "<meta charset='UTF-8'>" +
                    "<title>Cookies</title>" +
                    "<style>" +
                    "body { " +
                    "    font-family: 'Arial', sans-serif; " +
                    "    background-color: #f4f4f4; " +
                    "    color: #333; " +
                    "    text-align: center; " +
                    "    padding: 50px; " +
                    "}" +
                    "h1 { " +
                    "    font-size: 2.5rem; " +
                    "    color: #d9534f; " +
                    "    margin-bottom: 20px; " +
                    "}" +
                    "p { " +
                    "    font-size: 1.5rem; " +
                    "    margin-bottom: 30px; " +
                    "}" +
                    "a { " +
                    "    display: inline-block; " +
                    "    padding: 10px 20px; " +
                    "    font-size: 1.5rem; " +
                    "    color: #fff; " +
                    "    background-color: #5bc0de; " + // Color de fondo azul
                    "    text-decoration: none; " +
                    "    border-radius: 5px; " +
                    "    transition: background-color 0.3s, transform 0.3s; " +
                    "}" +
                    "a:hover { " +
                    "    background-color: #31b0d5; " +
                    "    transform: translateY(-2px); " +
                    "}" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<h1>¡Sesión Cerrada!</h1>" +
                    "<p>Has cerrado sesión exitosamente.</p>" +
                    "<a href='/holamundo'>Volver a la página anterior</a>" +
                    "<br> <br>" +
                    "<a href='/cerrarsesion'>Comprobar</a>" +
                    "</body>" +
                    "</html>");
        } else {
            log.warn("No hay sesión activa para cerrar.");
            response.getWriter().write("<html>" +
                    "<head>" +
                    "<meta charset='UTF-8'>" +
                    "<title>Sin Sesión</title>" +
                    "<style>" +
                    "body { " +
                    "    font-family: 'Arial', sans-serif; " +
                    "    background-color: #f4f4f4; " +
                    "    color: #333; " +
                    "    text-align: center; " +
                    "    padding: 50px; " +
                    "    margin: 0; " +
                    "} " +
                    "h1 { " +
                    "    font-size: 2.5rem; " +
                    "    color: #d9534f; " +
                    "    margin-bottom: 20px; " +
                    "} " +
                    "p { " +
                    "    font-size: 1.5rem; " +
                    "    margin-bottom: 30px; " +
                    "} " +
                    "a { " +
                    "    display: inline-block; " +
                    "    padding: 10px 20px; " +
                    "    font-size: 1.5rem; " +
                    "    color: #fff; " +
                    "    background-color: #5bc0de; " +
                    "    text-decoration: none; " +
                    "    border-radius: 5px; " +
                    "    transition: background-color 0.3s, transform 0.3s; " +
                    "} " +
                    "a:hover { " +
                    "    background-color: #31b0d5; " +
                    "    transform: translateY(-2px); " +
                    "} " +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<h1>No hay sesión activa</h1>" +
                    "<p>No hay sesión activa para cerrar.</p>" +
                    "<a href=" + "/holamundo" + ">Volver a la página principal</a>" +
                    "</body></html>");
        }
    }
}
