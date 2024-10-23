package com.example.demo.servletClass;

import com.example.demo.constants.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.time.LocalTime;

@Slf4j
@WebServlet(Paths.COOKIES)
public class HolaCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hora = LocalTime.now().toString();



        Cookie cookieHora = new Cookie("hora", hora);
        response.addCookie(cookieHora);

        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String horaCookies = "No hay cookies disponibles";
        if (cookies != null) {
            for (Cookie cookie1 : cookies) {
                if ("hora".equals(cookie1.getName())) {
                    horaCookies = cookie1.getValue();
                }
            }
        }

        try {
            response.getWriter().write("<html>" +
                    "<head>" +
                    "<meta charset='UTF-8'>" +
                    "<style>" +
                    "body { font-family: 'Arial', sans-serif; font-size: 3rem; background-color: #f0f0f0;" +
                    " text-align: center; } h1 { color: #3b3d3b; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); }" +
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
                    "<h1>¡Vamos a guardar tus cookies!</h1>" +
                    "<p>La hora de tus cookies es: " + horaCookies + "</p>" +
                    "<a href='/'>Volver a la página principal</a>" +
                    "</body>" +
                    "</html>");
        } catch (IOException e) {
            log.error("Error al procesar la solicitud: ", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");
        } catch (Exception e) {
            log.error("Se produjo un error inesperado: ", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error interno del servidor.");
        }
    }
}
