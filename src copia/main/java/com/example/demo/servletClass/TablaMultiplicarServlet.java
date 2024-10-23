package com.example.demo.servletClass;

import com.example.demo.constants.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Date;


@Slf4j
@WebServlet(Paths.TABLAMULTIPLICAR)
public class TablaMultiplicarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date now = new Date();
        try {

            log.info("Petición recibida en /tablamultiplicar. Fecha y hora actual: {}", now);


            request.setAttribute("Ahora", now);


            request.getRequestDispatcher("/jsp/tablamultiplicar.jsp").forward(request, response);


            log.info("Redirección al JSP /jsp/tablamultiplicar.jsp realizada con éxito.");

        } catch (IOException ioException) {

            log.error("Error al procesar la solicitud para /tablamultiplicar", ioException);
            throw new ServletException("Error en el servlet /tablamultiplicar", ioException);
        }
    }



}