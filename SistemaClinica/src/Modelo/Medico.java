
package Modelo;


public class Medico {
   private String nombre,apellido,especialidad,turno;

    public Medico(String nombre, String apellido, String especialidad, String turno) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
   
   
}
