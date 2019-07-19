/*
 * Alumno.java
 *
 *
 */
package ar.com.entidades;

import ar.com.conexion.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author diego guzman
 */
public class AlumnoDAO {

    // Atributos
   
    // Constructor
    public AlumnoDAO() {
    }

   
  
    // Obtiene un ArrayList con los alumnos que satisfacen el criterio de busqueda
    public static ArrayList getAlumnosPorCriterio(String unId, String unNombre, String unApellido) {
          // Instancia el contenedor de alumnos a retornar
            ArrayList losAlumnos = new ArrayList();
            Statement stmtConsulta = null;
            Connection conn=null;
            ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            // Si los paramentros vienen como null, les asigna ""
            if (unId == null) {
                unId = "";
            }
            if (unNombre == null) {
                unNombre = "";
            }
            if (unApellido == null) {
                unApellido = "";
            }
            
          
            
            // Obtiene los alumnos segun corresponda
            if (unId.equals("") && unNombre.equals("") && unApellido.equals("")) {
                losAlumnos = getTodos();
            } else {
                // Arma la consulta
                String laConsulta = "SELECT * FROM alumnos WHERE ";
                
                // Si el id no es vacio, lo agrega a la consulta
                if (!unId.equals("")) {
                    laConsulta += "alumno_id = " + unId + " AND ";
                }
                
                // Si el nombre no es vacio, lo agrega a la consulta
                if (!unNombre.equals("")) {
                    laConsulta += "nombre LIKE '" + unNombre + "%' AND ";
                }
                
                // Si el apellido no es vacio, lo agrega a la consulta
                if (!unApellido.equals("")) {
                    laConsulta += "apellido LIKE '" + unApellido + "%'";
                }
                
                // Si sobra la palabra AND en la consulta, la elimina
                String sobrante = laConsulta.substring(laConsulta.length() - 4, laConsulta.length());
                if (sobrante.equals("AND ")) {
                    laConsulta = laConsulta.substring(0, laConsulta.length() - 5);
                }
                
                // Establece la consulta y la ejecuta
                stmtConsulta = conn.createStatement();
                rs = stmtConsulta.executeQuery(laConsulta);
                
                // Obtiene los datos
                while (rs.next()) {
                    // Arma el objeto Alumno
                    Alumno elAlumno = new Alumno();
                    elAlumno.setId(rs.getInt("alumno_id"));
                    elAlumno.setNombre(rs.getString("nombre"));
                    elAlumno.setApellido(rs.getString("apellido"));
                    
                    elAlumno.setDni(rs.getString("dni"));
                    elAlumno.setDireccion(rs.getString("direccion"));
                    
                    // Agrega el alumno a la coleccion
                    losAlumnos.add(elAlumno);
                }
                
                // Cierra el Statement y la Connection
                
            }
            
            // Retorna los alumnos
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
                try {
                    
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        }
      return losAlumnos;  
    }

    // Obtiene un ArrayList con TODOS los alumnos
    public static ArrayList getTodos()  {
        
            ArrayList losAlumnos = new ArrayList();
            Statement stmtConsulta = null;
            Connection conn=null;
            ResultSet rs = null;
            
        try {
            conn = ConnectionManager.getConnection();
            
            // Arma la consulta y la ejecuta
            String laConsulta = "SELECT * FROM alumnos";
            stmtConsulta = conn.createStatement();
            rs = stmtConsulta.executeQuery(laConsulta);
            
            // Obtiene los datos
            while (rs.next()) {
                // Arma el objeto Alumno
                Alumno elAlumno = new Alumno();
                elAlumno.setId(rs.getInt("alumno_id"));
                elAlumno.setNombre(rs.getString("nombre"));
                elAlumno.setApellido(rs.getString("apellido"));
                elAlumno.setDni(rs.getString("dni"));
                    elAlumno.setDireccion(rs.getString("direccion"));
                
                // Agrega el alumno a la coleccion
                losAlumnos.add(elAlumno);
            }
            
            // Cierra el Statement y la Connection
           // stmtConsulta.close();
            
            // Retorna el alumno
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
                try {
                    stmtConsulta.close();
                    rs.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        }
            return losAlumnos;
    }

    // Obtiene el Alumno que satisface el criterio de busqueda, o null si no hay ninguno
    public static Alumno getSegunID(int unId)  {
        
            Alumno elAlumno = null;
            Statement stmtConsulta = null;
            Connection conn=null;
            ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            // Arma la consulta y la ejecuta
            String laConsulta = "SELECT * FROM alumnos WHERE alumno_id = " + unId;
            stmtConsulta = conn.createStatement();
            rs = stmtConsulta.executeQuery(laConsulta);
           
            
            // Obtiene los datos
            if (rs.next()) {
                // Arma el objeto Alumno a retornar
                elAlumno = new Alumno();
                elAlumno.setId(rs.getInt("alumno_id"));
                elAlumno.setNombre(rs.getString("nombre"));
                elAlumno.setApellido(rs.getString("apellido"));
                elAlumno.setDni(rs.getString("dni"));
                    elAlumno.setDireccion(rs.getString("direccion"));
            }
            
            // Cierra el Statement y la Connection
            stmtConsulta.close();
            
            // Retorna el alumno
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
                try {
                    stmtConsulta.close();
                    rs.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        }
        return elAlumno;
    }

    // Inserta un alumno 
    public static void insertar(Alumno alumno) {
            Statement stmtInsercion = null;
            Connection conn=null;
        try {
            conn = ConnectionManager.getConnection();
            // Arma la sentencia de inserción y la ejecuta
            String laInsercion = "INSERT INTO alumnos (alumno_id, nombre, apellido, dni, direccion) VALUES (" + alumno.getId() + ", '" + alumno.getNombre() + "', '" + alumno.getApellido() + "', '" + alumno.getDni() + "', '" + alumno.getDireccion() + "')";
            stmtInsercion = conn.createStatement();
            stmtInsercion.execute(laInsercion);
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally{
                try {
                    stmtInsercion.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        }
    }

    // Actualiza un alumno 
    public static void actualizar(Alumno alumno) {
            Statement stmtActualizacion = null;
            Connection conn=null;
        try {
            conn = ConnectionManager.getConnection();
            // Arma la sentencia de actualizacion y la ejecuta
            String laActualizacion = "UPDATE alumnos SET direccion='" + alumno.getDireccion () + "', dni='" + alumno.getDni() + "', apellido = '" + alumno.getApellido() + "', nombre = '" + alumno.getNombre() + "' WHERE alumno_id = " + alumno.getId();
            stmtActualizacion = conn.createStatement();
            stmtActualizacion.execute(laActualizacion);
                       
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally{
                try {
                    stmtActualizacion.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        }
    }

    // Elimina un alumno 
    public static void eliminar(int id)  {
            Statement stmtEliminacion = null;
            Connection conn=null;
        try {
            conn = ConnectionManager.getConnection();
            // Arma la sentencia de actualizacion y la ejecuta
            String laEliminacion = "DELETE FROM alumnos WHERE alumno_id = " + id;
            stmtEliminacion = conn.createStatement();
            stmtEliminacion.execute(laEliminacion);
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }  finally{
                try {
                    stmtEliminacion.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        }
    }

  
}
