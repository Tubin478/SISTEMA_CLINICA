
package Modelo;
import java.sql.*;

public class ConexcionBaseDatos {
      Connection conexion = null;
    String database = "clinica";
    String url = "jdbc:mysql://localhost:3306/" + database;
    String usuario = "root";
    String clave = "020592";

    public Connection obtenerConexion() {
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException e) {
            System.out.println("Ocurrio un erro al conectarse a la base de datos " + database);
            System.out.println(e);
        } 

        return conexion;
    }  
}
