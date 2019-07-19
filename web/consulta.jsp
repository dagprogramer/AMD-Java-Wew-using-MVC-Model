
<%@page import="ar.com.entidades.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>




<html>
<head>
<title>Administrador de Alumnos</title>


 <script>
        <!--

                function validate(id) {
    
                    if (window.confirm ('EN VERDAD USTED ESTA SEGURO QUE DESE ELIMINAR ESTE REGISTRO ??? PIENSELO BIEN !!!')) {
                        window.location = 'AlumnoServlet?accion=eliminar&id='+id;
                    }
                }
                
                function find() {
    
                    var id = window.prompt ("Ingrese el numero del ID");
                    document.forms["data"]["id"].value = id;
                    document.forms["data"].submit ();
                }
        // -->            
        </script>


</head>

<body>

<H1>Consulta de Alumnos</H1>
<hr noshade color="#0000FF" size="3"><BR>

<BR>
<form name="data" method="POST" action="AlumnoServlet">
  Id: <input type="text" name="id" size="2"> Nombre:
  <input type="text" name="nombre" size="10"> Apellido:
  <input type="text" name="apellido" size="10">
  <input type="hidden" name="accion" value="consultar"/>
  <input type="submit" value="Buscar" name="enviar">
  
</form>
<br>
<a href="javascript:find();">Buscar pod ID</a>
<br>
<form method="POST" action="alta.jsp">
  <input type="submit" value="Ir a ventana Insertar" name="enviar">    
  
</form>

<hr noshade color="#0000FF" size="1">

  <table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="AutoNumber1">
    <tr>
      <td width="5%" bgcolor="#0000FF"><b><font color="#FFFFFF">#</font></b></td>
      <td width="5%" bgcolor="#0000FF"><b><font color="#FFFFFF">ID</font></b></td>
      <td width="20%" bgcolor="#0000FF"><b><font color="#FFFFFF">NOMBRE</font></b></td>
      <td width="20%" bgcolor="#0000FF"><b><font color="#FFFFFF">APELLIDO</font></b></td>
      <td width="10%" bgcolor="#0000FF"><b><font color="#FFFFFF">DNI</font></b></td>
      <td width="20%" bgcolor="#0000FF"><b><font color="#FFFFFF">DIRECCION</font></b></td>
      <td width="20%" bgcolor="#0000FF"><b><font color="#FFFFFF">ADMIN</font></b></td>
    </tr>
<%  
    ArrayList alumnos = (ArrayList) request.getAttribute("losAlumnos");
    
    if (alumnos != null) {
    // Informa los alumnos si hay al menos uno
    if( alumnos.size() != 0 )
    {
        // Variables
        Iterator it = alumnos.iterator();
        int contador = 0;
        
        // Informa los datos de cada alumno
        while( it.hasNext() )
        {
            contador++;
            Alumno elAlumno = (Alumno) it.next();
%>
            <tr>
                <td width="5%"><B><%=contador%>.</B></td>
                <td width="5%"><%=elAlumno.getId()%></td>
                <td width="20%"><%=elAlumno.getNombre()%></td>
                <td width="20%"><%=elAlumno.getApellido()%></td>
                <td width="10%"><%=elAlumno.getDni()%></td>
                <td width="20%"><%=elAlumno.getDireccion()%></td>
                
                <td width="20%">
                    <a href=AlumnoServlet?accion=modificar_init&id=<%=elAlumno.getId()%> >Modificar</a>
                    | 
                    <a href="javascript:validate(<%=elAlumno.getId()%>);">Eliminar</a>
                </td>
            </tr>
<%
        }
    }
    }
%>
    
  </table>
  <P align=left>
      <% if (alumnos != null) { %>
      <B><%=alumnos.size()%></B> alumnos encontrado(s)
      <% } %>
      
  </P>
  
</body>
</html>