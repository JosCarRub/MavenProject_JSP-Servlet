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
import java.util.Date;

@Slf4j
@WebServlet(Paths.HOLAMUNDO)
public class HolaMundoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date now = new Date();

        HttpSession session = request.getSession();
        session.setAttribute("horaActual", now);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            HttpSession sessionExistente = request.getSession(false);
            if (sessionExistente != null) {
                Date horaAlmacenada = (Date) sessionExistente.getAttribute("horaActual");

                if (horaAlmacenada != null) {
                    response.getWriter().write("<html>" +
                            "<head>" +
                            "<meta charset='UTF-8'>" +
                            "<style>" +
                            "body { font-family: 'Arial', sans-serif; font-size: 3.5rem; background-color: #f0f0f0; text-align: center; }" +
                            "h1 { color: #3b3d3b; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); }" +
                            "p { font-size: 1.6rem; color: #555; }" +
                            "a { " +
                            "    display: inline-block; " +
                            "    margin-top: 20px; " +
                            "    padding: 10px 20px; " +
                            "    font-size: 1.5rem; " +
                            "    color: #fff; " +
                            "    background-color: #28a745; " +
                            "    text-decoration: none; " +
                            "    border-radius: 5px; " +
                            "    transition: background-color 0.3s, transform 0.3s; " +
                            "}" +
                            "a:hover { " +
                            "    background-color: #218838; " +
                            "    transform: translateY(-2px); " +
                            "}" +
                            "</style>" +
                            "</head>" +
                            "<body><h1>¡Hola Mundo desde el servlet!</h1>" +
                            "<p>La hora actual almacenada en la sesión es: " + horaAlmacenada + "</p>" +
                            "<a href=" + "/cerrarsesion" + ">Cerrar Sesión</a>" +
                            "<br>" +
                            "<a href='/'>Volver a la página principal</a>" +
                            "</body></html>");
                } else {
                    response.getWriter().write("<html>" +
                            "<head>" +
                            "<meta charset='UTF-8'>" +
                            "<style>" +
                            "body { font-family: 'Arial', sans-serif; font-size: 3.5rem; background-color: #f0f0f0; text-align: center; }" +
                            "h1 { color: #3b3d3b; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); }" +
                            "p { font-size: 1.6rem; color: #555; }" +
                            "a { " +
                            "    display: inline-block; " +
                            "    margin-top: 20px; " +
                            "    padding: 10px 20px; " +
                            "    font-size: 1.5rem; " +
                            "    color: #fff; " +
                            "    background-color: #28a745; " +
                            "    text-decoration: none; " +
                            "    border-radius: 5px; " +
                            "    transition: background-color 0.3s, transform 0.3s; " +
                            "}" +
                            "</style>" +
                            "</head>" +
                            "<body><h1>¡Hola!</h1>" +
                            "<p>No hay hora almacenada en la sesión.</p>" +
                            "<a href='/'>Volver a la página principal</a>" +
                            "</body></html>");
                }
            }
            log.info("Todo marcha bien en /holamundo");
            log.info("Hora actual almacenada en la sesión: {}", now);

        } catch (IOException e) {

            log.error("Error de entrada/salida al procesar la solicitud: ", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");

        } catch (Exception e) {

            log.error("Se produjo un error inesperado: ", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor.");

        }

    }
}
