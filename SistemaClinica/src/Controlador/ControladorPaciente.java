package Controlador;

import Modelo.ConexcionBaseDatos;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorPaciente {
    private ConexcionBaseDatos conexionBaseDatos;
    private Connection conexion;

    public ControladorPaciente() {
        conexionBaseDatos = new ConexcionBaseDatos();
        conexion = conexionBaseDatos.obtenerConexion();
    }

    public void crearPaciente(Paciente paciente) {
        try {
            String query = "INSERT INTO pacientes (nombre, apellido) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, paciente.getNombre());
            statement.setString(2, paciente.getApellido());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al crear el paciente");
            System.out.println(e);
        }
    }

    public Paciente leerPaciente(int id) {
        Paciente paciente = null;
        try {
            String query = "SELECT * FROM pacientes WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                paciente = new Paciente(
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido")
                );
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al leer el paciente");
            System.out.println(e);
        }
        return paciente;
    }

    public void actualizarPaciente(Paciente paciente, int id) {
        try {
            String query = "UPDATE pacientes SET nombre = ?, apellido = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, paciente.getNombre());
            statement.setString(2, paciente.getApellido());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al actualizar el paciente");
            System.out.println(e);
        }
    }

    public void eliminarPaciente(int id) {
        try {
            String query = "DELETE FROM pacientes WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocurrio un error al eliminar el paciente");
            System.out.println(e);
        }
    }
}

