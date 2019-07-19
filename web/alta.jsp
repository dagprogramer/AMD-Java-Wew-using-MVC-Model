


<%

%>

<html>
    <head>
        <title>Administrador de Alumnos</title>
        
        <script>
        <!--
                function validateForm() {
    var x = document.forms["data"]["nombre"].value;
    if (x == null || x == "") {
        alert("El nombre es obligatorio");
        return false;
    }
    
    var y = document.forms["data"]["apellido"].value;
    if (y == null || y == "") {
        alert("El apellido es obligatorio");
        return false;
    }
    
    var z = document.forms["data"]["dni"].value;
    if (z == null || z == "") {
        alert("El dni es obligatorio");
        return false;
    }
}
        // -->            
        </script>
    </head>
    
    <body>
        
        <H1>Alta de Alumnos</H1>
        <hr noshade color="#0000FF" size="3"><BR>
        
        <BR>
        <form id="data" method="POST" action="AlumnoServlet" 
              onsubmit="return validateForm()">
            <input type="hidden" name="accion" value="alta"/>
            <table>
               
                
                <tr>
                    <td>Nombre: </td>
                    <td><input type="text" name="nombre" size="20"> </td>
                </tr>
                <tr>
                    <td>Apellido: </td>
                    <td><input type="text" name="apellido" size="20"> </td>
                    
                </tr>
                <tr>
                    <td>DNI: </td>
                    <td><input type="text" name="dni" size="20"> </td>
                    
                </tr>
                <tr>
                    <td>Direccion: </td>
                    <td><input type="text" name="direccion" size="20"> </td>
                    
                </tr>
            </table>
            <hr>  
            <input type="submit" value="Enviar" name="enviar" > <a href=AlumnoServlet?accion=consultar>[Volver a consultar]</a>
            
            
        </form>
        
        
       
        
    </body>
</html>