


<%@page import="ar.com.entidades.Alumno"%>
<%
 Alumno alumno = (Alumno) request.getAttribute("elAlumno");
%>

<html>
    <head>
        <title>Administrador de Alumnos</title>
    </head>
    
    <body>
        
        <H1>Alta de Alumnos</H1>
        <hr noshade color="#0000FF" size="3"><BR>
        
        <BR>
        <form method="POST" action="AlumnoServlet">
            <input type="hidden" name="accion" value="modificar"/>
            <input type="hidden" name="id" value='<%=alumno.getId()%>'  />
            <table>
               
                
                <tr>
                    <td>Nombre: </td>
                    <td><input type="text" name="nombre" size="20" value='<%=alumno.getNombre()%>'> </td>
                </tr>
                <tr>
                    <td>Apellido: </td>
                    <td><input type="text" name="apellido" size="20" value='<%=alumno.getApellido()%>'> </td>
                    
                </tr>
            </table>
            <hr>  
            <input type="submit" value="Enviar" name="enviar" > <a href=AlumnoServlet?accion=consultar>[Volver a consultar]</a>
            
            
        </form>
        
        
       
        
    </body>
</html>