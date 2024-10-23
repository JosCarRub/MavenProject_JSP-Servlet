<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Tabla de Multiplicar de la Hora Actual</title>
    <style>
            body {
                font-family: 'Roboto', Arial, sans-serif;
                text-align: center;
                background-color: #f0f4f8;
            }

            h1 {
                font-family: 'Roboto', Arial, sans-serif;
                background-color: #f0f4f8;
                color: #333;
                font-size: 2 rem;
                margin-bottom: 20px;
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
            }
            table {
                background-color: #f0f8f8;
                margin: auto;
                border-collapse: collapse;
                width: 50%;
            }
            th, td {
                border: 1px solid #000;
                padding: 10px;
                text-align: center;
            }
            th {
                background-color: #f2f2f2;
            }
            a {
               display: inline-block;
               margin-top: 20px;
               padding: 10px 20px;
               font-size: 1.5rem;
               color: #fff;
               background-color: #28a745;
               text-decoration: none; "
               border-radius: 5px;
               transition: background-color 0.3s, transform 0.3s;
               }
        </style>
</head>
<body>
    <h1>Tabla de Multiplicar de la Hora Actual</h1>

    <%

        Calendar calendar = Calendar.getInstance();
        int horaActual = calendar.get(Calendar.HOUR_OF_DAY);
        request.setAttribute("horaActual", horaActual);
    %>

    <table>
        <tr>
            <th>Multiplicador</th>
            <th>Resultado</th>
        </tr>
        <c:forEach var="i" begin="1" end="10">
            <tr>
                <td>${i} x ${horaActual}</td>
                <td>${i * horaActual}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href='/'>Volver a la página principal</a>
</body>
</html>
