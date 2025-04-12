package Modelo;

import java.util.ArrayList;

public class Asistencia {
    private String fecha;
    private String horaInicio;
    private String horaFinal;
    private ArrayList<String> codigos;
    private ArrayList<String> estados;

    public Asistencia(String fecha, String horaInicio, String horaFinal) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.codigos = new ArrayList<>();
        this.estados = new ArrayList<>();
    }

    // Getters
    public String getFecha() {
        return fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public ArrayList<String> getCodigos() {
        return codigos;
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    // Agregar estudiante a la lista de asistencia con estado por defecto "AUSENTE"
    public void agregarEstudiante(String claveEstudiante) {
        codigos.add(claveEstudiante);
        estados.add("AUSENTE");
    }

    // Modificar estado de asistencia para un estudiante
    public boolean modificarAsistencia(String claveEstudiante, String nuevoEstado) {
        for (int i = 0; i < codigos.size(); i++) {
            if (codigos.get(i).equals(claveEstudiante)) {
                estados.set(i, nuevoEstado.toUpperCase());
                return true;
            }
        }
        return false;
    }
}
