package Modelo;

import java.util.ArrayList;

public class Asignatura {
    private String nombre;
    private String codigo;
    private String seccion;
    private String semestre;
    private int creditos;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asistencia> asistencias;

    public Asignatura(String nombre, String codigo, String seccion, String semestre, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.seccion = seccion;
        this.semestre = semestre;
        this.creditos = creditos;
        this.estudiantes = new ArrayList<>();
        this.asistencias = new ArrayList<>();
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getSemestre() {
        return semestre;
    }

    public int getCreditos() {
        return creditos;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    // Registro de los estudiante
    public boolean registrarEstudiante(Estudiante e) {
        for (Estudiante est : estudiantes) {
            if (est.getTipo().equalsIgnoreCase(e.getTipo()) &&
                    est.getCodigo().equalsIgnoreCase(e.getCodigo())) {
                return false; // Ya existe
            }
        }
        estudiantes.add(e);
        return true;
    }

    // Gestión de la asistencia
    public boolean crearListaAsistencia(String fecha, String horaInicio, String horaFinal) {
        for (Asistencia a : asistencias) {
            if (a.getFecha().equals(fecha) &&
                    a.getHoraInicio().equals(horaInicio) &&
                    a.getHoraFinal().equals(horaFinal)) {
                return false; // Ya existe
            }
        }
        Asistencia nueva = new Asistencia(fecha, horaInicio, horaFinal);
        for (Estudiante e : estudiantes) {
            nueva.agregarEstudiante(e.getTipo() + "-" + e.getCodigo());
        }
        asistencias.add(nueva);
        return true;
    }

    public Asistencia consultarAsistencia(String fecha, String horaInicio, String horaFinal) {
        for (Asistencia a : asistencias) {
            if (a.getFecha().equals(fecha) &&
                    a.getHoraInicio().equals(horaInicio) &&
                    a.getHoraFinal().equals(horaFinal)) {
                return a;
            }
        }
        return null;
    }
}
