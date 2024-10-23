package com.example.demo.servletClass;

import com.example.demo.constants.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebServlet(Paths.SALUDAME)
public class SaludameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            if (nombre != null && !nombre.isEmpty()) {
                response.getWriter().write("<html>" +
                        "<head>" +
                        "<meta charset='UTF-8'>" +
                        "<style>" +
                        "body { font-family: 'Arial', sans-serif; font-size: 3.5rem; background-color: #f0f0f0; text-align: center; }" +
                        "h1 { color: #3b3d3b; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); }" +
                        "p { font-size: 2rem; color: #555; }" +
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
                        "<body>" +
                        "<h1>¡Hola " + nombre + "!</h1>" +
                        "<p>Encantado de saludarte</p>" +
                        "<a href='/'>Volver a la página principal</a>" +
                        "</body>" +
                        "</html>");
            } else {

                response.getWriter().write("<html>" +
                        "<head>" +
                        "<meta charset='UTF-8'>" +
                        "<style>" +
                        "body { font-family: 'Arial', sans-serif; font-size: 3.5rem; background-color: #f0f0f0; text-align: center; }" +
                        "h1 { color: #3b3d3b; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); }" +
                        "p { font-size: 1.6rem; color: #555; }" +
                                "form { " +
                                "    background-color: #ffffff; " +
                                "    padding: 20px; " +
                                "    border-radius: 10px; " +
                                "    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); " +
                                "    display: inline-block; " +
                                "    margin-top: 20px; " +
                                "} " +
                                "label { " +
                                "    font-size: 1.5rem; " +
                                "    display: block; " +
                                "    margin-bottom: 10px; " +
                                "} " +
                                "input[type='text'] { " +
                                "    font-size: 1.5rem; " +
                                "    padding: 10px; " +
                                "    border: 1px solid #ccc; " +
                                "    border-radius: 5px; " +
                                "    width: 100%; " +
                                "    box-sizing: border-box; " +
                                "} " +
                                "button { " +
                                "    font-size: 1.5rem; " +
                                "    padding: 10px 15px; " +
                                "    border: none; " +
                                "    border-radius: 5px; " +
                                "    background-color: #4CAF50; " +
                                "    color: white; " +
                                "    cursor: pointer; " +
                                "    margin-top: 15px; " +
                                "} " +
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
                        "<body>" +
                        "<h1>¡Hola!</h1>" +
                        "<p>Si quieres que te envíe un saludo personalizado introduce tu nombre</p>" +
                        "<form action='/saludame' method='GET'>" +
                        "<label for='nombre'>Nombre:</label>" +
                        "<input type='text' id='nombre' name='nombre' required>" +
                        "<button type='submit'>Enviar</button>" +
                        "</form> <br>" +
                        "<a href='/'>Volver a la página principal</a>" +
                        "</body>" +
                        "</html>"
                );
            }
            log.info("Todo marcha bien en /saludame");

        } catch (IOException e) {

            log.error("Error al procesar la solicitud: ", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");

        } catch (Exception e) {

            log.error("Se produjo un error inesperado: ", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor.");

        }
    }

}

