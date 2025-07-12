package Controlador;

import Modelo.ConexcionBaseDatos;
import Modelo.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorMedico {
    private ConexcionBaseDatos conexionBaseDatos;
    private Connection conexion;

    public ControladorMedico() {
        conexionBaseDatos = new ConexcionBaseDatos();
        conexion = conexionBaseDatos.obtenerConexion();
    }

    public void crearMedico(Medico medico) {
        try {
            String query = "INSERT INTO medicos (nombre, apellido, especialidad, turno) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, medico.getNombre());
            statement.setString(2, medico.getApellido());
            statement.setString(3, medico.getEspecialidad());
            statement.setString(4, medico.getTurno());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al crear el medico");
            System.out.println(e);
        }
    }

    public Medico leerMedico(int id) {
        Medico medico = null;
        try {
            String query = "SELECT * FROM medicos WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                medico = new Medico(
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("especialidad"),
                        resultSet.getString("turno")
                );
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al leer el medico");
            System.out.println(e);
        }
        return medico;
    }

    public void actualizarMedico(Medico medico) {
        try {
            String query = "UPDATE medicos SET nombre = ?, apellido = ?, especialidad = ?, turno = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, medico.getNombre());
            statement.setString(2, medico.getApellido());
            statement.setString(3, medico.getEspecialidad());
            statement.setString(4, medico.getTurno());
            // statement.setInt(5, medico.getId()); // falta el id en la clase Medico
            // statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al actualizar el medico");
            System.out.println(e);
        }
    }

    public void eliminarMedico(int id) {
        try {
            String query = "DELETE FROM medicos WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al eliminar el medico");
            System.out.println(e);
        }
    }
}


