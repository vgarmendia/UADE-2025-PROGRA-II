//Paciente.java

package modelo;

public class Paciente {
    private String nombre;
    private Urgencia urgencia;

    public Paciente(String nombre, Urgencia urgencia) {
        this.nombre = nombre;
        this.urgencia = urgencia;
    }

    public String getNombre() {
        return nombre;
    }

    public Urgencia getUrgencia() {
        return urgencia;
    }
}
